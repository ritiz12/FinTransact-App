package com.example.App1.signUp_logIn.data;

import java.util.ArrayList;
import java.util.Collection;

public class SignUpResponse {


    Collection<SignUpSummary> signUpRecord;
    public void addSignUpRecord(final SignUpSummary data)
    {
        if(signUpRecord == null)
        {
            signUpRecord = new ArrayList<>();
        }
        signUpRecord.add(data);
    }

    public Collection<SignUpSummary> getSignUpRecord() {
        return signUpRecord;
    }
}
