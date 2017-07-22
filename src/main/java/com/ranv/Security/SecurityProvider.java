package com.ranv.Security;

import com.ranv.Model.ModelDB.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.json.*;
import java.net.URL;
import java.net.URLConnection;

public class SecurityProvider implements AuthenticationProvider {
        private static final Logger LOG= LoggerFactory.getLogger(SecurityProvider.class);

        /**
         * Домен сайта, который производит аутентификацию.
         */
        private String host;

    public SecurityProvider(String host) {
            this.host=host;
        }


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }

        AuthenticationToken uLoginAuthenticationToken=(AuthenticationToken)authentication;

        try {
            URL uloginUrl = new URL("http://ulogin.ru/token.php?token=" + uLoginAuthenticationToken.getCredentials() + "&host="+host);
            URLConnection urlConnection = uloginUrl.openConnection();

            JsonReader jsonReader = Json.createReader(urlConnection.getInputStream());
            JsonObject obj = jsonReader.readObject();

            if (obj == null ) {
                throw new BadCredentialsException("ulogin did't return json object");
            }
            if(obj.getJsonString("identity")==null){
                throw new BadCredentialsException("ulogin did't return identity object");
            }

            String identity = obj.getJsonString("identity").getString();
            LOG.info(identity);

            User user = new User();
            user.setIdentity(identity);

            user.setUsername(getStringProp(obj,"first_name"));

            uLoginAuthenticationToken.setUser(user);
            uLoginAuthenticationToken.setAuthenticated(true);

        }catch (Exception ex){
            uLoginAuthenticationToken.setAuthenticated(false);
            LOG.error(ex.getMessage(),ex);
            throw new AuthenticationServiceException(ex.getMessage());
        }
        return uLoginAuthenticationToken;
    }


    private String getStringProp(JsonObject obj, String prop) {
        JsonString jsonString = obj.getJsonString(prop);
        if(jsonString==null){
            return null;
        }
        return jsonString.getString();
    }


    public boolean supports(Class<?> authentication) {
        return AuthenticationToken.class.isAssignableFrom(authentication);
    }
}
