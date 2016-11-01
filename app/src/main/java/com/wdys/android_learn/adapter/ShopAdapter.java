package com.wdys.android_learn.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdys.android_learn.R;
import com.wdys.android_learn.pojo.Shop;
import com.wdys.android_learn.util.ImageLoaderUtil;

import java.util.ArrayList;

/**
 * Created by wenqian on 2016/10/27.
 */
public class ShopAdapter  extends BaseAdapter{
    private ArrayList<Shop> shops;
    private ViewHolder holder;
    private Context context;
    private View.OnClickListener listener;
    public ShopAdapter(Context context, View.OnClickListener listener){
        this.listener=listener;
        this.shops=new ArrayList<Shop>();
        this.context=context;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.item_shop,null);
        this.holder= (ViewHolder) convertView.getTag();
        if(this.holder==null){
            holder=new ViewHolder();
            convertView.setOnClickListener(listener);
            holder.shopPic= (ImageView) convertView.findViewById(R.id.goods_img);
            holder.title= (TextView) convertView.findViewById(R.id.goods_title);
            convertView.setTag(holder);
        }
        ImageView shopimg=holder.shopPic;
        TextView shopTitle=holder.title;
        Shop item=shops.get(position);
        shopTitle.setText(shops.get(position).getTitle());
        ImageLoaderUtil loader=new ImageLoaderUtil();
        loader.ImageLoader(context,shops.get(position).getImg(),shopimg);
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }
    //增加列表
    public void addMore(ArrayList<Shop> items){
        Log.i("Adapter","addData");
        this.shops.addAll(items);
        this.notifyDataSetChanged();
    }
}
class ViewHolder{
    ImageView shopPic;
    TextView  title;
}