package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

//这个类用来装变量，和application.properties里的相对应
public class TestConfig {
    public static String loginUrl;//静态是因为只加载一次
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;

}
