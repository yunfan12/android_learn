package com.wdys.android_learn.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.wdys.android_learn.MainActivity;
import com.wdys.android_learn.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenqian on 2016/10/28.
 */
public class NavigationActitity extends Activity {
    private ViewPager viewPager;
    private int[] images = {R.drawable.guide_page_one,R.drawable.guide_page_two};
    private List<ImageView> imageViews = new ArrayList<ImageView>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.layout_navigation);
        initView();
        super.onCreate(savedInstanceState);
    }
    private void initView(){
        this.viewPager= (ViewPager) findViewById(R.id.navigate);
        PagerAdapter adapter=new MypageAdapter();
        viewPager.setAdapter(adapter);
        final Handler handler =new Handler();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==images.length-1){
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent maini=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(maini);
                            finish();
                        }
                    },1000);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MypageAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView iv = new ImageView(NavigationActitity.this);
            if (position < images.length) {
                iv.setBackgroundResource(images[position]);
            }
            container.addView(iv);
            imageViews.add(iv);
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
