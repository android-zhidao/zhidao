package com.example.dxnima.zhidao;

import android.app.Application;
import android.os.Message;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);}
        public void testMain(){

        }

    /** * 测试okhttp的get方法
     * http://i24388o999.qicp.vip:37144/user/
     * */
    public void testOkhttpGet() {
        OkHttpClient mOkHttpClient=new OkHttpClient();
        String url= "http://i24388o999.qicp.vip:37144/user/";
        FormEncodingBuilder builder = new FormEncodingBuilder();
        builder.add("username","123456").add("password","456123");
        RequestBody body = builder.build();
        Request request = new Request.Builder().post(body).url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Message message = Message.obtain();
                message.what = 0;
                message.obj = e.getMessage();
                Log.e("321", "onFailure: " + message.obj.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = response.body().string();//string不能调用两次 被调用一次就关闭了，这里调用两次会报异常
                Log.e("123", "response: " + message.obj.toString());
            }
        });
    }




}