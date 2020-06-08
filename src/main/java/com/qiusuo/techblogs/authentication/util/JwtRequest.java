package com.qiusuo.techblogs.authentication.util;

import com.qiusuo.techblogs.domain.models.user.UserType;
import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
    private UserType usertype;

    //accessToken could either be github accessToken,could also be wechat accessToken
    private String accessToken;
    private String phoneNumber;

    //phone number verification code if login via phone.
    private String verificationCode;
}
