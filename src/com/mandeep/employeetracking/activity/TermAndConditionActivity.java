package com.mandeep.employeetracking.activity;


import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.CommonUtils;
import com.mandeep.employeetracking.model.ApplicationScopeData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TermAndConditionActivity extends Activity implements OnClickListener{

	private TextView tvHeader;
	private ImageView ivLogout;
	private Button btnAccept;
	private Intent intent;
	private CheckBox cbCheck;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_term_and_condition);
		getID();

		setListener();

		ivLogout.setVisibility(View.VISIBLE);
		tvHeader.setText("Terms & Conditions");
	}

	private void setListener() {
		ivLogout.setOnClickListener(this);

		btnAccept.setOnClickListener(this);
	}

	private void getID() {
		ivLogout = (ImageView)findViewById(R.id.ivLogout);

		tvHeader = (TextView)findViewById(R.id.tvHeader);

		btnAccept=(Button)findViewById(R.id.btn_next);

		cbCheck = (CheckBox) findViewById(R.id.cb_termconditions);
	}

	@Override
	public void onClick(View v) {

		switch(v.getId()){

		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;

		case R.id.tv_next :
			intent=new Intent(this,SearchResultsActivity.class);
			startActivity(intent);

			break;


		case R.id.btn_next :
			if(cbCheck.isChecked()){
				if(ApplicationScopeData.isTermAndCondition)
				{
					startActivity(new Intent(this,SearchResultsActivity.class));
					ApplicationScopeData.isTermAndCondition=false;
				}else
				{
					finish();
				}
			}
			else if(!cbCheck.isChecked())
			{
				CommonUtils.ShowalertTitleCustomize("Please check to accept 'Terms & Conditions'", this);
			}
			break;
		}

	}


}
