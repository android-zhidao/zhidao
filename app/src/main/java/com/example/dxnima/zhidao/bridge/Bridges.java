
package com.example.dxnima.zhidao.bridge;

/**
 * <与Bridge模块一一对应，用以在BridgeFactory获取某个Bridge对应的Key>
 * Created by DXnima on 2019/4/1.
 */
public class Bridges {
    /**
     * 本地缓存(sd卡存储和手机内部存储)
     */
    public static final String LOCAL_FILE_STORAGE = "com.example.dxnima.zhidao.LOCAL_FILE_STORAGE";

    /**
     * SharedPreference缓存
     */
    public static final String SHARED_PREFERENCE = "com.example.dxnima.zhidao.SHARED_PREFERENCE";

    /**
     * 安全
     */
    public static final String SECURITY = "com.example.dxnima.zhidao.SECURITY";

    /**
     * 用户Session
     */
    public static final String USER_SESSION = "com.example.dxnima.zhidao.USER_SESSION";

    /**
     * CoreService，主要维护功能模块
     */
    public static final String CORE_SERVICE = "com.example.dxnima.zhidao.CORE_SERVICE";


    /**
     * 数据库模块
     */
    public static final String DATABASE = "com.example.dxnima.zhidao.DATABASE";

    /**
     * http请求
     */
    public static final String HTTP = "com.example.dxnima.zhidao.HTTP";

}
