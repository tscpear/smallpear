package com.course.httpclient.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储Cookies信息的变量
    private CookieStore store;


    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookeis() throws IOException {
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //获取cookeies信息
        store = ((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name ="+name+";cookie value ="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookeis"})
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");

        //拼接最终的测试地址
        String testUrl=this.url+uri;

        //声明一个client的对象，用来进行方法执行
        DefaultHttpClient client = new DefaultHttpClient();



        //声明一个方法，一个post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头信息
        post.setHeader("conetent-type","application/json");


        //声明一个对象来进行响应结果的存储
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来存储结果
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        System.out.println(this.store);


        //执行post
        HttpResponse response = client.execute(post);

        //获取相应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


        //处理结果，就是判断结果是否符合预期
        //将返回的响应结果字符串，转为json对象
        JSONObject resultJson = new JSONObject(result);


        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        //具体的判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
