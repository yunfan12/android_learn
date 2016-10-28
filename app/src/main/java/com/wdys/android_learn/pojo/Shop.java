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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public Shop(String title,int price){
        this.title=title;
        this.price=price;
    }
}
