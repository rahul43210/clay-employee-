package com.mandeep.employeetracking.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.adapters.OrderAdapter;
import com.mandeep.employeetracking.adapters.spinnerAreaAdapter;
import com.mandeep.employeetracking.adapters.spinnerStatusAdapter;
import com.mandeep.employeetracking.constants.CommonUtils;
import com.mandeep.employeetracking.model.OrderDetails;












import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeScreenActivity extends Activity implements OnClickListener {
	
	private TextView tvHeader,tv_Go;
	private ImageView logout;
	private EditText et_SearchByDate;
	private Spinner sp_SearchByArea,sp_SearchByStatus;
	private ListView lv_OrdersDetails;
	private String[] cities_name= {"Search by Area","New Delhi","Mumbai","Chennai","Kolkata"};
	private String[] status= {"Search by Status","Complete","Pending"};
	private int[] RAF_NO={2345657,2345658,2345657,2345659,2345660,2345659,2345660,2345657,2345658,2345657,2345659,2345660};
	private String[] order_type= {"Delivery","Delivery","Pullback","Pullback","Pullback","Pullback","Pullback","Delivery","Delivery","Pullback","Pullback","Pullback"};
	private String[] sim_type= {"Prepaid","Prepaid","Prepaid","Prepaid","Postpaid","Prepaid","Prepaid","Prepaid","Prepaid","Prepaid","Prepaid","Postpaid"};
	private String[] location= {"Delhi","Noida","FBD","Delhi","Delhi","Delhi","Delhi","Delhi","Noida","FBD","Delhi","Delhi"};
	private String[] time= {"10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM","10:00 AM"};
	private ArrayList<OrderDetails> arr_order;
	private OrderDetails orders;
	
	private boolean flag=false;
	private DatePickerDialog fromDatePickerDialog;
	private SimpleDateFormat dateFormatter;
	private int pos1,pos2;
	private LinearLayout llWelcome;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acivity_welcome_screen);
		getId();
		
		
		
	
		
		setListener();
		setDateTimeField();
		
		dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

		spinnerAreaAdapter adapterCities = new spinnerAreaAdapter(WelcomeScreenActivity.this,cities_name);
		sp_SearchByArea.setAdapter(adapterCities);
		
		spinnerStatusAdapter adapterStatus = new spinnerStatusAdapter(WelcomeScreenActivity.this,status);
		sp_SearchByStatus.setAdapter(adapterStatus);
		
		
		sp_SearchByArea.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				pos1=position;
				setdata();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			
			
			}
		});
		
		sp_SearchByStatus.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				pos2=position;
				setdata();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			
		
			}
		});
	
		
		tvHeader.setText("Welcome");
	    logout.setVisibility(View.VISIBLE);
	arr_order = new ArrayList<OrderDetails>();
		
		for(int i = 0; i<order_type.length;i++)
		{
		    orders = new OrderDetails(RAF_NO[i],order_type[i],sim_type[i],location[i],time[i]);
			arr_order.add(orders);
		}
		
		OrderAdapter order_adapter=new OrderAdapter(WelcomeScreenActivity.this,arr_order);
		lv_OrdersDetails.setAdapter(order_adapter);
		lv_OrdersDetails.setVisibility(View.VISIBLE);
		
	}

	private void setDateTimeField() {
		
		   et_SearchByDate.setOnClickListener(this);
	      
	       Calendar newCalendar = Calendar.getInstance();
	        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
	 
	            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
	                Calendar newDate = Calendar.getInstance();
	                newDate.set(year, monthOfYear, dayOfMonth);
	                et_SearchByDate.setText(dateFormatter.format(newDate.getTime()));
	                setdata();
	 		       
	            }
	 
	        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
	        
	      
		
	}

	private void setListener() {
		tv_Go.setOnClickListener(this);
		
	}
	
	
	

	private void getId() {
		tvHeader=(TextView) findViewById(R.id.tvHeader);
		logout=(ImageView) findViewById(R.id.ivLogout);
		tv_Go=(TextView) findViewById(R.id.tv_Go);
		et_SearchByDate=(EditText) findViewById(R.id.et_SearchByDate);
		et_SearchByDate.requestFocus();
		sp_SearchByArea=(Spinner) findViewById(R.id.sp_SearchByArea);
		sp_SearchByStatus=(Spinner) findViewById(R.id.sp_SearchByStatus);
		lv_OrdersDetails=(ListView) findViewById(R.id.lv_OrderDetails);
		logout.setOnClickListener(this);
		
		llWelcome=(LinearLayout)findViewById(R.id.ll_welcome);
		
		
			
		llWelcome.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				InputMethodManager imm = (InputMethodManager)WelcomeScreenActivity.this.getSystemService(WelcomeScreenActivity.this.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(et_SearchByDate.getWindowToken(), 0);
				
				return false;
			}
		});
	}

	@Override
	public void onClick(View v) {
		
	
		
		switch (v.getId()) 
		{
		case R.id.tv_Go:
startActivity(new Intent(this,SearchScreenActivity.class));
finish();	
			
			break;

			
		case R.id.et_SearchByDate:
			
			 
		            fromDatePickerDialog.show();
		        	break;       
		case R.id.ivLogout:
			
			 
           CommonUtils.AlertLogout(this);
        	break;
		default:
			break;
		}
		
	}
 void setdata(){
	if( (pos1==0) && (pos2==0) )
	{

		flag=false;
	}
	else
	{
	
		flag=true;
	}
	
	if( (flag) || ((et_SearchByDate.getText().toString()).length()>0) )
	{
						
		arr_order = new ArrayList<OrderDetails>();
		
		for(int i = 0; i<order_type.length;i++)
		{
		    orders = new OrderDetails(RAF_NO[i],order_type[i],sim_type[i],location[i],time[i]);
			arr_order.add(orders);
		}
		
		OrderAdapter order_adapter=new OrderAdapter(WelcomeScreenActivity.this,arr_order);
		lv_OrdersDetails.setAdapter(order_adapter);
		lv_OrdersDetails.setVisibility(View.VISIBLE);
	}
	
	else
		{
		  
		
		}
		
}

 

}

