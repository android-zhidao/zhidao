package com.example.dxnima.zhidao.ui.personcenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.biz.personcenter.IUserLoginView;
import com.example.dxnima.zhidao.biz.personcenter.UserPresenter;
import com.example.dxnima.zhidao.constant.Event;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * 登录界面（LoginActivity），只要继承BaseActivity则可以了
 * Created by DXnima on 2019/4/1.
 */
public class LoginActivity extends BaseActivity implements IUserLoginView{

    /**
     *页面 用户名
     */
    private EditText userName;

    /**
     * 页面用户密码
     */
    private EditText password;

    /**
     * 页面登录按钮
     */
    private Button login;

    /**注册*/
    private TextView go_register;

    /**忘记密码？*/
    private TextView go_updatepassword;

    private UserPresenter mUserPresenter;


    /**
     * Activity非正常销毁之后
     * 用onCreate
     * 为了保护我们的数据可以将数据保存在savedInstanceState中
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        setHeader();
        super.onCreate(savedInstanceState);
        presenter = mUserPresenter = new UserPresenter();
        mUserPresenter.attachView(this);
    }

    /**
     * 初始化布局组件
     */
    @Override
    public void initViews() {
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        go_register=(TextView) findViewById(R.id.go_register);
        go_updatepassword=(TextView) findViewById(R.id.go_updatepassword);
    }


    //添加按钮点击事件
    @Override
    public void initListeners() {
        login.setOnClickListener(this);
        go_register.setOnClickListener(this);
        go_updatepassword.setOnClickListener(this);
    }


    //初始化数据
    @Override
    public void initData() {

    }

    // 初始化公共头部
    @Override
    public void setHeader() {
        super.setHeader();
        title.setText("登录");
    }

    /**
     * 使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，
     * onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行
     * */
    @Override
    public void onEventMainThread(Event event) {
        super.onEventMainThread(event);
        switch (event){
            case IMAGE_LOADER_SUCCESS:
                clearEditContent();
                break;
        }
    }

    /**
     * 点击事件
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                mUserPresenter.loginDatabase(userName.getText().toString(), password.getText().toString());//登陆
                break;
            case R.id.go_register:
                startActivity(RegisterActivity.class,null);//点击注册跳转注册界面
                break;
            case R.id.go_updatepassword:
                startActivity(UpdatepsdActivity.class,null);//点击修改密码跳转修改密码界面
        }
        super.onClick(v);
    }

    /**
     *控件内容初始化
     * */
    @Override
    public void clearEditContent() {
        userName.setText("");
        password.setText("");
    }

    @Override
    public void onError(String errorMsg, String code) {
        showToast(errorMsg);
    }

    @Override
    public void onSuccess(String errorMsg, String code) {
        //成功打开新界面homeactivity 主界面
        startActivity(HomeActivity.class,null);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}