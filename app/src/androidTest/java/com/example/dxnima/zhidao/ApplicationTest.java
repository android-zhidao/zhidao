package com.example.dxnima.zhidao;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.example.dxnima.zhidao.bean.table.User;
import com.example.dxnima.zhidao.capabilities.json.GsonHelper;
import com.google.gson.JsonObject;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest<T> extends ApplicationTestCase<Application> {
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");
    private Class<User> clazz;
    String url= "http://i24388o999.qicp.vip:36195/user/login.do";
    public ApplicationTest() {
        super(Application.class);}
        public void testMain(){
            JsonObject object=new JsonObject();
            object.addProperty("username", "123");
            object.addProperty("password", "123");
            String jsonStr=object.toString();
            String string="{\n" +
                    "\t\"status\": \"0\",\n" +
                    "\t\"data\": {\n" +
                    "\t\t\"username\": \"123\",\n" +
                    "\t\t\"password\": \"123\"\n" +
                    "\t},\n" +
                    "\t\"msg\": \"www\",\n" +
                    "\t\"success\": \"123\"\n" +
                    "}";
            System.out.println(jsonStr);

            final User res= (User) GsonHelper.toType(jsonStr,clazz);
            System.out.println(res.getUsername());
        }

    /**
     * 测试okhttp  post方法
     *
     * */
    public void testOkhttpGet() {
        OkHttpClient mOkHttpClient=new OkHttpClient();

        JsonObject object=new JsonObject();
        object.addProperty("username", "wnm");
        //object.addProperty("password", "123");
        String jsonStr=object.toString();
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder().post(body).url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("113" + request.toString() + e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string(); //方法只能调用一次
                    System.out.println("response   " + response);
//                    System.out.println("string   " + result);
//                    JsonParser parser = new JsonParser();//Json解析
//                    JsonObject jsonObject = (JsonObject) parser.parse(result);
//                    Log.e("113123", "返回信息=== " + jsonObject.get("msg"));
                } else System.out.println("失败");
            }
        });
    }

    public void testObjct(){
        OkHttpClient mOkHttpClient=new OkHttpClient();
        //使用JSONObject封装参数
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username","wnm");
            jsonObject.put("password","123");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        User user=new User();
        String username="wnm";
        String password="123";
        user.setUsername(username.trim());
        user.setPassword(password.trim());
        String json= GsonHelper.toJson(user);
        Log.d("4444",json);
        Log.e("aaaa",jsonObject.toString());
        //创建RequestBody对象，将参数按照指定的MediaType封装
        RequestBody requestBody = RequestBody.create(JSON,jsonObject.toString());
        Request request = new Request
                .Builder()
                .post(requestBody)//Post请求的参数传递
                .url(url)
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



}