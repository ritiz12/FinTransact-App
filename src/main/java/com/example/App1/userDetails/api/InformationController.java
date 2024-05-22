package com.example.App1.userDetails.api;

import com.example.App1.userDetails.core.InformationService;
import com.example.App1.userDetails.data.GetUserInformationRequest;
import com.example.App1.userDetails.data.GetUserInformationResponse;
import com.example.App1.userDetails.data.PostRegisterUserRequest;
import com.example.App1.userDetails.data.PostRegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetail")
public class InformationController {

    @Autowired
    InformationService informationService ;

    @PostMapping("/registerUser")
    ResponseEntity<PostRegisterUserResponse> addUserInformation(@RequestBody PostRegisterUserRequest request)
    {
        final var response = informationService.addUserInformation(request);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/userInformation/{accountNumber}")
    ResponseEntity<GetUserInformationResponse> getUserInformation(@PathVariable Long accountNumber)
    {
        GetUserInformationRequest request = new GetUserInformationRequest(accountNumber);
        final  var response = informationService.getUserInformation(request);
        return ResponseEntity.ok(response);
    }



}
