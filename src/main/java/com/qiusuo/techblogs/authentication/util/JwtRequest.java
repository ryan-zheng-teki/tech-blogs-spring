package com.qiusuo.techblogs.authentication.util;

import com.qiusuo.techblogs.domain.models.user.UserType;
import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
    private UserType usertype;
    
    //userId is from Github/Wechat User
    private String userId;
    private String phoneNumber;

    //phone number verification code if login via phone.
    private String verificationCode;

    private String avatarUrl;
}
