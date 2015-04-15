package com.mandeep.employeetracking.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.AppConstants;
import com.mandeep.employeetracking.constants.CommonUtils;


public class LoginScreenActivity extends Activity implements OnClickListener {

	private EditText etEmail,etPassword;
	private ImageView ivLogout;
	private CheckBox cbRememberMe;
	private TextView tv_login,tv_empty_email,tv_wrong_email,tv_empty_password,tv_wrong_password,tvHeader;
	private String str_email, str_password;
	private LinearLayout llLinearLogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login_screen);
		getId();
		setListener();
		if(!CommonUtils.getPreferencesString(getBaseContext(), AppConstants.EMAILID).equalsIgnoreCase("")){
			etEmail.setText(CommonUtils.getPreferencesString(getBaseContext(), AppConstants.EMAILID));
		}
		if(!CommonUtils.getPreferencesString(getBaseContext(), AppConstants.PASSWORD).equalsIgnoreCase("")){
			etPassword.setText(CommonUtils.getPreferencesString(getBaseContext(), AppConstants.PASSWORD));
		}
		
	}

	private void setListener() {

		tv_login.setOnClickListener(this);
	}

	private void getId() {

		etEmail=(EditText) findViewById(R.id.etEmail);
		etPassword=(EditText) findViewById(R.id.etPassword);
		cbRememberMe=(CheckBox) findViewById(R.id.cbRememberMe);
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		tv_login = (TextView)findViewById(R.id.tv_login);
		tv_empty_email = (TextView)findViewById(R.id.tv_empty_email);
		tv_wrong_email = (TextView)findViewById(R.id.tv_wrong_email);
		tv_empty_password = (TextView)findViewById(R.id.tv_empty_password);
		tv_wrong_password = (TextView)findViewById(R.id.tv_wrong_password);
		ivLogout=(ImageView)findViewById(R.id.ivLogout);
		ivLogout.setVisibility(View.GONE);
		tvHeader.setText(R.string.l_ogin);
		
		llLinearLogin=(LinearLayout)findViewById(R.id.ll_linearlogin);
		
		llLinearLogin.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager)LoginScreenActivity.this.getSystemService(LoginScreenActivity.this.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(etEmail.getWindowToken(), 0);
				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){

		case R.id.tv_login :
			Validations();	
			break;

		}

	}

	private void Validations() {
		str_password = etPassword.getText().toString().trim();
		str_email = etEmail.getText().toString().trim();
		
		
		if(str_email.equalsIgnoreCase("")){
			tv_empty_email.setVisibility(View.VISIBLE);
			tv_wrong_email.setVisibility(View.GONE);
		}
		else if(!CommonUtils.isValidEmail(str_email)){
			tv_empty_email.setVisibility(View.GONE);
			tv_wrong_email.setVisibility(View.VISIBLE);
		}
		else if(CommonUtils.isValidEmail(str_email)&& !str_email.equalsIgnoreCase("")){
			tv_empty_email.setVisibility(View.GONE);
			tv_wrong_email.setVisibility(View.GONE);
		}
		if(str_password.equalsIgnoreCase("")){
			tv_wrong_password.setVisibility(View.GONE);
			tv_empty_password.setVisibility(View.VISIBLE);
		}
		else if(!str_password.equals("123456")){
			tv_wrong_password.setVisibility(View.VISIBLE);
			tv_empty_password.setVisibility(View.GONE);
			
		}
		else if(str_password.equals("123456") && str_password.equals("123456")){
			tv_wrong_password.setVisibility(View.GONE );
			tv_empty_password.setVisibility(View.GONE); 
			if(cbRememberMe.isChecked())
			{

				
					CommonUtils.savePreferencesString(LoginScreenActivity.this, AppConstants.EMAILID, str_email);
				
				
					CommonUtils.savePreferencesString(LoginScreenActivity.this, AppConstants.PASSWORD, str_password);
				
			}
			else
			{	CommonUtils.savePreferencesString(LoginScreenActivity.this, AppConstants.PASSWORD, "");
			CommonUtils.savePreferencesString(LoginScreenActivity.this, AppConstants.EMAILID, "");
			}
			Intent intent = new Intent(LoginScreenActivity.this,WelcomeScreenActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
			
			
		}
		
	}

}
