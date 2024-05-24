package com.example.App1.userDetails.data;

public class UpdateUserInformationRequest {

   final private Long phoneNo ;
   final private String address ;

   final private String email ;

    public UpdateUserInformationRequest(Long phoneNo, String address, String email) {
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
    }

    public Long getPhoneNo() {

        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
