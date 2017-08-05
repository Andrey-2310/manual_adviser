package com.ranv.Security.jwt.service;

import com.ranv.Model.DTO.Authentication.LoginRequestDTO;
import com.ranv.Model.DTO.Authentication.LoginResponseDTO;
import com.ranv.Model.ModelDB.User;
import com.ranv.Repository.UserRepository;
import com.ranv.Security.jwt.security.SecurityHelper;
import com.ranv.Security.jwt.security.model.JwtUserDetails;
import com.ranv.Security.jwt.security.service.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.json.JsonException;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
//    private final AuthUserTransformer authUserTransformer;
    private final AuthenticationHelper authenticationHelper;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO login(final LoginRequestDTO loginRequestDto) {
        try {

            // Try to authenticate with this token
            final Authentication authResult = this.authenticationManager.authenticate(new Authentication() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public Object getCredentials() {
                    return null;
                }

                @Override
                public Object getDetails() {
                    return null;
                }

                @Override
                public Object getPrincipal() {
                    return null;
                }

                @Override
                public boolean isAuthenticated() {
                    return false;
                }

                @Override
                public void setAuthenticated(boolean b) throws IllegalArgumentException {

                }

                @Override
                public String getName() {
                    return null;
                }
            });

            // Set generated JWT token to response header
            if (authResult.isAuthenticated()) {
                JwtUserDetails userDetails = (JwtUserDetails) authResult.getPrincipal();

                User user = userRepository.findOne(userDetails.getId());
                if (Objects.isNull(user)) {
                    throw new JsonException("User not exist in system.");
                }

                String token = this.authenticationHelper.generateToken(userDetails.getId());

                return new LoginResponseDTO(token);
            } else {
                throw new JsonException("Authentication failed.");
            }

        } catch (BadCredentialsException exception) {
            throw new JsonException("Username or password was incorrect. Please try again.", exception);
        }
    }

//    /**
//     * Get user info.
//     * @return user info.
//     */
//    @Transactional(readOnly = true)
//    public AuthUserDto getMe() {
//        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
//        User byUsername = userRepository.findByUsername(authentication.getName());
//
//        return authUserTransformer.makeDto(byUsername);
//    }
}
