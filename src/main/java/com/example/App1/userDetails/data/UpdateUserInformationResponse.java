package com.example.App1.userDetails.data;

import java.util.ArrayList;
import java.util.Collection;

public class UpdateUserInformationResponse {
    private Collection<UpdateUserInformationSummary> userInformation ;
    public void addUserInformation(final UpdateUserInformationSummary data)
    {
        if(userInformation == null)
        {
            userInformation = new ArrayList<>();
        }
        userInformation.add(data);
    }

    public Collection<UpdateUserInformationSummary> getUserInformation() {
        return userInformation;
    }
}
