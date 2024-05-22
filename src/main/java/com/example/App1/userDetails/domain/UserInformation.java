package com.example.App1.userDetails.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;



@Entity
@Table(name = "UserInformation")
public class UserInformation {


    @Id
    @Column(name = "id" , updatable = false , nullable = false)
    private Long id ;


    @Column(name = "firstName" , updatable = false , nullable = true)
    private String firstName ;


    @Column(name = "lastName" , updatable = false , nullable = false)
    private String lastName ;


    @Column(name = "gender" , updatable = false , nullable = false)
    private String gender ;


    @Column(name = "email" , updatable = false , nullable = false)
    private String email ;


    @Column(name = "phoneNo" , updatable = true , nullable = false)
    private Long phoneNo ;

    @Column(name = "address" , updatable = true , nullable = false)
    private  String address  ;



    @Column(name = "accountNumber" , updatable = false , nullable = false)
    private Long accountNumber ;


    @Column(name = "accountCreatedDate" , updatable = false , nullable = false)
    private Date accountCreatedDate ;


    @Column(name = "accountStatus" , updatable = true , nullable = false)
    private String accountStatus ;


    @Column(name = "accountBalance" , updatable = true , nullable = true)
    private BigDecimal accountBalance ;

    UserInformation()
    {
        super();
    }

    public UserInformation(Long id, String firstName, String lastName, String gender, String email, Long phoneNo, String address, Long accountNumber, Date accountCreatedDate, String accountStatus, BigDecimal accountBalance) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getAccountCreatedDate() {
        return accountCreatedDate;
    }

    public void setAccountCreatedDate(Date accountCreatedDate) {
        this.accountCreatedDate = accountCreatedDate;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
