package com.railway.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainResult implements Serializable
{
    @Id
    @Column(name= "train_no")
    private Long trainNo;

    @Column(name= "train_name")
    private String trainName;
    @Column(name= "arrival_station_id")

    private Long arrival_station_id;
    @Column(name= "departure_station_id")

    private Long departure_station_id;
    @Column(name= "arrival_time")

    private Time arrivalTime;
    @Column(name= "departure_time")

    private Time departureTime;
    @Column(name= "available_seats")

    private Integer availableSeats;
    @Column(name= "ticket_price")

    private Double ticketPrice;
    @Column(name= "date_of_journey")

    private LocalDate dateOfJourney;
}
