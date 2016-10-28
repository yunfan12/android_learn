package com.wdys.android_learn.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.wdys.android_learn.R;

/**
 * Created by wenqian on 2016/10/27.
 */
public class StartPageActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("StartPageActivity","dd");
        this.setContentView(R.layout.layout_startpage);
    }
}
