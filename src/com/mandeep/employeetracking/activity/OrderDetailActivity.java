package com.mandeep.employeetracking.activity;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.R.id;
import com.mandeep.employeetracking.R.layout;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends Activity implements OnClickListener{
	private TextView tvHeader,tv_order_no,tv_order_no_value,tv_raf_no,tv_raf_no_value,tv_username,tv_username_value,tv_CordinateName,tv_CordinateName_value,tv_customer_address,tv_customer_address_value,
	tv_complete_thisorder,tv_search_for_documants,tv_order_cantbecompleted;
	private ImageView ivLogout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_detail);
		
		getId();
		setListener();
		tvHeader.setText("Order Detail");
		
	}
	private void getId() {
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		tv_order_no = (TextView)findViewById(R.id.tv_order_no);
		tv_order_no_value = (TextView)findViewById(R.id.tv_order_no_value);
		tv_raf_no = (TextView)findViewById(R.id.tv_raf_no);
		tv_raf_no_value = (TextView)findViewById(R.id.tv_raf_no_value);
		tv_username = (TextView)findViewById(R.id.tv_username);
		
		tv_username_value = (TextView)findViewById(R.id.tv_username_value);
		tv_CordinateName = (TextView)findViewById(R.id.tv_CordinateName);
		tv_CordinateName_value = (TextView)findViewById(R.id.tv_CordinateName_value);
		tv_customer_address = (TextView)findViewById(R.id.tv_customer_address);
		tv_customer_address_value = (TextView)findViewById(R.id.tv_customer_address_value);
		tv_complete_thisorder = (TextView)findViewById(R.id.tv_complete_thisorder);
		tv_search_for_documants = (TextView)findViewById(R.id.tv_search_for_documants);
		tv_order_cantbecompleted = (TextView)findViewById(R.id.tv_order_cant);
		
		
		
	}
	@Override
	public void onClick(View v) {
switch(v.getId()){
		
		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;
			
		case R.id.tv_complete_thisorder:
			
			Intent intent = new Intent(this,RAFActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			break;
		case R.id.tv_search_for_documants:
			
			 intent = new Intent(this,OrderIncompleteActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();	
			break;
		case R.id.tv_order_cant:
			Toast.makeText(this, "Work in progress", Toast.LENGTH_SHORT).show();
			break;
			
		}
	}
	private void setListener() {
		ivLogout.setOnClickListener(this);
		tv_complete_thisorder.setOnClickListener(this);
		tv_search_for_documants.setOnClickListener(this);
		tv_order_cantbecompleted.setOnClickListener(this);
		
	}
}
