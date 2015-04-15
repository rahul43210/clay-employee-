package com.mandeep.employeetracking.activity;


import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.R.layout;
import com.mandeep.employeetracking.constants.CommonUtils;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class UploadDocumentsActivity extends Activity implements OnClickListener{


	private static final int CAMERA_REQUEST = 1888;
	private static final int RESULT_OK = -1; 
	private static int RESULT_LOAD_IMAGE = 1;
	private static final int SELECT_PICTURE = 1;


	private TextView tvHeader,tvEdit,tvPreview;
	private ImageView ivLogout,ivCreditCard,ivLetterHead,ivCash,ivCheque,ivCardImage;
	private EditText etCardNumber;
	private Intent intent;
	private Button btnNext;
	private LinearLayout llLinearImage,llBackground;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload_documents);

		getID();

		setListener();

		ivLogout.setVisibility(View.VISIBLE);
		tvHeader.setText(getString(R.string.ud_header));


	}

	private void setListener() {

		ivLogout.setOnClickListener(this);

		btnNext.setOnClickListener(this);

		ivCreditCard.setOnClickListener(this);
		ivCash.setOnClickListener(this);
		ivCheque.setOnClickListener(this);
		ivLetterHead.setOnClickListener(this);
		ivCardImage.setOnClickListener(this);

		tvEdit.setOnClickListener(this);
		tvPreview.setOnClickListener(this);
		
		llBackground.setOnClickListener(this);
	}

	private void getID() {
		ivLogout = (ImageView)findViewById(R.id.ivLogout);

		tvHeader = (TextView)findViewById(R.id.tvHeader);

		ivCreditCard=(ImageView)findViewById(R.id.iv_creditcard);

		ivCash=(ImageView)findViewById(R.id.iv_cash);

		ivLetterHead=(ImageView)findViewById(R.id.iv_letterhead);

		ivCheque=(ImageView)findViewById(R.id.iv_cheque);

		etCardNumber=(EditText)findViewById(R.id.et_creditcard_num);

		btnNext=(Button)findViewById(R.id.btn_next);

		ivCardImage=(ImageView)findViewById(R.id.iv_card);

		llLinearImage=(LinearLayout)findViewById(R.id.ll_linearimage);
		llBackground=(LinearLayout)findViewById(R.id.ll_LinearLayout1);
		
		tvEdit=(TextView)findViewById(R.id.tv_edit);
		tvPreview=(TextView)findViewById(R.id.tv_preview);
	}

	@Override
	public void onClick(View v) {

		if(v==ivLogout)
		{
			CommonUtils.AlertLogout(this);
		}

		if(v==btnNext)
		{
			if(checkImage()){


				if(etCardNumber.isShown())
				{
					if(checkIsEmpty())
					{
						intent=new Intent(UploadDocumentsActivity.this,UploadSignatureActivity.class);
						startActivity(intent);
					}
				}
				else
				{
					intent=new Intent(UploadDocumentsActivity.this,UploadSignatureActivity.class);
					startActivity(intent);
				}
			}

		}

		if(v==ivCreditCard)
		{
			ivCash.setImageResource(R.drawable.radio_icon);
			ivCheque.setImageResource(R.drawable.radio_icon);
			ivLetterHead.setImageResource(R.drawable.radio_icon);

			ivCreditCard.setImageResource(R.drawable.radio_icon_sel);

			etCardNumber.setVisibility(View.VISIBLE);
		}

		if(v==ivCash)
		{
			ivCash.setImageResource(R.drawable.radio_icon_sel);
			ivCheque.setImageResource(R.drawable.radio_icon);
			ivLetterHead.setImageResource(R.drawable.radio_icon);

			ivCreditCard.setImageResource(R.drawable.radio_icon);
			
			InputMethodManager imm = (InputMethodManager)UploadDocumentsActivity.this.getSystemService(UploadDocumentsActivity.this.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etCardNumber.getWindowToken(), 0);
			
			etCardNumber.setVisibility(View.GONE);
		}

		if(v==ivCheque)
		{
			ivCash.setImageResource(R.drawable.radio_icon);
			ivCheque.setImageResource(R.drawable.radio_icon_sel);
			ivLetterHead.setImageResource(R.drawable.radio_icon);

			ivCreditCard.setImageResource(R.drawable.radio_icon);
			
			InputMethodManager imm = (InputMethodManager)UploadDocumentsActivity.this.getSystemService(UploadDocumentsActivity.this.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etCardNumber.getWindowToken(), 0);
			
			
			etCardNumber.setVisibility(View.GONE);
		}

		if(v==ivLetterHead)
		{
			ivCash.setImageResource(R.drawable.radio_icon);
			ivCheque.setImageResource(R.drawable.radio_icon);
			ivLetterHead.setImageResource(R.drawable.radio_icon_sel);

			ivCreditCard.setImageResource(R.drawable.radio_icon);
			
			InputMethodManager imm = (InputMethodManager)UploadDocumentsActivity.this.getSystemService(UploadDocumentsActivity.this.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etCardNumber.getWindowToken(), 0);
			
			
			etCardNumber.setVisibility(View.GONE);
		}

		if(v==ivCardImage)
		{
			if(ivCardImage.getDrawable()==null)
			{
			selectImage();
			}
			else
			{
				//ProfilePhoto(this);
			}
		}
		
		if(v==tvEdit)
		{
			selectImage();
		}
		
		if(v==tvPreview)
		{
			ProfilePhoto(this);
		}
		
		if(v==llBackground)
		{
			Log.d("mess", "background click");
			InputMethodManager imm = (InputMethodManager)UploadDocumentsActivity.this.getSystemService(UploadDocumentsActivity.this.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etCardNumber.getWindowToken(), 0);
		}
	}

	private void ProfilePhoto(final Activity mActivity) {
		
	 	final ImageView iv_prof_pic_zoom,iv_cross;
			LayoutInflater inflater = LayoutInflater.from(mActivity);
			final Dialog mDialog = new Dialog(mActivity,
					android.R.style.Theme_Translucent_NoTitleBar);
			mDialog.setCanceledOnTouchOutside(true);
			mDialog.getWindow().setLayout(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT);
			mDialog.getWindow().setGravity(Gravity.CENTER);
			//mDialog.getWindow().getAttributes().windowAnimations = R.anim.slide_up;
			WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
			lp.dimAmount = 0.75f;
			mDialog.getWindow()
					.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
			mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			mDialog.getWindow();
			View dialoglayout = inflater.inflate(R.layout.popup_image, null);
			mDialog.setContentView(dialoglayout);
			mDialog.show();
			iv_prof_pic_zoom = (ImageView)dialoglayout.findViewById(R.id.iv_prof_pic_zoom);
			iv_prof_pic_zoom.setImageDrawable(ivCardImage.getDrawable());
			iv_cross = (ImageView)dialoglayout.findViewById(R.id.iv_cross);
			iv_cross.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					mDialog.dismiss();
				}
			});
			mDialog.show();
			}


	private boolean checkImage() {
		if(ivCardImage.getDrawable()==null)
		{
			CommonUtils.ShowalertTitleCustomize("Please upload required document", this);
			return false;
		}
		else
			return true;
	}

	private void selectImage() {
		final CharSequence[] items = { "Take Photo", "Choose from Gallery",
		"Cancel" };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Add Photo!");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int item) {
				if (items[item].equals("Take Photo")) {
					Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					startActivityForResult(cameraIntent, CAMERA_REQUEST);
				} else if (items[item].equals("Choose from Gallery")) {
					Intent intent = new Intent(
							Intent.ACTION_PICK,
							android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
					intent.setType("image/*");
					startActivityForResult(intent, RESULT_LOAD_IMAGE);
				} else if (items[item].equals("Cancel")) {
					dialog.dismiss();
				}
			}
		});
		builder.show();
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) { 
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
			Bitmap photo = (Bitmap) data.getExtras().get("data"); 
			
			
			llLinearImage.setBackgroundColor(this.getResources().getColor(android.R.color.transparent));
			ivCardImage.setImageBitmap(photo);
		}

		else if ( requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaColumns.DATA };

			Cursor cursor = this.getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			
			//Picasso.with(UploadDocumentsActivity.this).load(picturePath).resize(400, 400).into(ivCardImage);
			Bitmap bt_image = BitmapFactory.decodeFile(picturePath);
			ivCardImage.setImageBitmap(bt_image);
		
		}
	}


	private boolean checkIsEmpty() {
		// TODO Auto-generated method stub

		if(etCardNumber.getText().toString().trim().length()==0)
		{
			CommonUtils.ShowalertTitleCustomize("Please enter the card number", this);
			return false;
		}
		else
			return true;
	}



}
