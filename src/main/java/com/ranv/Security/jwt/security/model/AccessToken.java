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

    public AccessToken(String sub) {
        this.sub = sub;
    }
}