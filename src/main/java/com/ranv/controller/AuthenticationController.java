package com.ranv.controller;


import com.ranv.Security.jwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping(value = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public com.ranv.model.DTO.UserDTO me() {
        return authenticationService.getMe();
    }
}

