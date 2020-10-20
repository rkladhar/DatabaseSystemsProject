package com.railway.entity;


import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "ticket")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "train_no")
    private Long trainNo;

    @Column(name = "date_of_booking")
    private LocalDate dateOfBooking;

    @OneToMany
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    public Set<Passenger> passenger;
}
