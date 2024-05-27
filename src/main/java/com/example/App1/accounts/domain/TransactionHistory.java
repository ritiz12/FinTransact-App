package com.example.App1.accounts.domain;

import com.example.App1.userDetails.domain.UserInformation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TransactionHistory")
public class TransactionHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TransactionId ;


    @Column(name = "accountNumber", nullable = false)
    private Long accountNumber;

    @Column(name = "toAccountNumber", nullable = false)
    private Long toAccountNumber;
    @Column(name = "transactionDate", nullable = false)
    private Date transactionDate;

    @Column(name = "transactionStatus", nullable = false)
    private String transactionStatus;

    @Column(name = "transferAmount", nullable = true , updatable = true)
    private BigDecimal transferAmount;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private UserInformation userInformation;
    TransactionHistory()
    {
        super();
    }


    public TransactionHistory( Long accountNumber, Long toAccountNumber, Date transactionDate, String transactionStatus, BigDecimal transferAmount, UserInformation userInformation) {

        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.transferAmount = transferAmount;
        this.userInformation = userInformation;
    }

    public Long getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Long transactionId) {
        TransactionId = transactionId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}
