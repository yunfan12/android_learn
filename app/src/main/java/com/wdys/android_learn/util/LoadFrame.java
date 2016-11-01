package com.wdys.android_learn.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wdys.android_learn.R;


public class LoadFrame {
	Dialog dialog;
	/**
	 * 加载框
	 * @param context
	 * @param content  加载时显示的内容
	 */
	 public  LoadFrame(Context context,String content){
		//加载弹窗布局
		LayoutInflater inflater=LayoutInflater.from(context);
		RelativeLayout layout=(RelativeLayout) inflater.inflate(R.layout.load_frame, null);
		TextView loadFrameTextView=(TextView)layout.findViewById(R.id.loadFrameTextView);
		loadFrameTextView.setText(content);
		//创建dialog
		dialog=new AlertDialog.Builder(context).create();
		dialog.setCanceledOnTouchOutside(false);
		dialog.show();
		//给dialog赋值view
		dialog.getWindow().setContentView(layout);
	}
	 public void clossDialog(){
		 if (dialog != null) {
			 dialog.dismiss();
		 }
	 }
	 public boolean isShow(){
		 return dialog.isShowing();
	 }
}
