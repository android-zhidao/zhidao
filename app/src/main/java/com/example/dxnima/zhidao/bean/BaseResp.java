package com.example.dxnima.zhidao.bean;

/**
 * <网络请求返回体>
 * Created by DXnima on 2019/4/1.
 */
public class BaseResp<T> {
    /**
     * 返回状态码
     */
    protected Integer status;

    /**
     * data 数据体
     */
    protected T data;

    protected String msg;

    protected String success;

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg=msg;
    }

    public String getSuccess(){
        return success;
    }

    public void setSuccess(String success){
        this.success=success;
    }
}