package com.qiusuo.techblogs.authentication.config;

import com.qiusuo.techblogs.domain.models.user.UserType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
    private UserType authenticationType;
    private String accessToken;
    private String username;
    private String password;


    public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public CustomAuthenticationToken(String username, String password, String accessToken, UserType authenticationType) {
        super(null);
        this.username = username;
        this.accessToken = accessToken;
        this.authenticationType = authenticationType;
        this.password = password;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public UserType getAuthenticationType() {
        return authenticationType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUsername() {
        return username;
    }
}
