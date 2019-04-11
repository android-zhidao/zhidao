package com.example.dxnima.zhidao.ui.personcenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.biz.personcenter.IMsgView;
import com.example.dxnima.zhidao.biz.personcenter.MsgPresenter;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * 消息页面
 * Created by DXnima on 2019/4/1.
 */
public class HomeActivity extends BaseActivity implements IMsgView{

    private RadioButton home_msg,home_my;

    private ImageView home_sendmsg,mypage_image;

    private FrameLayout fragment_container;

    private SearchView searchView;

    private ListView listMsg;

    private TextView mypage_setting,mypage_user;

    private MsgPresenter mMsgPresenter;

    /**
     * Activity非正常销毁之后
     * 用onCreate
     * 为了保护我们的数据可以将数据保存在savedInstanceState中
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
        presenter = mMsgPresenter = new MsgPresenter();
        mMsgPresenter.attachView(this);
    }

    /**
     * 初始化布局组件
     */
    @Override
    public void initViews(){
        home_msg=(RadioButton) findViewById(R.id.home_msg);
        home_my=(RadioButton) findViewById(R.id.home_my);
        home_sendmsg=(ImageView) findViewById(R.id.home_sendmsg);
        fragment_container=(FrameLayout) findViewById(R.id.fragment_container);
        mypage_image=(ImageView) findViewById(R.id.mypage_image);
        mypage_setting=(TextView) findViewById(R.id.mypage_setting);
        mypage_user=(TextView) findViewById(R.id.mypage_user);
        searchView=(SearchView) findViewById(R.id.searchView);
        listMsg=(ListView) findViewById(R.id.listMsg);
        View xmlView =LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        fragment_container.addView(xmlView);
    }

    /**
     * 增加按钮点击事件
     */
    @Override
    public void initListeners(){
        home_msg.setOnClickListener(this);
        home_my.setOnClickListener(this);
        home_sendmsg.setOnClickListener(this);
//        mypage_setting.setOnClickListener(this);
    }

    /**
     * 点击事件
     * */
    @Override
    public void onClick(View v) {
        View xmlView=null;
        switch (v.getId()) {
            case R.id.home_msg:
                fragment_container=(FrameLayout) findViewById(R.id.fragment_container);
                xmlView =LayoutInflater.from(this).inflate(R.layout.activity_main, null);
                fragment_container.addView(xmlView);
                break;
            case R.id.home_sendmsg:
                startActivity(SendmsgActivity.class,null);
                break;
            case R.id.home_my:
                fragment_container=(FrameLayout) findViewById(R.id.fragment_container);
                View xmlView1 =LayoutInflater.from(this).inflate(R.layout.activity_my, null);
                fragment_container.addView(xmlView1);
                break;
            case R.id.mypage_setting:
                startActivity(SettingActivity.class,null);
        }
        super.onClick(v);
    }

    /**
     * 初始化数据
     */
    @Override
    public void initData(){}

    @Override
    public void onError(String errorMsg, String code){
        showToast(errorMsg);
    }

    @Override
    public void onSuccess(String errorMsg, String code){}

    @Override
    public void showLoading(){}

    @Override
    public void hideLoading(){}
}