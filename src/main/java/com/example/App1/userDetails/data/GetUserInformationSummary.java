package com.example.App1.userDetails.data;

import java.math.BigDecimal;
import java.util.Date;

public class GetUserInformationSummary {
    final private String firstName ;
    final   private String lastName ;

    final private String gender ;

    final  private String email ;
    final  private Long phoneNo;

    final  private String address;

    final  private Long accountNumber ;

    final  private Date accountCreatedDate;

    final  private  String accountStatus ;

    final private BigDecimal accountBalance;



    public GetUserInformationSummary(String firstName, String lastName, String gender, String email, Long phoneNo, String address, Long accountNumber, Date accountCreatedDate, String accountStatus, BigDecimal accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.accountNumber = accountNumber;
        this.accountCreatedDate = accountCreatedDate;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}
