package com.mandeep.employeetracking.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mandeep.employeetracking.R;

public class SplashScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		Thread timer=new Thread()
		{
			@Override
			public void run()
			{
				try
				{   //activity sleep after three seconds
					sleep(3000);
				} 
				catch (InterruptedException e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}
				
				finally
				{
					Intent login_screen=new Intent(SplashScreenActivity.this,LoginScreenActivity.class);
					startActivity(login_screen);
					finish();
				}
			}
			
		};
		
		timer.start();

	}
}

