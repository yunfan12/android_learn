package com.address.select;



import com.wdys.android_learn.R;
import com.wdys.android_learn.BaseApplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
  * 类描�?:	地址选择器的自定义布�?   
  * 项目名称:  DateSelector   
  * 类名�?:   AreasWheel 
  * 创建�?:    xhl  
  * 创建时间:  2015-2-5 上午10:11:53     
  * 版本:      v1.0
 */
public class AreasWheel extends LinearLayout {
	private WheelView wv_province;
	private WheelView wv_city;
	private WheelView wv_county;
	public int screenheight;
	private Context context;
	private OnWheelChangedListener provinceChangedListener;
	private OnWheelChangedListener cityChangedListener;
	private CityWheelAdapter cityWheelAdapter;
	private ProvinceWheelAdapter provinceWheelAdapter;
	private CountyWheelAdapter countyWheelAdapter;
	private String province=BaseApplication.Acity.get(0);
	private String City=BaseApplication.Bcity.get(province).get(0);
	/**
	 * 城市列表
	 */
	private final int[] ARRAY_CITY = new int[] { R.array.beijin_province_item,
			R.array.heibei_province_item, R.array.shandong_province_item,
			R.array.shanghai_province_item, R.array.guangdong_province_item,
			R.array.anhui_province_item, R.array.fujian_province_item,
			R.array.gansu_province_item, R.array.guangxi_province_item,
			R.array.guizhou_province_item, R.array.hainan_province_item,
			R.array.henan_province_item, R.array.heilongjiang_province_item,
			R.array.hubei_province_item, R.array.hunan_province_item,
			R.array.jilin_province_item, R.array.jiangsu_province_item,
			R.array.jiangxi_province_item, R.array.liaoning_province_item,
			R.array.neimenggu_province_item, R.array.ningxia_province_item,
			R.array.qinghai_province_item, R.array.shanxi1_province_item,
			R.array.shanxi2_province_item, R.array.sichuan_province_item,
			R.array.tianjin_province_item, R.array.xizang_province_item,
			R.array.xinjiang_province_item, R.array.yunnan_province_item,
			R.array.zhejiang_province_item, R.array.chongqing_province_item,
			R.array.taiwan_province_item, R.array.hongkong_province_item,
			R.array.aomen_province_item };
	
	

	@SuppressLint("NewApi")
	public AreasWheel(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context = context;
		initView();
	}

	public AreasWheel(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		initView();
	}

	public AreasWheel(Context context) {
		super(context);
		this.context = context;
		initView();
	}

	private void initView() {
		LayoutInflater.from(context).inflate(
				R.layout.province_city_selector_layout, this, true);
		wv_province = (WheelView) findViewById(R.id.wv_province);
		wv_city = (WheelView) findViewById(R.id.wv_city);
		wv_county=(WheelView)findViewById(R.id.wv_county);

		provinceWheelAdapter = new ProvinceWheelAdapter(context);
		wv_province.setAdapter(provinceWheelAdapter);
		wv_province.setCyclic(false);
		wv_province.setVisibleItems(5);
		wv_province.setCurrentItem(0);

		cityWheelAdapter = new CityWheelAdapter(context,
				BaseApplication.Bcity.get(province));
		wv_city.setAdapter(cityWheelAdapter);
		wv_city.setCyclic(false);
		wv_city.setVisibleItems(5);
		
		countyWheelAdapter = new CountyWheelAdapter(context,
				BaseApplication.Ccity.get(City));
		wv_county.setAdapter(countyWheelAdapter);
		wv_county.setCyclic(false);
		wv_county.setVisibleItems(5);

		provinceChangedListener = new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				province=BaseApplication.Acity.get(newValue);
				cityWheelAdapter.setCityList(BaseApplication.Bcity.get(province));
				wv_city.setAdapter(cityWheelAdapter);
				wv_city.setCurrentItem(0);
				countyWheelAdapter.setCityList(BaseApplication.Ccity.get(BaseApplication.Bcity.get(province).get(0)));
				wv_county.setAdapter(countyWheelAdapter);
				wv_county.setCurrentItem(0);
			}
		};
		wv_province.addChangingListener(provinceChangedListener);
		
		cityChangedListener = new OnWheelChangedListener() {

			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				City=BaseApplication.Bcity.get(province).get(newValue);
				countyWheelAdapter.setCityList(BaseApplication.Ccity.get(City));
				wv_county.setAdapter(countyWheelAdapter);
				wv_county.setCurrentItem(0);
			}
		};
		wv_city.addChangingListener(cityChangedListener);
	}

	/**
	 * 获取省市字符�?
	 * 
	 * @return
	 */
	public String getArea() {
		return wv_province.getCurrentItemValue() + " "
				+ wv_city.getCurrentItemValue()+" "+wv_county.getCurrentItemValue();
	}
	/**
	 * 获取省份的Id
	 * @return
	 */
	public String getProvinceId(){
		return wv_province.getCurrentItemId();
	}
	/**
	 * 获取城市的Id
	 * @return
	 */
	public String getCityId(){
		return wv_city.getCurrentItemId();
	}
	/**
	 * 获取县的Id
	 * @return
	 */
	public String getCountyId(){
		return wv_county.getCurrentItemId();
	}
}
