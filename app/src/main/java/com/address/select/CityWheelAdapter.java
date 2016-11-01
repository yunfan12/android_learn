package com.address.select;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class CityWheelAdapter implements WheelAdapter {
	
	private List<String> cities;
	private Context context;
	
	public CityWheelAdapter(Context context, ArrayList<String> list){
		this.context = context;
		this.cities = list;
	}

	@Override
	public int getItemsCount() {
		return cities == null ? 0 : cities.size();
	}

	@Override
	public String getItem(int index) {
		return cities.get(index);
	}

	@Override
	public int getMaximumLength() {
		return 7;
	}
	
	public void setCityList(ArrayList<String> provinceId){
		this.cities = provinceId;
	}

	@Override
	public String getCurrentId(int index) {
		return "";
	}
}
