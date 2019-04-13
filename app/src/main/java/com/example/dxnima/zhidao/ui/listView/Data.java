package com.example.dxnima.zhidao.ui.listView;

/**
 * Created by Jay on 2015/9/21 0021.
 */
public class Data {
    private int imgId;//通知图片
    private String title;//标题
    private String endtime;//结束时间

    public Data() {}

    public Data(int imgId, String title,String endtime) {
        this.imgId = imgId;
        this.title = title;
        this.endtime=endtime;
    }

    public int getImgId() {
        return imgId;
    }

    public String getTitle() {
        return title;
    }

    public String getEndtime(){ return endtime;}

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEndtime(String endtime){this.endtime=endtime;}

}

