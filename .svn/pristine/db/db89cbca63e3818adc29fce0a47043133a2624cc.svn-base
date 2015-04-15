package com.mandeep.employeetracking.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.adapters.CheckListAdapter;
import com.mandeep.employeetracking.constants.CommonUtils;
import com.mandeep.employeetracking.model.ApplicationScopeData;
import com.mandeep.employeetracking.model.CheckListPojo;

public class CheckListActivity extends Activity implements OnClickListener{
	
	private String[] questions = {"Dialing Instruction","Package Attached","Sim Card / sim slot Issued","Pouch Issued","Pouch Issued"};
	private CheckListPojo pojo_checklist;
	private CheckListAdapter adapter;
	private ListView lv_checklist;
	private ArrayList<CheckListPojo> arr_list;
	private TextView tvHeader,tvTermCondition,tvUpload;
	private ImageView ivLogout;
	
	private CheckBox cbTermCondition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_list);
		getId();
		tvHeader.setText("Checklist");
		ivLogout.setVisibility(View.VISIBLE);
		arr_list = new ArrayList<CheckListPojo>();
		for(int i =0; i<questions.length;i++){
			pojo_checklist = new CheckListPojo(questions[i]);
			arr_list.add(pojo_checklist);
		}
		adapter = new CheckListAdapter(this,arr_list);
		lv_checklist.setAdapter(adapter);
		
		setListener();
	}

	private void setListener() {
		ivLogout.setOnClickListener(this);
		//tvTermCondition.setOnClickListener(this);
		
		tvUpload.setOnClickListener(this);
	}

	private void getId() {
		lv_checklist = (ListView)findViewById(R.id.lv_checklist);
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		
		cbTermCondition = (CheckBox) findViewById(R.id.cb_agree_conditions);
		tvTermCondition = (TextView) findViewById(R.id.tv_terms_conditions);
		
		tvUpload = (TextView) findViewById(R.id.tv_upload);
		
	}

	@Override
	public void onClick(View v) {
	switch(v.getId()){
		
	case R.id.ivLogout:
		CommonUtils.AlertLogout(this);
		break;
		
	case R.id.tv_terms_conditions:
		
		startActivity(new Intent(this,TermAndConditionActivity.class));
		
		break;
		
	case R.id.tv_upload:
		
		if(cbTermCondition.isChecked())
		{
			ApplicationScopeData.isTermAndCondition=true;
			startActivity(new Intent(CheckListActivity.this,TermAndConditionActivity.class));
		}
		else if(!cbTermCondition.isChecked())
		{
			CommonUtils.ShowalertTitleCustomize("Please check to accept 'Terms & Conditions'", this);
		}
		
		break;
	}
	}
}
