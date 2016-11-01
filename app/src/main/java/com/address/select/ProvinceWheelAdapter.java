package com.address.select;

import java.util.List;

import com.wdys.android_learn.BaseApplication;
import com.wdys.android_learn.R;


import android.content.Context;


public class ProvinceWheelAdapter implements WheelAdapter {
	
	private List<String> provinces;
	
	public ProvinceWheelAdapter(Context context){
		provinces = BaseApplication.Acity;
	}

	@Override
	public int getItemsCount() {
		return provinces == null ? 0 : provinces.size();
	}

	@Override
	public String getItem(int index) {
		return provinces.get(index);
	}

	@Override
	public int getMaximumLength() {
		return 7;
	}
	
	@Override
	public String getCurrentId(int index) {
		return "";
	}

}
