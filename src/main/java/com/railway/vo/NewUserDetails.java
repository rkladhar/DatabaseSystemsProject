package com.railway.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NewUserDetails
{
    private String firstName;

    private String lastName;

    private Long phoneNo;

    private String emailId;

    private String address;

    private String city;

    private String state;

    private Integer zipCode;

    private String userName;

    private String password;
}
