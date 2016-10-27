package com.wdys.shop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wdys.shop.R;
import com.wdys.shop.pojo.Shop;

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
        this.holder= (ViewHolder) convertView.getTag();
        if(this.holder==null){
            holder=new ViewHolder();
            convertView=View.inflate(context, R.layout.item_shop,null);
            convertView.setOnClickListener(listener);
            holder.shopPic= (ImageView) convertView.findViewById(R.id.goods_img);
            holder.title= (TextView) convertView.findViewById(R.id.goods_title);
            convertView.setTag(holder);
        }
        ImageView shopimg=holder.shopPic;
        TextView shopTitle=holder.title;
        Shop item=shops.get(position);
        //shopimg.setBackground();
        //shopTitle.setText();
        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }
    //增加列表
    public void AddMore(ArrayList<Shop> items){
        this.shops.addAll(items);
        this.notifyDataSetChanged();
    }
}
class ViewHolder{
    ImageView shopPic;
    TextView  title;
}