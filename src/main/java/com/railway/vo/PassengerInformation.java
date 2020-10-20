package com.railway.vo;

import lombok.Data;

@Data
public class PassengerInformation
{
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNo;
    private String gender;
    private Integer age;
}
