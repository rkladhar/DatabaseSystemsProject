package com.railway.controller;

import com.railway.entity.Passenger;
import com.railway.entity.Ticket;
import com.railway.service.RailwayManagementService;
import com.railway.entity.Station;
import com.railway.entity.Train;
import com.railway.vo.BookingInformation;
import com.railway.vo.NewUserDetails;
import com.railway.vo.TrainResult;
import com.railway.vo.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RailwayManagementController
{
   @Autowired
    RailwayManagementService railwayManagementService;

    @PostMapping("/api/create/user")
    public String createNewUser(@RequestBody NewUserDetails newUserDetails) throws Exception
    {
        return railwayManagementService.createNewUser(newUserDetails);
    }

    @PostMapping("api/login")
    public Long login(@RequestBody UserCredentials userCredentials)
    {
        return railwayManagementService.login(userCredentials);
    }

    @GetMapping("/api/station-list")
    public List<Station> getStationList(@RequestParam String searchText)
    {
        return railwayManagementService.getStationList(searchText);
    }

    @GetMapping("api/train-list")
    public List<TrainResult> getTrainList(@RequestParam Long departureStationId, @RequestParam Long arrivalStationId,
                                          @RequestParam String dateOfJourney)
    {
        LocalDate dateTime = ZonedDateTime.parse(dateOfJourney).toLocalDate();
        return railwayManagementService.getTrainList(departureStationId, arrivalStationId, dateTime);
    }

    @GetMapping("api/get/bookings/list")
    public List<Ticket> getExistingOrPastBookingInformation(@RequestParam Long userId)
    {
        return railwayManagementService.getExistingOrPastBookingInformation(userId);
    }

    @DeleteMapping("api/delete/passenger/booking")
    public String deletePassengerBooking(@RequestParam Long passengerId) throws Exception
    {
        return railwayManagementService.deletePassengerBooking(passengerId);
    }

    @DeleteMapping("api/cancel/booking")
    public String cancelBooking(@RequestParam Long ticketId) throws Exception
    {
        return railwayManagementService.cancelBooking(ticketId);
    }

    @PostMapping("/api/book/tickets")
    public Ticket bookTickets(@RequestBody BookingInformation bookingInformation) throws Exception
    {
        return railwayManagementService.bookTickets(bookingInformation);
    }

    @GetMapping("/api/get/ticketById")
    public Ticket getTicketById(@RequestParam Long ticketId)
    {
        return railwayManagementService.getTicketById(ticketId);
    }
}
