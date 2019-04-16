package com.example.dxnima.zhidao;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.example.dxnima.zhidao.bean.ListBaseResp;
import com.example.dxnima.zhidao.bean.table.Msg;
import com.example.dxnima.zhidao.bean.table.User;
import com.example.dxnima.zhidao.capabilities.json.GsonHelper;
import com.example.dxnima.zhidao.constant.URLUtil;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest<T> extends ApplicationTestCase<Application> {
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    String url= URLUtil.USER_LOGIN;
    public ApplicationTest() {
        super(Application.class);}
        public void testMain(){
        }

    /**
     * 测试okhttp  post方法
     *
     * */
    public void testOkhttpPost() {
        url=URLUtil.USER_LOGIN;
        OkHttpClient mOkHttpClient = new OkHttpClient();
        User user=new User();
        user.setUsername("wnm");
        user.setPassword("123");
        String json=GsonHelper.toJson(user);
        System.out.println(json);
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request
                .Builder()
                .post(requestBody)//Post请求的参数传递
                .url(url)
                        // .addHeader("cookie", "JSESSIONID=AEE33E9E46B8764C25AC216B76523DDE")
                .build();
        try {
            Response response = mOkHttpClient.newCall(request).execute();
            String result = response.body().string();
            Log.e("androixx.cn", result);
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试json 转类对象方法
     *
     * */
    public void testJsontoClass(){
        Msg msg;
        String jsonstr="{\n" +
                "    \"status\": 0,\n" +
                "    \"data\": [{\n" +
                "        \"userid\": 1,\n" +
                "        \"username\": \"wnm\",\n" +
                "        \"password\": \"123\",\n" +
                "        \"email\": \"1370131288@qq.com\"\n" +
                "    }],\n" +
                "    \"msg\": null,\n" +
                "    \"success\": true\n" +
                "}";
        String jsonList="{\n" +
                "    \"status\": 0,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"msgid\": 1,\n" +
                "            \"title\": \"wnm\",\n" +
                "            \"endtime\": \"2019-04-16 01:50:23\",\n" +
                "            \"code\": \"zd36786\",\n" +
                "            \"location\": \"114.07059,30.541422\",\n" +
                "            \"filepath\": null,\n" +
                "            \"userid\": 1,\n" +
                "            \"content\": \"\",\n" +
                "            \"creatTime\": \"2019-04-15 17:50:37\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"msgid\": 2,\n" +
                "            \"title\": \"hhh\",\n" +
                "            \"endtime\": \"2019-04-16 02:44:24\",\n" +
                "            \"code\": \"zd31811\",\n" +
                "            \"location\": \"114.306161,30.805189\",\n" +
                "            \"filepath\": null,\n" +
                "            \"userid\": 1,\n" +
                "            \"content\": \"\",\n" +
                "            \"creatTime\": \"2019-04-15 18:44:32\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"msgid\": 3,\n" +
                "            \"title\": \"wnm\",\n" +
                "            \"endtime\": \"2019-04-16 01:50:23\",\n" +
                "            \"code\": \"zd06923\",\n" +
                "            \"location\": \"114.07059,30.541422\",\n" +
                "            \"filepath\": null,\n" +
                "            \"userid\": 1,\n" +
                "            \"content\": null,\n" +
                "            \"creatTime\": \"2019-04-15 22:03:07\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"msg\": null,\n" +
                "    \"success\": true\n" +
                "}";
        User res=GsonHelper.toType(jsonstr, User.class);
        List<User> user= ((ListBaseResp<User>)res).getData();
        int code=((ListBaseResp)res).getstatus();
        Log.e("str   ", user.get(0).getUsername()+code);
        Msg resMsg=GsonHelper.toType(jsonList, Msg.class);
        List<Msg> list=resMsg.getData();
        Log.e("list   ", list.get(0).getCreatTime());
    }

}