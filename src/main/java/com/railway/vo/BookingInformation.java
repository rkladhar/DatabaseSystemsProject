package com.railway.vo;

import lombok.Data;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
public class BookingInformation
{
    private Long userId;
    private Long trainNo;
    private LocalDate dateOfBooking;
    private LocalDate dateOfJourney;
    private List<PassengerInformation> passengerInformationList;
}
