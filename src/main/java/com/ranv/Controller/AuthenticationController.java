package com.ranv.Controller;
//package com.spring.jwt.controller;
//
//        import com.spring.jwt.service.AuthenticationService;
//        import com.spring.jwt.service.dto.AuthUserDto;
//        import com.spring.jwt.service.dto.LoginRequestDto;
//        import com.spring.jwt.service.dto.LoginResponseDto;
//        import lombok.RequiredArgsConstructor;
//        import org.springframework.http.HttpStatus;
//        import org.springframework.http.MediaType;
//        import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.PostMapping;
//        import org.springframework.web.bind.annotation.RequestBody;
//        import org.springframework.web.bind.annotation.RequestMapping;
//        import org.springframework.web.bind.annotation.ResponseStatus;
//        import org.springframework.web.bind.annotation.RestController;

import com.ranv.Model.DTO.Authentication.LoginRequestDTO;
import com.ranv.Model.DTO.Authentication.LoginResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequiredArgsConstructor
public class AuthenticationController {
//
//    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDTO login(
            @RequestBody final LoginRequestDTO loginRequestDto
    ) {
        System.out.println(loginRequestDto.getAccessToken());
        return new LoginResponseDTO("hui");
        //return authenticationService.login(loginRequestDto);
    }
//
//    @GetMapping(value = "/me")
//    @ResponseStatus(value = HttpStatus.OK)
//    public AuthUserDto me() {
//        return authenticationService.getMe();
//    }
}

