package com.mandeep.employeetracking.activity;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchTextActivity extends Activity implements OnClickListener{

	private TextView tvHeader,tv_search;
	private EditText et_passport_num;
	private ImageView ivLogout;
	private Intent intent;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_search_screen);

		getId();
		tvHeader.setText("Preview Signature");
		ivLogout.setVisibility(View.VISIBLE);

		setListener();


	}


	private void getId() {

		ivLogout =(ImageView)findViewById(R.id.ivLogout);
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		tv_search = (TextView)findViewById(R.id.tv_search);
		et_passport_num = (EditText)findViewById(R.id.et_passport_num);

	}
	private void setListener() {
		tv_search.setOnClickListener(this);
		ivLogout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){

		case R.id.tv_search:
			if(checkIsEmpty()){
			intent=new Intent(SearchTextActivity.this,SearchResultsActivity.class);
			startActivity(intent);
			}
			break;

		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;
		}

	}


	private boolean checkIsEmpty() {
		// TODO Auto-generated method stub
		if(et_passport_num.getText().toString().trim().length()==0)
		{
			CommonUtils.ShowalertTitleCustomize("Password field is required." , this);
			return false;
		}
		else
		return true;
	}

}