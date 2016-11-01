package com.wdys.android_learn.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wdys.android_learn.R;
import com.wdys.android_learn.cusview.ImageCycleView;
import com.wdys.android_learn.pojo.ADInfo;
import com.wdys.android_learn.pojo.TitleImage;
import com.wdys.android_learn.util.ImageLoaderUtil;

import java.util.ArrayList;


/**
 * Created by wenqian on 2016/10/28.
 */
public class MainFragment extends Fragment {
    private View view;
    private int screenWidth;
    private ArrayList<TitleImage> banners;
    private String style;
    private ImageCycleView homeBanners;
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();//图片信息
    private ImageCycleView.ImageCycleViewListener mAdCycleViewListener;
    private String Tag = "HomePageFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_main, null);
        screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        this.Init();
        return view;
    }
    private void Init(){
        homeBanners= (ImageCycleView) view.findViewById(R.id.home_banner);
        this.banners=new ArrayList<TitleImage>();
        ADInfo item=new ADInfo();
        item.setId(1+"");
        item.setUrl("http://photo.enterdesk.com/2009-4-21/200901241609531378.png");
        item.setContent("test");
        item.setType("png");
        infos.add(item);
        mAdCycleViewListener=new ImageCycleView.ImageCycleViewListener() {

            @Override
            public void onImageClick(ADInfo info, int position, View imageView) {
            /*if (!TextUtils.isEmpty(ImageList.get(position).getShopid())) {
                Intent intent;
				intent=new Intent(getActivity(), ShareActivity.class);
			*//*String SpellbuyProductId=ImageList.get(position).getGougouid();
			intent.putExtra(Cons.PRODUCT_ID, SpellbuyProductId);*//*
				startActivity(intent);
			} else {
				((MainActivity)getActivity()).MainViewPager.setCurrentItem(1);
			}*/
                Intent intent = null;
                String shopid = banners.get(position).getShopid();
                if (shopid.equals("c0")) {//女性专区
                   //enterQuotaPrefectureActivity(intent);
                }
//			else if (shopid.equals("c1")) {//软件中心
//				if (YYGGApplication.IsLogin) {
//					OffersManager.getInstance(getActivity()).showOffersWall();
//					new YoumiBiz(handler, getActivity());
//					/*OffersBrowserConfig.setBrowserTitleText("赚取奖励" + "    " + (PointsManager.getInstance(getActivity()).queryPoints() / 100) + "元");
//					OffersManager.getInstance(getActivity()).showOffersWall();*/
//				} else {
//					goLoginActivity();
//					getActivity().overridePendingTransition(R.anim.in_from_top, R.anim.out_from_no);
//				}
//			}
                else if (shopid.equals("c3")) {//邀请好友
                    //enterShareActivity(intent);
                } else {//商品详情
                    //enterConmmodityParticularsActivity(intent, ImageList.get(position).getShopid());
                }
                homeBanners.startImageCycle();
            }

            @Override
            public void displayImage(String imageURL, ImageView imageView) {
                ImageLoaderUtil util = new ImageLoaderUtil();
                util.ImageLoader(getActivity(), imageURL, imageView);
            }
        };
        homeBanners.setImageResources(infos,mAdCycleViewListener, Tag);
    }
    //刷新
    public void refresh(){
        //setData();
    }

    @Override
    public void onResume() {
        homeBanners.startImageCycle();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeBanners.pushImageCycle();
    }
}
