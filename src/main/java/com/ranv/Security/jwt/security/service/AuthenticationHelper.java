package com.ranv.Security.jwt.security.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranv.Security.jwt.security.exception.InvalidTokenAuthenticationException;
import com.ranv.Security.jwt.security.model.AccessToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Component
@RequiredArgsConstructor
public class AuthenticationHelper {

    public static final String AUTHENTICATION_HEADER = "Authorization";
    public static final String AUTHENTICATION_PARAM = "auth";
    private final String SECRET = "dNFdhinaeHQZxTHD7A8W-OI-Ls0x8kqO2sPlhZI2zrFpoJRsA3xsclJfwh9UK92l";

    private Long tokenExpirationTime = 3600L;

    private final ObjectMapper objectMapper;

    public String generateToken(final Long userId) {
        try {
            AccessToken payload = new AccessToken();

            String token = this.objectMapper.writeValueAsString(payload);
            return JwtHelper.encode(token, new MacSigner(SECRET)).getEncoded();
        } catch (JsonProcessingException exception) {
            throw new InternalAuthenticationServiceException("Error generating token.", exception);
        }
    }

    public AccessToken decodeToken(final String token) {
        if (Objects.isNull(token)) {
            throw new InvalidTokenAuthenticationException("Token was null or blank.");
        }

        // Getting JWT object from string token
        Jwt jwt = JwtHelper.decode(token);

        // Getting payload of token
        String claims = jwt.getClaims();
        AccessToken accessToken;
        try {
            accessToken = this.objectMapper.readValue(claims, AccessToken.class);
        } catch (IOException exception) {
            throw new InvalidTokenAuthenticationException("Token parsing failed.", exception);
        }

        return accessToken;
    }
}
