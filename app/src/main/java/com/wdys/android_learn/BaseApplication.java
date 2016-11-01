package com.wdys.android_learn;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by wenqian on 2016/10/27.
 */
public class BaseApplication extends Application{
    public static boolean ISFIRST=false;
    public static String TOKEN;
    public static List<String> Acity=null;//一级城市
    public static HashMap<String, ArrayList<String>> Bcity=null;//二级城市
    public static HashMap<String, ArrayList<String>> Ccity=null;//三级城市
    @Override
    public void onCreate() {
        super.onCreate();

    }
    /**
     * 判断当前是否有网
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
