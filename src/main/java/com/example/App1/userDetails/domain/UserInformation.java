
package com.example.App1.userDetails.domain;

import com.example.App1.accounts.domain.Account;
import com.example.App1.accounts.domain.TransactionHistory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "UserInformation")
public class UserInformation {

    @Id

    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", updatable = false, nullable = true)
    private String firstName;

    @Column(name = "last_name", updatable = false, nullable = false)
    private String lastName;

    @Column(name = "gender", updatable = false, nullable = false)
    private String gender;

    @Column(name = "email", updatable = true, nullable = false)
    private String email;

    @Column(name = "phone_no", updatable = true, nullable = false)
    private Long phoneNo;

    @Column(name = "address", updatable = true, nullable = false)
    private String address;



    @Column(name = "account_number", updatable = false, nullable = false)
    private Long accountNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "account_created_date", updatable = false, nullable = false)
    private Date accountCreatedDate;

    @Column(name = "account_status", updatable = true, nullable = false)
    private String accountStatus;

    @Column(name = "account_balance", updatable = true, nullable = true)
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "userInformation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "userInformation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TransactionHistory> transactionHistories = new HashSet<>();



    // Default constructor
    public UserInformation() {
        super();
    }

    // Parameterized constructor
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

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
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
        this.phoneNo = phoneNo;
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<TransactionHistory> getTransactionHistories() {
        return transactionHistories;
    }

    public void setTransactionHistories(Set<TransactionHistory> transactionHistories) {
        this.transactionHistories = transactionHistories;
    }



    public void addAccount(Account account) {
        accounts.add(account);
        account.setUserInformation(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.setUserInformation(null);
    }
}
