package com.example.App1.signUp_logIn.api;

import com.example.App1.signUp_logIn.core.HomeService;
import com.example.App1.signUp_logIn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService ;


    @GetMapping("/users")
    public List<User> getUser()
    {

        return homeService.getUser() ;
    }
}
