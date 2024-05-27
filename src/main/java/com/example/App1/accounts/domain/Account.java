package com.example.App1.accounts.domain;


import com.example.App1.userDetails.domain.UserInformation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Account")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @Column(name = "accountNumber", nullable = false)
    private Long accountNumber;

    @Column(name = "accountCreatedDate", nullable = false)
    private Date accountCreatedDate;

    @Column(name = "accountStatus", nullable = false)
    private String accountStatus;

    @Column(name = "accountBalance", nullable = true , updatable = true)
    private BigDecimal accountBalance;


    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private UserInformation userInformation ;

    Account()
    {
        super();
    }
    public Account( Long accountNumber, Date accountCreatedDate, String accountStatus, BigDecimal accountBalance, UserInformation userInformation) {

        this.accountNumber = accountNumber;
        this.accountCreatedDate = accountCreatedDate;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.userInformation = userInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}
