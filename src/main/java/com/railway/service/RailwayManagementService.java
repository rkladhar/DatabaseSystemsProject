package com.railway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.railway.dao.*;
import com.railway.entity.*;
import com.railway.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class RailwayManagementService
{
    @Autowired IStationDAO iStationDAO;
    @Autowired ITrainDAO iTrainDAO;
    @Autowired IUserDAO iUserDAO;
    @Autowired ITicketDAO iTicketDAO;
    @Autowired IPassengerDAO iPassengerDAO;
    @Autowired
    ITrainAdditionalInfoDAO iTrainAdditionalInfoDAO;

    public String createNewUser(NewUserDetails newUserDetails) throws Exception
    {
        int count = iUserDAO.countUserByEmailIdOrUserName(newUserDetails.getEmailId(), newUserDetails.getUserName());
        if(count > 0){
            return "failure";
        }
        else{
            User userDetails = User.builder().firstName(newUserDetails.getFirstName()).lastName(newUserDetails.getLastName()).
                    phoneNo(newUserDetails.getPhoneNo()).emailId(newUserDetails.getEmailId()).address(newUserDetails.getAddress()).
                    city(newUserDetails.getCity()).state(newUserDetails.getState()).zipCode(newUserDetails.getZipCode()).
                    userName(newUserDetails.getUserName()).password(newUserDetails.getPassword()).build();
            try{
                iUserDAO.save(userDetails);
                return "success";
            }catch(Exception e){
                throw new Exception("Could not create new user", e);
            }
        }
    }

    public Long login(UserCredentials userCredentials)
    {
        int count = iUserDAO.countUserByUserNameAndPassword(userCredentials.getUserName(), userCredentials.getPassword());
        if(count > 0){
            User user = iUserDAO.findUserByUserName(userCredentials.getUserName());
            return user.getUserId();
        }
        else{
            return null;
        }
    }

    public List<Station> getStationList(String searchText)
    {
        List<Station> stationList = iStationDAO.findStationsByStationNameStartsWith(searchText);
        return stationList;
    }

    public List<TrainResult> getTrainList(Long departureStationId, Long arrivalStationId, LocalDate dateOfJourney)
    {
        List<TrainResult> list= iTrainDAO.getTrains(departureStationId, arrivalStationId, dateOfJourney);
        return list;
    }

    public List<Ticket> getExistingOrPastBookingInformation(Long userId)
    {
        List<Ticket> ticketList = iTicketDAO.getTicketsByUserId(userId);
        return ticketList;
    }

    public String deletePassengerBooking(Long passengerId) throws Exception
    {
        try{
            iPassengerDAO.deleteById(passengerId);
            return "success";
        }
        catch(Exception e){
            throw new Exception("Error deleting Passenger Booking", e);
        }
    }

    public String cancelBooking(Long ticketId) throws Exception
    {
        try{
            iPassengerDAO.deletePassengersByTicketId(ticketId);
            iTicketDAO.deleteById(ticketId);
            return "success";
        }catch(Exception e){
            throw new Exception("Error in cancelling booking", e);
        }
    }

    public Ticket bookTickets(BookingInformation bookingInformation) throws Exception{
        try {
            Ticket bookingDetails = Ticket.builder().userId(bookingInformation.getUserId()).trainNo(bookingInformation.getTrainNo()).
                    dateOfBooking(bookingInformation.getDateOfBooking()).build();
            Ticket ticket = iTicketDAO.save(bookingDetails);

            List<Passenger> passengerList = new ArrayList<>();
            for (PassengerInformation passengerInformation : bookingInformation.getPassengerInformationList()) {
                Passenger passenger = Passenger.builder().firstName(passengerInformation.getFirstName()).
                        lastName(passengerInformation.getLastName()).emailId(passengerInformation.getEmailId()).
                        phoneNo(passengerInformation.getPhoneNo()).gender(passengerInformation.getGender()).
                        age(passengerInformation.getAge()).userId(bookingInformation.getUserId())
                        .ticketId(ticket.getTicketId()).build();
                passengerList.add(passenger);
            }
            iPassengerDAO.saveAll(passengerList);
            iTrainAdditionalInfoDAO.updateAvailableSeats(passengerList.size(), bookingInformation.getTrainNo(), bookingInformation.getDateOfJourney());
            return ticket;
        }catch(Exception e){
            throw new Exception("Error saving new booking", e);
        }
    }

    public Ticket getTicketById(Long ticketId)
    {
        Ticket ticket = iTicketDAO.getTicketByTicketId(ticketId);
        return ticket;
    }

}
