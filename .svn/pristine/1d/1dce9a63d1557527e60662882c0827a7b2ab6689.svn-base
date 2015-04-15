package com.mandeep.employeetracking.activity;



import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderIncompleteActivity extends Activity implements OnClickListener {
	
	private TextView tvHeader,tv_Submit;
	private ImageView ivLogout;
	private EditText et_AnyOtherReason;
	RadioGroup rg_ReasoSelect;
	RadioButton rb_IncompleteDocuments,rb_CustomerNotAvailable;
	private LinearLayout llOrderIncomplete;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_incomplete_screen);
		getId();
		tvHeader.setText("Order Incomplete");
		
		
	}

	private void getId() {
		tvHeader=(TextView) findViewById(R.id.tvHeader);
		ivLogout=(ImageView) findViewById(R.id.ivLogout);
		tv_Submit=(TextView) findViewById(R.id.tv_Submit);
		et_AnyOtherReason=(EditText) findViewById(R.id.et_AnyOtherReason);
		rg_ReasoSelect=(RadioGroup) findViewById(R.id.rg_ReasoSelect);
		rb_CustomerNotAvailable=(RadioButton) findViewById(R.id.rb_CustomerNotAvailable);
		rb_IncompleteDocuments=(RadioButton) findViewById(R.id.rb_IncompleteDocuments);
		llOrderIncomplete=(LinearLayout) findViewById(R.id.ll_orderincomplete);
		
		tv_Submit.setOnClickListener(this);
		ivLogout.setOnClickListener(this);
		
		llOrderIncomplete.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				InputMethodManager imm = (InputMethodManager)OrderIncompleteActivity.this.getSystemService(OrderIncompleteActivity.this.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et_AnyOtherReason.getWindowToken(), 0);
				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.tv_Submit:
		
		Intent intent = new Intent(this,OrderDetailActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		finish();	
		break;
	case R.id.ivLogout:
		CommonUtils.AlertLogout(this);
		break;
	default:
		break;
	}
		
	}

}
