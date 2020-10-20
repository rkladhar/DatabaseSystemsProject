package com.railway.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainAdditionalInfoCompositeKey implements Serializable
{
    @Column(name = "train_no")
    private Long trainNo;

    @Column(name = "date_of_journey")
    private LocalDate dateOfJourney;
}
