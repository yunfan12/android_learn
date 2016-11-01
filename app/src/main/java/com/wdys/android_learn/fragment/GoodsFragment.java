package com.wdys.android_learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.wdys.android_learn.R;
import com.wdys.android_learn.adapter.ShopAdapter;
import com.wdys.android_learn.pojo.Shop;

import java.util.ArrayList;

/**
 * Created by wenqian on 2016/10/28.
 */

public class GoodsFragment extends Fragment {
    private View view;
    private int screenWidth;
    private String style;
    private PullToRefreshGridView listview;
    private GridView AllCommodityGridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_allgoods, null);
        screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        this.Init();
        return view;
    }
    private void Init(){
        listview= (PullToRefreshGridView) view.findViewById(R.id.goods_list);

        ShopAdapter adapter=new ShopAdapter(getActivity().getApplicationContext(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ArrayList<Shop> list=new ArrayList<Shop>();
        list.add(new Shop("360剃须刀","http://photo.enterdesk.com/2009-4-21/200901241609531378.png"));
        list.add(new Shop("百度剃须刀","http://photo.enterdesk.com/2009-4-21/200901241609531378.png"));
        list.add(new Shop("腾讯家私","http://photo.enterdesk.com/2009-4-21/200901241609531378.png"));
        adapter.addMore(list);
        Log.i("dd","test");

        AllCommodityGridView = listview.getRefreshableView();
        AllCommodityGridView.setAdapter(adapter);
        AllCommodityGridView.setNumColumns(1);
        listview.setOverScrollMode(View.OVER_SCROLL_NEVER);
        listview.setMode(PullToRefreshBase.Mode.BOTH);
        listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(getActivity().getApplicationContext(),"dd",Toast.LENGTH_SHORT);
                listview.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                Toast.makeText(getActivity().getApplicationContext(),"ee",Toast.LENGTH_SHORT);
                listview.onRefreshComplete();
            }
        });
        TextView tv = new TextView(view.getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setText("这里很空，下拉刷新试试");
        //当界面为空的时候显示的视图
        AllCommodityGridView.setEmptyView(tv);
    }
    //刷新
    public void refresh() {
        //setData();
    }
}
