package com.wdys.android_learn.util;

import com.wdys.android_learn.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.content.Context;
import android.widget.ImageView;

public class ImageLoaderUtil {
	public void ImageLoader(Context context,String uri,ImageView image){
			ImageLoaderConfiguration cofing=new ImageLoaderConfiguration.Builder(context)
			.threadPriority(Thread.NORM_PRIORITY-2)
			.memoryCacheExtraOptions(300,300) // default = device screen dimensions 内存缓存文件的最大长宽
			.denyCacheImageMultipleSizesInMemory()
			.discCacheFileNameGenerator(new Md5FileNameGenerator())
			.discCacheFileCount(100)
			.tasksProcessingOrder(QueueProcessingType.LIFO).build();
			com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(cofing);
			
		    DisplayImageOptions options;  
		    options = new DisplayImageOptions.Builder()  
					.cacheInMemory(true)// 是否緩存都內存中
		            .cacheOnDisc(true)// 是否緩存到sd卡上
					.showImageForEmptyUri(R.drawable.default_image_new) // 设置图片Uri为空或是错误的时候显示的图片
					.showImageOnFail(R.drawable.default_image_new)// 设置图片加载/解码过程中错误时候显示的图片
		            .imageScaleType(ImageScaleType.NONE).build();
		    		
		    // ImageLoader  
		    com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();  
		    // 第一个参数是uri,
		    //第二个参数是显示图片的imageView，
		    //第三个参数是刚刚构造的图片显示选项，
		    //第四个参数是加载的回调方法，displayImage有很多重载方法这中介其中一种；  
		    
		    imageLoader.displayImage(uri,image, options, null); 
	}
	
}
