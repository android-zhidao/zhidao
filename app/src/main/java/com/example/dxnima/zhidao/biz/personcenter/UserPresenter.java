package com.example.dxnima.zhidao.biz.personcenter;

import com.example.dxnima.zhidao.ZDApplication;
import com.example.dxnima.zhidao.bean.table.User;
import com.example.dxnima.zhidao.biz.BasePresenter;
import com.example.dxnima.zhidao.bridge.BridgeFactory;
import com.example.dxnima.zhidao.bridge.Bridges;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefManager;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefUser;
import com.example.dxnima.zhidao.bridge.http.OkHttpManager;
import com.example.dxnima.zhidao.capabilities.http.ITRequestResult;
import com.example.dxnima.zhidao.capabilities.http.Param;
import com.example.dxnima.zhidao.constant.URLUtil;
import com.example.dxnima.zhidao.dao.DaoSession;
import com.example.dxnima.zhidao.util.GeneralUtils;

/**
 *用户相关方法实现层
 * 登陆注册修改密码等
 * Created by DXnima on 2019/4/2.
 */
public class UserPresenter extends BasePresenter<IUserLoginView> {

    GeneralUtils generalUtils=new GeneralUtils();
    public UserPresenter() {
    }

    DaoSession daoSession =ZDApplication.getInstances().getDaoSession();

    //网络层登陆实现
    public void loginInternet(String username, String password) {
        mvpView.showLoading();
        //SecurityManager securityManager = BridgeFactory.getBridge(Bridges.SECURITY);
        OkHttpManager httpManager = BridgeFactory.getBridge(Bridges.HTTP);
        if (username=="" || password==""){
            mvpView.onError("不能为空！","");
        }
        else
        //post请求
        httpManager.requestAsyncPostByTag(URLUtil.USER_LOGIN, getName(), new ITRequestResult<User>() {
                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onSuccessful(User entity) {
                        String s=entity.getUsername();
                        mvpView.onSuccess("登陆成功！", "");
                        EBSharedPrefManager manager = BridgeFactory.getBridge(Bridges.SHARED_PREFERENCE);
                        manager.getKDPreferenceUserInfo().saveString(EBSharedPrefUser.USER_NAME, "");
                    }
                    @Override
                    public void onFailure(String errorMsg) {
                        mvpView.onError(errorMsg, "");
                    }

                }, User.class, new Param("username", username),
                new Param("password",password));


    }

    //注册网络层
    public void registerInternet(String username,String password,String email){
        mvpView.showLoading();
        //SecurityManager securityManager = BridgeFactory.getBridge(Bridges.SECURITY);
        OkHttpManager httpManager = BridgeFactory.getBridge(Bridges.HTTP);
        if (username=="" || password==""){
            mvpView.onError("不能为空！","");
        }
        else if (!generalUtils.IsPassword(password)){
            mvpView.onError("密码长度不够!","");
        }
        else if(!generalUtils.isEmail(email)){
            mvpView.onError("邮箱格式不正确！","");
        }
        else
        httpManager.requestAsyncPostByTag(URLUtil.USER_REGISTER,getName(),new ITRequestResult<User>() {
                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onSuccessful(User entity) {
                        mvpView.onSuccess("注册成功！","");
                        EBSharedPrefManager manager = BridgeFactory.getBridge(Bridges.SHARED_PREFERENCE);
                        manager.getKDPreferenceUserInfo().saveString(EBSharedPrefUser.USER_NAME, "abc");
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        mvpView.onError(errorMsg, "");
                    }

                }, User.class, new Param("username", username),
                new Param("password", password),new Param("email",email));
    }

   /**
    //本地数据库登陆实现
    public void loginDatabase(String username, String password) {
        mvpView.showLoading();
        UserDao userDao = daoSession.getUserDao();
        List<User> userList = userDao.queryBuilder().build().list();
        if(userList == null){
            Log.e("register", "数据库里无数据");
        }
        else {
            int flag = 0;
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    mvpView.onSuccess("登陆成功！","");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                mvpView.onError("密码不正确！", "");
            }
        }
    }

    //本地数据库注册
    public void registerDatabase(String username, String password,String email) {
        mvpView.showLoading();
        UserDao userDao = daoSession.getUserDao();
        List<User> userList = userDao.queryBuilder().build().list();
        if(userList == null){
            Log.e("register", "数据库里无数据");
        }else{
            int flag = 0;
            for(User user1 : userList){
                if(user1.getUsername().equals(username)){
                    flag = 1;
                    mvpView.onError("用户名已存在！", "");
                    break;
                }
            }
            if (flag == 0) {
                User user2 = new User(null,username,password,email);
                userDao.insert(user2);
                mvpView.onSuccess("注册成功！", "");
            }
        }
    }
    **/
}