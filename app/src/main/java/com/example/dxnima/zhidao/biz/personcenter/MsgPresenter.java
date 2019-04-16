package com.example.dxnima.zhidao.biz.personcenter;

import com.example.dxnima.zhidao.bean.table.Msg;
import com.example.dxnima.zhidao.biz.BasePresenter;
import com.example.dxnima.zhidao.bridge.BridgeFactory;
import com.example.dxnima.zhidao.bridge.Bridges;
import com.example.dxnima.zhidao.bridge.http.OkHttpManager;
import com.example.dxnima.zhidao.capabilities.http.ITRequestResult;
import com.example.dxnima.zhidao.capabilities.http.Param;
import com.example.dxnima.zhidao.constant.URLUtil;

import java.util.List;

/**
 * Created by DXnima on 2019/4/9.
 */
public class MsgPresenter extends BasePresenter<IMsgView> {
    public MsgPresenter() {
    }

    //获取全部Msg
    public void allSendMsg(){
        mvpView.showLoading();
        OkHttpManager httpManager = BridgeFactory.getBridge(Bridges.HTTP);
        httpManager.requestAsyncPost(URLUtil.MSG_ALLSENDMSG, new ITRequestResult<Msg>() {
            @Override
            public void onSuccessful(List<Msg> entity) {

            }

            @Override
            public void onFailure(String errorMsg) {
            }

            @Override
            public void onCompleted() {
            }
        },Msg.class,new Param("username","wnm"));
    }
}