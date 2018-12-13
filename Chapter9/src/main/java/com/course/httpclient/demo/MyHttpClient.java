package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //存放我们的结果
        String result;
        HttpGet get =new HttpGet("http://www.baidu.com");
        //这个是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
        //存放返回的结果
        HttpResponse response = client.execute(get);
        //将返回结果转换成String类型
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
