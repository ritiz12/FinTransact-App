package com.example.App1.userDetails.core;

import com.example.App1.userDetails.data.*;
import com.example.App1.userDetails.domain.UserInformation;
import com.example.App1.userDetails.persistence.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

@Service
public class InformationService {

    @Autowired
    InformationRepository informationRepository ;


    public PostRegisterUserResponse addUserInformation(final PostRegisterUserRequest request) {

        Long accountNumber = Long.valueOf(String.format("%010d", Math.abs(new Random().nextLong() % 1_000_000_0000L)));
        String accountStatus = "Active";
        BigDecimal accountBalance = BigDecimal.valueOf(0.0);
        UserInformation userInformation = new UserInformation(request.getId() , request.getFirstName() , request.getLastName() , request.getGender() , request.getEmail() , request.getPhoneNo() , request.getAddress(),accountNumber , request.getAccountCreatedDate(),accountStatus ,accountBalance );
        informationRepository.save(userInformation);
        final var response = new PostRegisterUserResponse();
        response.addUserInformation(new PostRegisterUserSummary(userInformation.getId(),userInformation.getFirstname() , userInformation.getLastName() , userInformation.getGender(),request.getEmail(),userInformation.getPhoneNo(),userInformation.getAddress(),userInformation.getAccountNumber(),userInformation.getAccountCreatedDate(),userInformation.getAccountStatus(),userInformation.getAccountBalance()));
          return response;
    }

    public GetUserInformationResponse getUserInformation(final GetUserInformationRequest request) {
        Long accountNumber = request.getAccountNumber();
       System.out.println(accountNumber);
        UserInformation user = informationRepository.getUserInformationByAccountNumber(accountNumber);
        final var response = new GetUserInformationResponse();
        if (user != null) {
            GetUserInformationSummary summary = new GetUserInformationSummary(
                    user.getFirstname(), user.getLastName(), user.getGender(),
                    user.getEmail(), user.getPhoneNo(), user.getAddress(),
                    user.getAccountNumber(), user.getAccountCreatedDate(),
                    user.getAccountStatus(), user.getAccountBalance()
            );
            response.addUserInformation(summary);
        }
        return response;

    }
}
