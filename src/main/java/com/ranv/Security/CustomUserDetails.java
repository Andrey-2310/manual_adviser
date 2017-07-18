package com.ranv.Security;

import com.ranv.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 15.07.2017.
 */
public class CustomUserDetails implements UserDetails {

    private String username;
    private String identity;
    private Set<SimpleGrantedAuthority> authorities;

    public CustomUserDetails(User user){
        this.username=user.getUsername();
        this.identity=user.getIdentity();
        authorities=new HashSet<>();
      //  authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
