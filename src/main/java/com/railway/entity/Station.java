package com.railway.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "station")
public class Station implements Serializable {

    @Id
    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "station_name")
    private String stationName;
}
