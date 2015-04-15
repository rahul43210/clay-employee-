package com.mandeep.employeetracking.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.adapters.PackageInformationAdapter;
import com.mandeep.employeetracking.adapters.PackageInformationCouponAdapter;
import com.mandeep.employeetracking.constants.CommonUtils;
import com.mandeep.employeetracking.model.PackageInformationCouponPojo;
import com.mandeep.employeetracking.model.PackageInformationPojo;

public class PackageInformationActivity extends Activity implements OnClickListener{
	private TextView tv_item_value,tv_package_value,tv_rental_value,tv_service_charge_value,
			tv_damage_value,tv_currency_value,tv_min_comm_value,tvHeader,tv_next,tvTermCondition;
	private ImageView ivLogout;
	private ListView lv_package_details,lv_coupons_detail;
	private String[] items = {"Sim_card","Sim_card","Sim_card","Sim_card"};
	private String[] call_type = {"Call Back to India","Call Back to India","Call Back to India","Call Back to India"};
	private String[] unit_price = {"1.450","1.450","1.450","1.450"};
	private String[] min_price = {"1.450","1.450","1.450","1.450"};
	private String[] off_peak_price = {"0.00","0.00","0.00","0.00"};
	private String[] unit = {"60","60","60","60"};
	private String[] min_unit = {"60","60","60","60"};
	private ArrayList<PackageInformationPojo> arr_list;
	private ArrayList<PackageInformationCouponPojo> arr_list_coupon;
	private PackageInformationPojo pojo_package;
	private PackageInformationCouponPojo pojo_Coupon;
	private PackageInformationAdapter adapter_package;
	private PackageInformationCouponAdapter adapter_coupon;
	private CheckBox cbAgreeCondition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_package_information);
		getId();
		tvHeader.setText("Package Information");
		ivLogout.setVisibility(View.VISIBLE);
		arr_list = new ArrayList<PackageInformationPojo>();
		arr_list_coupon = new ArrayList<PackageInformationCouponPojo>();
		for(int i = 0; i<items.length;i++){
			pojo_Coupon = new PackageInformationCouponPojo(items[i], call_type[i], unit_price[i], min_price[i], off_peak_price[i], unit[i]);
			arr_list_coupon.add(pojo_Coupon);
		}
		adapter_coupon = new PackageInformationCouponAdapter(this,arr_list_coupon);
		lv_coupons_detail.setAdapter(adapter_coupon);
		CommonUtils.setListViewHeightBasedOnChildren(lv_coupons_detail);
		for(int i = 0; i<items.length;i++){
			pojo_package = new PackageInformationPojo(items[i], call_type[i], unit_price[i], min_price[i], off_peak_price[i], unit[i], min_unit[i]);
			arr_list.add(pojo_package);
		}
		Log.e("list_data",""+arr_list.size());
		adapter_package = new PackageInformationAdapter(this,arr_list);
		lv_package_details.setAdapter(adapter_package);
		CommonUtils.setListViewHeightBasedOnChildren(lv_package_details);
		setListener();
	}
	
	private void setListener() {
		ivLogout.setOnClickListener(this);
		tvTermCondition.setOnClickListener(this);
	}

	private void getId() {
		tv_item_value = (TextView)findViewById(R.id.tv_item_value);
		tv_package_value = (TextView)findViewById(R.id.tv_package_value);
		tv_rental_value = (TextView)findViewById(R.id.tv_rental_value);
		tv_service_charge_value = (TextView)findViewById(R.id.tv_service_charge_value);
		tv_damage_value = (TextView)findViewById(R.id.tv_damage_value);
		tv_currency_value = (TextView)findViewById(R.id.tv_currency_value);
		tv_min_comm_value =(TextView)findViewById(R.id.tv_min_comm_value);
		lv_package_details = (ListView)findViewById(R.id.lv_package_details);
		lv_coupons_detail = (ListView)findViewById(R.id.lv_coupons_detail);	
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		tv_next = (TextView)findViewById(R.id.tv_next);
		tv_next.setOnClickListener(this);
		tvTermCondition=(TextView)findViewById(R.id.tv_terms_conditions);
		
		cbAgreeCondition=(CheckBox)findViewById(R.id.cb_agree_conditions);
		
		
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
		break;
		case R.id.tv_next:
			if(cbAgreeCondition.isChecked())
			{
			startActivity(new Intent(this,CheckListActivity.class));
			}
			else if(!cbAgreeCondition.isChecked())
			{
				CommonUtils.ShowalertTitleCustomize("Please check to accept 'Terms & Conditions'", this);
			}
		break;
		
		case R.id.tv_terms_conditions:
			startActivity(new Intent(this,TermAndConditionActivity.class));
		break;
		}
		
	}

}	
