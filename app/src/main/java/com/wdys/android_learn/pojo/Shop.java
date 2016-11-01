package com.wdys.android_learn.pojo;

/**
 * Created by wenqian on 2016/10/27.
 */
public class Shop {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getImg() {
        return img;
    }

    public void setImg(String price) {
        this.img = price;
    }

    private String img;

    public Shop(String title,String img){
        this.title=title;
        this.img=img;
    }
}
