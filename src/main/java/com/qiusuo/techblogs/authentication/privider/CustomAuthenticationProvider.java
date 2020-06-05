package com.qiusuo.techblogs.authentication.privider;


import com.qiusuo.techblogs.authentication.adaptor.AuthenticationAdapter;
import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {
    AuthenticationAdapter authenticationAdapter;

    CustomAuthenticationProvider(AuthenticationAdapter authenticationAdapter) {
        this.authenticationAdapter = authenticationAdapter;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        return authenticationAdapter.authenticate((CustomAuthenticationToken) authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthenticationToken.class);
    }
}
