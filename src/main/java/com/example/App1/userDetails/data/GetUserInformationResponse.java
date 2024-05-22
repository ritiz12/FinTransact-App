package com.example.App1.userDetails.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetUserInformationResponse {
    private Collection<GetUserInformationSummary> userInformation ;

    public void addUserInformation(GetUserInformationSummary data)
    {
        if(userInformation == null)
        {
            userInformation = new ArrayList<>();
        }
        userInformation.add(data);
    }

    public Collection<GetUserInformationSummary> getUserInformation() {
        return userInformation;
    }
}
