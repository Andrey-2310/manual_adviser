package com.ranv.Security.jwt.security.model;


import com.ranv.model.DB.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Getter
public class JwtUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String sub;
    private Set<GrantedAuthority> authorities;

    public JwtUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.sub = user.getSub();
        this.authorities = new HashSet<>();
        this.authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
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
