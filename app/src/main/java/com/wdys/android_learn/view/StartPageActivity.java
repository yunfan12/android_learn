package com.wdys.android_learn.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;

import com.wdys.android_learn.BaseApplication;
import com.wdys.android_learn.MainActivity;
import com.wdys.android_learn.R;

/**
 * Created by wenqian on 2016/10/27.
 */
public class StartPageActivity extends Activity{
    private Handler h=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.layout_startpage);
        this.tomain();
    }
    private void tomain(){

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
                overridePendingTransition(R.anim.anim_alpha,R.anim.anim_alpha_exit);
                finish();
            }
        },3000);
    }
}
