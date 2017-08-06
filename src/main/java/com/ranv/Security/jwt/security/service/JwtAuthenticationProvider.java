package com.ranv.Security.jwt.security.service;

import com.ranv.Security.jwt.security.exception.InvalidTokenAuthenticationException;
import com.ranv.Security.jwt.security.model.JwtAuthenticationToken;
import com.ranv.Security.jwt.security.model.JwtUserDetails;
import com.ranv.Security.jwt.security.model.AccessToken;
import com.ranv.model.DB.User;
import com.ranv.model.DB.UserRole;
import com.ranv.repository.UserRepository;
import com.ranv.service.photo.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private static final long MILLIS_IN_SECOND = 1000L;

    private final UserRepository userRepository;
    private final AuthenticationHelper authenticationHelper;
    private final CloudinaryService cloudinaryService;

    @Override
    public Authentication authenticate(final Authentication authRequest) {
        JwtUserDetails userDetails;
        if (Objects.isNull(authRequest)) {
            userDetails = new JwtUserDetails(new User("anonymous", UserRole.ROLE_ANONYMOUS, null, null));
            return new JwtAuthenticationToken(userDetails);
        }

        // Getting string token from authentication request object
        String token = StringUtils.trimToNull((String) authRequest.getCredentials());

        //  Deserialize token
        AccessToken accessToken = authenticationHelper.decodeToken(token);

        // Getting user id from token
        String sub = accessToken.getSub();
        if (Objects.isNull(sub)) {
            throw new InvalidTokenAuthenticationException("Token does not contain a user sub.");
        }

        // Getting user from database
        User user = userRepository.findBySub(sub);
        if (Objects.isNull(user)) {
            user = userRepository.save(new User(accessToken.getName(), UserRole.ROLE_USER,
                    cloudinaryService.getPhoto(accessToken.getPicture()), sub));
        }

        return new JwtAuthenticationToken(new JwtUserDetails(user));
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}