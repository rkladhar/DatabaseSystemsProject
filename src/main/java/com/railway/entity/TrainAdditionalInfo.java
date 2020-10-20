package com.railway.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trainadditionalinfo")
public class TrainAdditionalInfo
{
    @EmbeddedId
    private TrainAdditionalInfoCompositeKey trainAdditionalInfoCompositeKey;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "ticket_price")
    private Double ticketPrice;
}
