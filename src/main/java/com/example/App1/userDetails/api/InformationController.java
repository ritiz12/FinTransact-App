package com.example.App1.userDetails.api;

import com.example.App1.userDetails.core.InformationService;
import com.example.App1.userDetails.data.*;
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

    @PutMapping("/updateUserInformation/{accountNumber}")
    public ResponseEntity<UpdateUserInformationResponse> updateUserInformation(@PathVariable Long accountNumber , @RequestBody UpdateUserInformationRequest request )
    {
        final var response = informationService.updateUserInformation(accountNumber , request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/deactivateAccount/{accountNumber}")
    public ResponseEntity<String> deactivateAccount(@PathVariable Long accountNumber)
    {
        final var response = informationService.deactivateAccount(accountNumber);
        return ResponseEntity.ok(response);
    }


     @DeleteMapping("deleteAccount/{accountNumber}")
    public  ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber)
     {

         final var response = informationService.deleteAccount(accountNumber);
         return ResponseEntity.ok(response);
     }




}
