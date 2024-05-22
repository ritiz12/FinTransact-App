package com.example.App1.userDetails.data;

import java.util.ArrayList;
import java.util.Collection;

public class PostRegisterUserResponse {
    private Collection<PostRegisterUserSummary> userInformation ;
    public void addUserInformation(final PostRegisterUserSummary data)
    {
        if(userInformation == null)
        {
            userInformation = new ArrayList<>();
        }
        userInformation.add(data);
    }

    public Collection<PostRegisterUserSummary> getUserInformation() {
        return userInformation;
    }
}
