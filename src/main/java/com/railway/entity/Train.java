package com.railway.entity;

import lombok.Data;
import org.joda.time.LocalTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

@Data
@Entity
@Table(name = "train")
public class Train implements Serializable {

    @Id
    @Column(name = "train_no")
    private Long trainNo;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "arrival_station_id")
    private Long arrivalStationId;

    @Column(name = "departure_station_id")
    private Long departureStationId;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "departure_time")
    private Time departureTime;

    @OneToMany
    @JoinColumn(name = "train_no", referencedColumnName = "train_no")
    public Set<TrainAdditionalInfo> trainAdditionalInfos;

}
