package com.example.dxnima.zhidao.bean.table;

import com.example.dxnima.zhidao.bean.BaseResp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

/**
 * @Entity
 * Created by DXnima on 2019/4/9.
 */
@Entity
public class Msg extends BaseResp<Msg> {
    private Integer msgid;

    private String title;

    private Date endtime;

    private Date creattime;

    private String code;

    private String location;

    private String filepath;

    private Integer userid;

    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMsgid() {
        return this.msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    @Generated(hash = 1306996504)
    public Msg(Integer msgid, String title, Date endtime, Date creattime,
            String code, String location, String filepath, Integer userid,
            String content) {
        this.msgid = msgid;
        this.title = title;
        this.endtime = endtime;
        this.creattime = creattime;
        this.code = code;
        this.location = location;
        this.filepath = filepath;
        this.userid = userid;
        this.content = content;
    }

    @Generated(hash = 23037457)
    public Msg() {
    }
}