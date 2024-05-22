package com.example.App1.signUp_logIn.data;

public class SignUpSummary {
    private Long userId ;

    public SignUpSummary(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
