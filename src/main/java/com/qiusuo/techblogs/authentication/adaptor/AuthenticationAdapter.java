package com.qiusuo.techblogs.authentication.adaptor;


import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import com.qiusuo.techblogs.authentication.strategy.CellphoneAuthenticationStrategy;
import com.qiusuo.techblogs.authentication.strategy.GithubAuthenticationStrategy;
import com.qiusuo.techblogs.authentication.strategy.WeChatAuthenticationStrategy;
import com.qiusuo.techblogs.domain.models.user.UserType;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AuthenticationAdapter {
    private GithubAuthenticationStrategy githubAuthenticationStrategy;
    private WeChatAuthenticationStrategy weChatAuthenticationStrategy;
    private CellphoneAuthenticationStrategy cellphoneAuthenticationStrategy;


    public Authentication authenticate(CustomAuthenticationToken authentication) {
        if (authentication.getAuthenticationType() == UserType.GITHUB) {
            return githubAuthenticationStrategy.authenticate(authentication);
        }
        return null;
    }
}
