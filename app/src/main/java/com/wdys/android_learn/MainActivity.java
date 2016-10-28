package com.wdys.android_learn;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.Toast;

import com.wdys.android_learn.adapter.MainViewpagerAdapter;
import com.wdys.android_learn.cusview.IndexViewPager;
import com.wdys.android_learn.fragment.CartFragment;
import com.wdys.android_learn.fragment.GoodsFragment;
import com.wdys.android_learn.fragment.MainFragment;
import com.wdys.android_learn.fragment.UserFragment;
import java.util.ArrayList;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private IndexViewPager viewPager;
    private RadioButton homeButton;
    private RadioButton cartButton;
    private RadioButton goodsButton;
    private RadioButton userButton;
    private RadioButton lbutton;
    Handler mhand=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 0:
                    Toast.makeText(getApplicationContext(),"点击了",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private void initView(){
        ArrayList<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new MainFragment());
        fragments.add(new GoodsFragment());
        fragments.add(new UserFragment());
        fragments.add(new CartFragment());
        this.viewPager= (IndexViewPager) findViewById(R.id.MainViewPager);
        FragmentManager manager=this.getSupportFragmentManager();
        MainViewpagerAdapter adapter=new MainViewpagerAdapter(manager,fragments);
        viewPager.setAdapter(adapter);
        //初始化控件
        this.homeButton= (RadioButton) findViewById(R.id.HomepageRadioButton);
        this.cartButton= (RadioButton) findViewById(R.id.ShoppingCartRadioButton);
        this.userButton= (RadioButton) findViewById(R.id.MyShoppingRadioButton);
        this.goodsButton= (RadioButton) findViewById(R.id.AllCommodityRadioButton);
        lbutton=homeButton;
        homeButton.setOnClickListener(this);
        cartButton.setOnClickListener(this);
        userButton.setOnClickListener(this);
        goodsButton.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//关闭信息栏
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //set选择button
    public void selectButton(RadioButton button) {
        if (!(lbutton.getId() == button.getId())) {
            button.setChecked(true);
            lbutton.setChecked(false);
            lbutton = button;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.HomepageRadioButton:
                selectButton(homeButton);
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.AllCommodityRadioButton:
                selectButton(goodsButton);
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.MyShoppingRadioButton:
                selectButton(userButton);
                viewPager.setCurrentItem(3, false);
                break;
            case R.id.ShoppingCartRadioButton:
                selectButton(cartButton);
                viewPager.setCurrentItem(2, false);
                break;
            default:
                selectButton(homeButton);
                viewPager.setCurrentItem(0, false);
                break;
        }
    }
}
