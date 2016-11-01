package com.wdys.android_learn.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * Created by wenqian on 2016/10/31.
 */
public  class BaseController {
    public void getRequest(RequestParams params,String url) {
        AsyncHttpClient client=new AsyncHttpClient();
        JSONObject object ;
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, org.apache.http.Header[] headers, byte[] responseBody) {
                    if(statusCode==200){
                        String content = new String(responseBody);
                         //new JSONObjectect(content);
                    }
            }

            @Override
            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
