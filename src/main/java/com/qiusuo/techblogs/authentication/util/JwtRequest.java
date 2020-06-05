package com.qiusuo.techblogs.authentication.util;

import com.qiusuo.techblogs.domain.models.user.UserType;
import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
    private UserType usertype;

    //accessToken could either be github accessToken,could also be wechat accessToken
    private String accessToken;
    private String phoneNumber;

    //phone number verification code if login via phone.
    private String verificationCode;
}
