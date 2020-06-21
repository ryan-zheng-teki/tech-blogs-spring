package com.qiusuo.techblogs.authentication.config;

import com.qiusuo.techblogs.domain.models.user.UserType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
    private UserType authenticationType;
    private String username;
    private String userId;
    private String password;


    public CustomAuthenticationToken(UserDetails userDetails, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        setDetails(userDetails);
    }

    public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public CustomAuthenticationToken(String username, String userId, String password, UserType authenticationType) {
        super(null);
        this.username = username;
        this.authenticationType = authenticationType;
        this.password = password;
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }
}
