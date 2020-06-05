package com.qiusuo.techblogs.authentication.adaptor;


import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import com.qiusuo.techblogs.authentication.strategy.CellphoneAuthenticationStrategy;
import com.qiusuo.techblogs.authentication.strategy.GithubAuthenticationStrategy;
import com.qiusuo.techblogs.authentication.strategy.WeChatAuthenticationStrategy;
import com.qiusuo.techblogs.domain.models.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAdapter {
    @Autowired
    GithubAuthenticationStrategy githubAuthenticationStrategy;
    @Autowired
    WeChatAuthenticationStrategy weChatAuthenticationStrategy;
    @Autowired
    CellphoneAuthenticationStrategy cellphoneAuthenticationStrategy;

    public Authentication authenticate(CustomAuthenticationToken authentication) {
        if (authentication.getAuthenticationType() == UserType.GITHUB) {
            return githubAuthenticationStrategy.authenticate(authentication);
        }
        return null;
    }

}
