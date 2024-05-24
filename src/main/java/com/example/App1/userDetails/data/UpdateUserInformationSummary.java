package com.example.App1.userDetails.data;

import java.util.Date;

public class UpdateUserInformationSummary {
    final  private Long id ;
    final private String firstName ;
    final   private String lastName ;

    final private String gender ;

    final  private String email ;
    final  private Long phoneNo;

    final  private String address;


    final  private Date accountCreatedDate;

    public UpdateUserInformationSummary(Long id, String firstName, String lastName, String gender, String email, Long phoneNo, String address, Date accountCreatedDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.accountCreatedDate = accountCreatedDate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }


    public String getEmail() {
        return email;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }
}
