package com.example.App1.userDetails.core;

import com.example.App1.accounts.domain.Account;
import com.example.App1.accounts.persistence.AccountRepository;
import com.example.App1.userDetails.data.*;
import com.example.App1.userDetails.domain.UserInformation;
import com.example.App1.userDetails.persistence.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Service
public class InformationService {

    @Autowired
    InformationRepository informationRepository;
@Autowired
    AccountRepository accountRepository;

    public PostRegisterUserResponse addUserInformation(final PostRegisterUserRequest request) {

        Long accountNumber = Long.valueOf(String.format("%010d", Math.abs(new Random().nextLong() % 1_000_000_0000L)));
        String accountStatus = "Active";
        BigDecimal accountBalance = BigDecimal.valueOf(0.0);
        UserInformation userInformation = new UserInformation(request.getId(), request.getFirstName(), request.getLastName(), request.getGender(), request.getEmail(), request.getPhoneNo(), request.getAddress(), accountNumber, request.getAccountCreatedDate(), accountStatus, accountBalance);
        Account account = new Account(accountNumber, new Date(), accountStatus, accountBalance, userInformation);
        userInformation.addAccount(account);
        informationRepository.save(userInformation);
        final var response = new PostRegisterUserResponse();
        response.addUserInformation(new PostRegisterUserSummary(userInformation.getId(), userInformation.getFirstName(), userInformation.getLastName(), userInformation.getGender(), request.getEmail(), userInformation.getPhoneNo(), userInformation.getAddress(), userInformation.getAccountNumber(), userInformation.getAccountCreatedDate(), userInformation.getAccountStatus(), userInformation.getAccountBalance()));
        return response;
    }

    public GetUserInformationResponse getUserInformation(final GetUserInformationRequest request) {
        Long accountNumber = request.getAccountNumber();
        System.out.println(accountNumber);
        UserInformation user = informationRepository.getUserInformationByAccountNumber(accountNumber);
        final var response = new GetUserInformationResponse();
        if (user != null) {
            GetUserInformationSummary summary = new GetUserInformationSummary(
                    user.getFirstName(), user.getLastName(), user.getGender(),
                    user.getEmail(), user.getPhoneNo(), user.getAddress(),
                    user.getAccountNumber(), user.getAccountCreatedDate(),
                    user.getAccountStatus(), user.getAccountBalance()
            );
            response.addUserInformation(summary);
        }
        return response;

    }

    public UpdateUserInformationResponse updateUserInformation(Long accountNumber, UpdateUserInformationRequest request) {
        UserInformation user = informationRepository.getUserInformationByAccountNumber(accountNumber);
        if (user == null) {
            throw new RuntimeException("User Not Found");
        }
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPhoneNo(request.getPhoneNo());
        informationRepository.save(user);

        final var response = new UpdateUserInformationResponse();
        UpdateUserInformationSummary summary = new UpdateUserInformationSummary(user.getId(), user.getFirstName() , user.getLastName() , user.getGender(), user.getEmail(), user.getPhoneNo(), user.getAddress(),user.getAccountCreatedDate());
        response.addUserInformation(summary);


        return response;


    }

    public String deactivateAccount(Long accountNumber) {
        UserInformation user = informationRepository.getUserInformationByAccountNumber(accountNumber);

        if (user == null) {
            throw new RuntimeException("User Not Found");
        }
        Account account = accountRepository.getUserInformationByAccountNumber(accountNumber);
        String response = null;
        if (account.getAccountNumber().equals(accountNumber)) {
            account.setAccountStatus("InActive");




        }
        user.setAccountStatus("InActive");
        informationRepository.save(user);
        if(Objects.equals(user.getAccountStatus(), "InActive"))
        {
            response = "Account Deactivated SuccessFully";
        }

        return response;
    }

    public String deleteAccount(Long accountNumber) {
        UserInformation user = informationRepository.getUserInformationByAccountNumber(accountNumber);

        if(user == null)
        {
            throw new RuntimeException("User Not Found");
        }

        String response = null ;
        informationRepository.delete(user);
        if(informationRepository.getUserInformationByAccountNumber(accountNumber) == null)
        {
            response = "Account Deleted SuccessFully";
        }
         return response;

    }
}
