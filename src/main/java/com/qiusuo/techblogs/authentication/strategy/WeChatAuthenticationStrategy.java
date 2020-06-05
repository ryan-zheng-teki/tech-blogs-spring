package com.qiusuo.techblogs.authentication.strategy;

import com.qiusuo.techblogs.authentication.config.CustomAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

@Configuration
public class WeChatAuthenticationStrategy {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatAuthenticationStrategy.class);

    /*
     */
    public Authentication authenticate(CustomAuthenticationToken authentication) {
        LOGGER.debug("authenticate via wechat account");
        String accessToken = authentication.getAccessToken();
        //call github
        return authentication;
    }
}
