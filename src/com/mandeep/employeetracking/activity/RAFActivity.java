package com.mandeep.employeetracking.activity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.R.id;
import com.mandeep.employeetracking.R.layout;
import com.mandeep.employeetracking.R.menu;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RAFActivity extends Activity  implements OnClickListener{
private TextView tvHeader,tvRafNo,tvRafNoValue,tvRafDate,
tvRafDateValue,tvACMAnager,tvACManagerValue,tvfranchisseNo,tvfranchisseNoValue,
tvcustomerAgreement,tvcustomerAgreementValue,tvcustomername,tvcustomernameValue,
tvCordinateDetails,tvCoOrdinateName,tvCoOrdinateNameValue,tvcontactNoForCordinate,
tvcontactNoForCordinateValue,tvEmailForCordinate,tvEmailForCordinateValue,tvDeliveryAddrees,
tvDeliveryAddreesValue,tvBillingAddrees,tvBillingAddreesValue,tvUserDetails,tvUserDetailsName,
tvUserDetailsNameValue,tvUserDetailsContactNo,tvUserDetailsContactNoValue,tvUserDetailsEmail,
tvUserDetailsEmailValue,tvUserDetailsDob,tvUserDetailsDobValue,tvUserDetailsNationality,
tvUserDetailsPassportNo,tvUserDetailsPaymentMode,tvcustomerDeclaration,tvcustomerDeclarationValue,
tvproductPackageDetails,tvProductMobileNo,tvProductMobileNoValue,tvProductHandset,tvProductHandsetValue,
tvProductDataCard,tvProductDataCardValue,tvProductWifi,tvProductWifiValue,tvProducttravelCountry,tvProducttravelCountryValue,
tvProductDeliveryLocation,tvProductDeliveryLocationValue,tvProductSim,tvProductSimValue,tvProductImiei,tvProductImieiValue,
tvProductTravellingDate,tvProductTravellingDateValue,tvProductDelivryDate,tvProductDelivryDateValue,tvProductPackage,
tvProductPackageValue,tvProductExpReturnDate,tvProductExpReturnDateValue,tvProductDelivrytime,tvProductDelivrytimeValue,
tvValueAddedServices,tvValueAddedServicesGPRS,tvValueAddedServicesGPRSValue,tvValueAddedServicesIntroaming,tvValueAddedServicesIntroamingValue,
tvValueAddedServicesVoiceMail,tvValueAddedServicesVoiceMailValue,tvValueAddedServicesBalckBerry,tvValueAddedServicesBalckBerryvalue,tvValueAddedServicesDataServices,
tvValueAddedServicesDataServicesValue,tvotherChargesApply,tvotherChargesApplyChangename,tvotherChargesApplyChangenameValue,tvotherChargesApplyAmount,
tvotherChargesApplyAmountValue,tvotherChargesApplyFrequency,tvotherChargesApplyFrequencyValue,tvForDetailedTarrifPlan,tvForDetailedTarrifPlanValue,tvCustomerUnderTaking,
tv_next,tvCustomerUnderTakingValue,tvreturnLossProduct,tvreturnLossProductValue,tvNote,tvNoteValue,tvTerm_Conditions_Clicked;
private CheckBox cbIagre;


private Spinner srUserDetailsNationality ,srUserDetailsPaymentMode;
private EditText EtUserDetailsPassportNo; 
private ImageView ivLogout;
private Intent intent;
private DatePickerDialog fromDatePickerDialog;
 private SimpleDateFormat dateFormatter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_raf);
		getId();
		 dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
		 setDateTimeField();
	}
	private void getId() {
		
		tvHeader=(TextView)findViewById(R.id.tvHeader);
		tvRafNo=(TextView)findViewById(R.id.tvRafNo);
		tvRafNoValue=(TextView)findViewById(R.id.tvRafNoValue);
		tvRafDate=(TextView)findViewById(R.id.tvRafDate);
		tvRafDateValue=(TextView)findViewById(R.id.tvRafDateValue);
		tvACMAnager=(TextView)findViewById(R.id.tvACMAnager);
		tvACManagerValue=(TextView)findViewById(R.id.tvACManagerValue);
		tvfranchisseNo=(TextView)findViewById(R.id.tvfranchisseNo);
		
		tvfranchisseNoValue=(TextView)findViewById(R.id.tvfranchisseNoValue);
		tvcustomerAgreement=(TextView)findViewById(R.id.tvcustomerAgreement);
		tvcustomerAgreementValue=(TextView)findViewById(R.id.tvcustomerAgreementValue);
		tvcustomername=(TextView)findViewById(R.id.tvcustomername);
		
		tvcustomernameValue=(TextView)findViewById(R.id.tvcustomernameValue);
		
		
		tvCordinateDetails=(TextView)findViewById(R.id.tvCordinateDetails);
		tvCoOrdinateName=(TextView)findViewById(R.id.tvCoOrdinateName);
		tvCoOrdinateNameValue=(TextView)findViewById(R.id.tvCoOrdinateNameValue);
		
		tvcontactNoForCordinate=(TextView)findViewById(R.id.tvcontactNoForCordinate);
		tvcontactNoForCordinateValue=(TextView)findViewById(R.id.tvcontactNoForCordinateValue);
		tvEmailForCordinate=(TextView)findViewById(R.id.tvEmailForCordinate);
		tvEmailForCordinateValue=(TextView)findViewById(R.id.tvEmailForCordinateValue);
		tvDeliveryAddrees=(TextView)findViewById(R.id.tvDeliveryAddrees);
		
		tvDeliveryAddreesValue=(TextView)findViewById(R.id.tvDeliveryAddreesValue);
		tvBillingAddrees=(TextView)findViewById(R.id.tvBillingAddrees);
		tvBillingAddreesValue=(TextView)findViewById(R.id.tvBillingAddreesValue);
		tvUserDetails=(TextView)findViewById(R.id.tvUserDetails);
		tvUserDetailsName=(TextView)findViewById(R.id.tvUserDetailsName);
		tvUserDetailsNameValue=(TextView)findViewById(R.id.tvUserDetailsNameValue);
		tvUserDetailsContactNo=(TextView)findViewById(R.id.tvUserDetailsContactNo);
		
		tvUserDetailsContactNoValue=(TextView)findViewById(R.id.tvUserDetailsContactNoValue);
		tvUserDetailsEmail=(TextView)findViewById(R.id.tvUserDetailsEmail);
		tvUserDetailsEmailValue=(TextView)findViewById(R.id.tvUserDetailsEmailValue);
		tvUserDetailsDob=(TextView)findViewById(R.id.tvUserDetailsDob);
		tvUserDetailsDobValue=(TextView)findViewById(R.id.tvUserDetailsDobValue);
		tvUserDetailsNationality=(TextView)findViewById(R.id.tvUserDetailsNationality);
		
		tvUserDetailsPassportNo=(TextView)findViewById(R.id.tvUserDetailsPassportNo);
		tvUserDetailsPaymentMode=(TextView)findViewById(R.id.tvUserDetailsPaymentMode);
		tvcustomerDeclaration=(TextView)findViewById(R.id.tvcustomerDeclaration);
		
		tvcustomerDeclarationValue=(TextView)findViewById(R.id.tvcustomerDeclarationValue);
		tvproductPackageDetails=(TextView)findViewById(R.id.tvproductPackageDetails);
		tvProductMobileNo=(TextView)findViewById(R.id.tvProductMobileNo);
		tvProductMobileNoValue=(TextView)findViewById(R.id.tvProductMobileNoValue);
		tvProductHandset=(TextView)findViewById(R.id.tvProductHandset);
		
		tvProductHandsetValue=(TextView)findViewById(R.id.tvProductHandsetValue);
		tvProductDataCard=(TextView)findViewById(R.id.tvProductDataCard);
		tvProductDataCardValue=(TextView)findViewById(R.id.tvProductDataCardValue);
		tvProductWifi=(TextView)findViewById(R.id.tvProductWifi);
		tvProductWifiValue=(TextView)findViewById(R.id.tvProductWifiValue);
		
		tvProducttravelCountry=(TextView)findViewById(R.id.tvProducttravelCountry);
		tvProducttravelCountryValue=(TextView)findViewById(R.id.tvProducttravelCountryValue);
		tvProductDeliveryLocation=(TextView)findViewById(R.id.tvProductDeliveryLocation);
		tvProductDeliveryLocationValue=(TextView)findViewById(R.id.tvProductDeliveryLocationValue);
		
		tvProductSim=(TextView)findViewById(R.id.tvProductSim);
		tvProductSimValue=(TextView)findViewById(R.id.tvProductSimValue);
		tvProductImiei=(TextView)findViewById(R.id.tvProductImiei);
		tvProductImieiValue=(TextView)findViewById(R.id.tvProductImieiValue);
		tvProductTravellingDate=(TextView)findViewById(R.id.tvProductTravellingDate);
		tvProductTravellingDateValue=(TextView)findViewById(R.id.tvProductTravellingDateValue);
		
		tvProductDelivryDate=(TextView)findViewById(R.id.tvProductDelivryDate);
		tvProductDelivryDateValue=(TextView)findViewById(R.id.tvProductDelivryDateValue);
		tvProductPackage=(TextView)findViewById(R.id.tvProductPackage);
		tvProductPackageValue=(TextView)findViewById(R.id.tvProductPackageValue);
		tvProductExpReturnDate=(TextView)findViewById(R.id.tvProductExpReturnDate);
		
		tvProductExpReturnDateValue=(TextView)findViewById(R.id.tvProductExpReturnDateValue);
		tvProductDelivrytime=(TextView)findViewById(R.id.tvProductDelivrytime);
		tvProductDelivrytimeValue=(TextView)findViewById(R.id.tvProductDelivrytimeValue);
		tvValueAddedServices=(TextView)findViewById(R.id.tvValueAddedServices);
		
		tvValueAddedServicesGPRS=(TextView)findViewById(R.id.tvValueAddedServicesGPRS);
		tvValueAddedServicesGPRSValue=(TextView)findViewById(R.id.tvValueAddedServicesGPRSValue);
		tvValueAddedServicesIntroaming=(TextView)findViewById(R.id.tvValueAddedServicesIntroaming);
		
		tvValueAddedServicesIntroamingValue=(TextView)findViewById(R.id.tvValueAddedServicesIntroamingValue);
		tvValueAddedServicesVoiceMail=(TextView)findViewById(R.id.tvValueAddedServicesVoiceMail);
		
		tvValueAddedServicesVoiceMailValue=(TextView)findViewById(R.id.tvValueAddedServicesVoiceMailValue);
		tvValueAddedServicesBalckBerry=(TextView)findViewById(R.id.tvValueAddedServicesBalckBerry);
		tvValueAddedServicesBalckBerryvalue=(TextView)findViewById(R.id.tvValueAddedServicesBalckBerryvalue);
		
		tvValueAddedServicesDataServices=(TextView)findViewById(R.id.tvValueAddedServicesDataServices);
		tvValueAddedServicesDataServicesValue=(TextView)findViewById(R.id.tvValueAddedServicesDataServicesValue);
		tvotherChargesApply=(TextView)findViewById(R.id.tvotherChargesApply);
		
		tvotherChargesApplyChangename=(TextView)findViewById(R.id.tvotherChargesApplyChangename);
		tvotherChargesApplyChangenameValue=(TextView)findViewById(R.id.tvotherChargesApplyChangenameValue);
		tvotherChargesApplyAmount=(TextView)findViewById(R.id.tvotherChargesApplyAmount);
		tvotherChargesApplyAmountValue=(TextView)findViewById(R.id.tvotherChargesApplyAmountValue);
		tvotherChargesApplyFrequency=(TextView)findViewById(R.id.tvotherChargesApplyFrequency);
		
		tvotherChargesApplyFrequencyValue=(TextView)findViewById(R.id.tvotherChargesApplyFrequencyValue);
		tvForDetailedTarrifPlan=(TextView)findViewById(R.id.tvForDetailedTarrifPlan);
		tvForDetailedTarrifPlanValue=(TextView)findViewById(R.id.tvForDetailedTarrifPlanValue);
		
		tvCustomerUnderTaking=(TextView)findViewById(R.id.tvCustomerUnderTaking);
		tvCustomerUnderTakingValue=(TextView)findViewById(R.id.tvCustomerUnderTakingValue);
		
		tvreturnLossProduct=(TextView)findViewById(R.id.tvreturnLossProduct);
		tvreturnLossProductValue=(TextView)findViewById(R.id.tvreturnLossProductValue);
		tvNote=(TextView)findViewById(R.id.tvNote);
		
		tvNoteValue=(TextView)findViewById(R.id.tvNoteValue);
		tv_next=(TextView)findViewById(R.id.tv_next);
		tvTerm_Conditions_Clicked=(TextView)findViewById(R.id.tvTerm_Conditions_Clicked);
		srUserDetailsNationality=(Spinner)findViewById(R.id.srUserDetailsNationality);
		
		srUserDetailsPaymentMode=(Spinner)findViewById(R.id.srUserDetailsPaymentMode);
		EtUserDetailsPassportNo=(EditText)findViewById(R.id.EtUserDetailsPassportNo);
		ivLogout=(ImageView)findViewById(R.id.ivLogout);
		cbIagre=(CheckBox)findViewById(R.id.cbIagre);
		ivLogout.setOnClickListener(this);
		tvTerm_Conditions_Clicked.setOnClickListener(this);
		tv_next.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;
		case R.id.tvTerm_Conditions_Clicked:
			startActivity(new Intent(this,TermAndConditionActivity.class));
			
			break;
		case R.id.tv_next:
			ChecKvalidtion();
			
			break;
		case R.id.tvUserDetailsDobValue:
			
				
		
		      fromDatePickerDialog.show();
			break;
		default:
			break;
		}
		
	}
	private void ChecKvalidtion() {
		if(EtUserDetailsPassportNo.getText().toString().isEmpty())
		{
			CommonUtils.ShowalertTitleCustomize( getString(R.string.enter_the_valid_passport_no_), this);
		}
		else if(cbIagre.isChecked())
		{
			
			Intent intent = new Intent(this,PackageInformationActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
		}
		
	}
	private void setDateTimeField() {
		
		tvUserDetailsDobValue.setOnClickListener(this);
	      
	       Calendar newCalendar = Calendar.getInstance();
	        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
	 
	            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
	                Calendar newDate = Calendar.getInstance();
	                newDate.set(year, monthOfYear, dayOfMonth);
	              
	               
	                long date = System.currentTimeMillis(); 

	               
	                String dateString = dateFormatter.format(date);
	                Calendar cureentdate=Calendar.getInstance();
	                try {
						cureentdate.setTime(dateFormatter.parse(dateString));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                //tvDisplayDate.setText(dateString);
	               // tvUserDetailsDobValue.setText(dateString);
	               if(newDate.before(cureentdate))
                {
                tvUserDetailsDobValue.setText(dateFormatter.format(newDate.getTime()));

              }
            else
            {
              	CommonUtils.ShowalertTitleCustomize(getString(R.string.futer_date_should_not_be_allowed_), RAFActivity.this);

              }
 		       
          
	                }
	 
	        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
	        
	      
		
	}
	
}
