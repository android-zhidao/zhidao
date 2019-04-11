package com.example.dxnima.zhidao.constant;

/**
 * <网络请求url地址>
 * <功能详细描述>
 * Created by DXnima on 2019/4/1.
 */
public class URLUtil {

    /**
     * 服务器地址
     */
    public static final String SERVER = "http://i24388o999.qicp.vip:36195/";

    /**
     * 用户登陆
     */
    public static final String USER_LOGIN = SERVER+"user/login.do";

    /**
     * 用户注册
     * */
    public static final String USER_REGISTER=SERVER+"user/register.do";

    /**
     * 用户修改密码
     * */
    public static final String USER_UPDATEUSER=SERVER+"user/updateUser.do";

    /**
     * 获取用户信息
     * */
    public static final String USER_GETUSERINFO=SERVER+"user/get_user_info.do";

    /**
     * 信息发送
     */
    public static final String MSG_SENDMSG=SERVER+"msg/sendMsg.do";

    /**
     * 获取已经发送信息
     */
    public static final String MSG_ALLSENDMSG=SERVER+"msg/allSendMsg.do";

    /**
     * 关注信息
     */
    public static final String GETMSG_FOCUSMSG=SERVER+"gstMsg/focusMsg.do";
}
