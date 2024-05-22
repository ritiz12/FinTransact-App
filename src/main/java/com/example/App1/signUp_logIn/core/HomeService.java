package com.example.App1.signUp_logIn.core;
import java.util.List;
import java.util.Random;
import com.example.App1.signUp_logIn.persistence.UserRepository;
import com.example.App1.signUp_logIn.data.SignUpRequest;
import com.example.App1.signUp_logIn.data.SignUpResponse;
import com.example.App1.signUp_logIn.data.SignUpSummary;
import com.example.App1.signUp_logIn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HomeService  {
    @Autowired
    private UserRepository userRepo ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public SignUpResponse saveSignUpData( final SignUpRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        Long userId = Long.valueOf(generateUserId());
        User user = new User( userId , request.getName(),request.getEmail() ,request.getPassword());
        userRepo.save(user);

        final var response = new SignUpResponse();
        response.addSignUpRecord(new SignUpSummary(user.getUserId()));
        return response;
    }
    private String generateUserId() {
        Random random = new Random();
        int minDigits = 4;
        int maxDigits = 8;
        int numDigits = random.nextInt(maxDigits - minDigits + 1) + minDigits; // Random number between 4 and 8 digits

        int min = (int) Math.pow(10, numDigits - 1);
        int max = (int) Math.pow(10, numDigits) - 1;

        int userId = random.nextInt((max - min) + 1) + min;
        return String.valueOf(userId);
    }


    public List<User> getUser()
    {
        return userRepo.findAll();
    }
}
