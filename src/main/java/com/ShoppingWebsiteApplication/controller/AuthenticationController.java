package com.ShoppingWebsiteApplication.controller;

import com.ShoppingWebsiteApplication.security.model.AuthenticationRequest;
import com.ShoppingWebsiteApplication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    @CrossOrigin
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            ResponseEntity.ok(authenticationService.createAuthenticationToken(authenticationRequest));
        } catch (Exception exception) {
            ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect Username Or Password");
        }

    }
}

