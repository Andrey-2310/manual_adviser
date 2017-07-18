package com.ranv.Security;

import com.ranv.Model.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * Created by Андрей on 15.07.2017.
 */
public class AuthenticationToken extends AbstractAuthenticationToken {
    private String token;
    public User user;

    public AuthenticationToken(String token) {
        super(null);
        this.token=token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public Object getCredentials() {
        return token;
    }


    public Object getPrincipal() {
        return user;
    }

    @Override
    public String getName() {
        return user.getIdentity();
    }
}
