package com.ranv.Security.jwt.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Getter
@Setter
@NoArgsConstructor
public class AccessToken {
    private String sub;
    private String name;
    private String picture;

    public AccessToken(String sub, String name, String picture) {
        this.sub = sub;
        this.name = name;
        this.picture = picture;
    }
}