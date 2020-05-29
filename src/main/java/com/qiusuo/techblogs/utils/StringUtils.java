package com.qiusuo.techblogs.utils;

public class StringUtils {
    public static String FormatedMessage(String message, String... args) {
        return String.format(message, args);
    }

}
