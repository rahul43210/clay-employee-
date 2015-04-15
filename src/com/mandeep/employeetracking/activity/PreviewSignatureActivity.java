package com.mandeep.employeetracking.activity;

import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
	
public class PreviewSignatureActivity extends Activity implements OnClickListener{
	private TextView tvHeader;
	private ImageView ivLogout,iv_signature_preview;
	private Bitmap bitmap;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preview_signature);
		getId();
		tvHeader.setText("Preview Signature");
		ivLogout.setVisibility(View.VISIBLE);
		Intent intent = getIntent();
	
		setListener();
		Cursor cc = this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null,null);
		startManagingCursor(cc);
		
		
	//	iv_signature_preview.setImageBitmap(bitmap);
		iv_signature_preview.setImageURI(/*Uri.withAppendedPath(MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI,*/Uri.parse(getIntent().getStringExtra("uri")));
	
	//01-23 06:57:25.118: D/mess(2495): Signature_1422014245106.jpg
		
		//01-23 19:20:14.877: D/mess(13011): file:///storage/emulated/0/Pictures/SignaturePad/Signature_1422021014792.jpg


	}

	private void setListener() {
		ivLogout.setOnClickListener(this);
		iv_signature_preview.setOnClickListener(this);
	}

	private void getId() {
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		iv_signature_preview = (ImageView)findViewById(R.id.iv_signature_preview);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;
		case R.id.iv_signature_preview:
			
			break;
		}
		
	}
}
