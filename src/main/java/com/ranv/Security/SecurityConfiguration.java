package com.ranv.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    AuthenticationManager authManager;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider("localhost:8080"))
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        AuthenticationFilter uloginFilter = new AuthenticationFilter("/**");
//        uloginFilter.setAuthenticationManager(authenticationManager());
//
//        HttpSecurity httpSecurity = http.
//                addFilterBefore(uloginFilter, AnonymousAuthenticationFilter.class);
//        httpSecurity
//                .authorizeRequests()
//                .antMatchers("/login", "/popular").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(3600)
//                .alwaysRemember(true)
//                .and()
//                .csrf()
//                .disable();
    }

}
