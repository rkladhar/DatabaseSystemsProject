package com.railway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "passenger")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_no")
    private Long phoneNo;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;
}
