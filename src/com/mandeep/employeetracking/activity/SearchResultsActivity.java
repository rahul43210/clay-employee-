package com.mandeep.employeetracking.activity;


import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.R.layout;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SearchResultsActivity extends Activity implements OnClickListener{

	private TextView tvHeader,tvPassportPreview,tvCreditCardTextPreview;
	private ImageView ivLogout;
	private Button btnNext;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results);

		getID();

		setListener();

		ivLogout.setVisibility(View.VISIBLE);
		tvHeader.setText("Search Results");

	}

	private void setListener() {
		ivLogout.setOnClickListener(this);
		btnNext.setOnClickListener(this);

		tvPassportPreview.setOnClickListener(this);
		tvCreditCardTextPreview.setOnClickListener(this);

	}

	private void getID() {
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		btnNext = (Button)findViewById(R.id.btn_search_res_next);

		tvHeader = (TextView)findViewById(R.id.tvHeader);

		tvPassportPreview=(TextView)findViewById(R.id.tv_passporttext);
		tvCreditCardTextPreview=(TextView)findViewById(R.id.tv_creditcardtext);



	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){

		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;

		case R.id.btn_search_res_next:
			intent=new Intent(SearchResultsActivity.this,UploadDocumentsActivity.class);
			startActivity(intent);


			break;

		case R.id.tv_passporttext:
			Toast.makeText(getApplicationContext(), "Work at progress", Toast.LENGTH_LONG).show();

			break;

		case R.id.tv_creditcardtext:
			Toast.makeText(getApplicationContext(), "Work at progress", Toast.LENGTH_LONG).show();

			break;
		}
	}


}
