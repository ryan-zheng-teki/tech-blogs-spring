package com.qiusuo.techblogs.authentication.config;

import com.qiusuo.techblogs.domain.models.user.UserType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {
    @Getter @Setter
    private UserType authenticationType;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String userId;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String avatarUrl;


    public CustomAuthenticationToken(UserDetails userDetails, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        setUsername(userDetails.getUsername());
        setPassword(userDetails.getPassword());
    }

    public CustomAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public CustomAuthenticationToken(String username, String userId, String password,
                                     UserType authenticationType, String avatarUrl) {
        super(null);
        this.username = username;
        this.authenticationType = authenticationType;
        this.password = password;
        this.userId = userId;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
