package com.wdys.android_learn.controller;

import android.content.Context;
import android.os.Handler;

import com.wdys.android_learn.util.BaseController;
import com.wdys.android_learn.util.LoadFrame;

/**
 * Created by wenqian on 2016/10/31.
 */
public class ServiceController extends BaseController{
    private Context context;
    private LoadFrame frame;
    private Handler handler;
    private String id;
    private String text;
    public ServiceController(Context context, LoadFrame frame,
                             Handler handler, String id, String text,String url) {
        this.context=context;
        this.frame=frame;
        this.id=id;
        this.text=text;
        this.handler=handler;
    }
}
