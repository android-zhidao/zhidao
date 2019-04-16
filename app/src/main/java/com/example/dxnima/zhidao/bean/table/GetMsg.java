package com.example.dxnima.zhidao.bean.table;

import com.example.dxnima.zhidao.bean.ListBaseResp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Entity
 * Created by DXnima on 2019/4/9.
 */
@Entity
public class GetMsg extends ListBaseResp<GetMsg> {

    private String id;

    private Integer userid;

    private Integer msgid;

    private String categoryname;

    private Integer status;

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCategoryname() {
        return this.categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Integer getMsgid() {
        return this.msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Generated(hash = 34595736)
    public GetMsg(String id, Integer userid, Integer msgid, String categoryname,
            Integer status) {
        this.id = id;
        this.userid = userid;
        this.msgid = msgid;
        this.categoryname = categoryname;
        this.status = status;
    }

    @Generated(hash = 1585417166)
    public GetMsg() {
    }

}