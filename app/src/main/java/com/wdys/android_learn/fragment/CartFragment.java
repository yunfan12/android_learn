package com.wdys.android_learn.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdys.android_learn.R;

/**
 * Created by wenqian on 2016/10/28.
 */
public class CartFragment extends Fragment {
    private View view;
    private int screenWidth;
    private String style;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_cart, null);
        screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
//        Bundle b = new Bundle();
//        b=getArguments();
//        style=b.getString("style");
        return view;
    }
    //刷新
    public void refresh(){
        //setData();
    }
}
