package com.mandeep.employeetracking.activity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.github.gcacace.signaturepad.views.SignaturePad;
import com.mandeep.employeetracking.R;
import com.mandeep.employeetracking.constants.CommonUtils;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class UploadSignatureActivity extends Activity implements OnClickListener {
	private static final int CAMERA_REQUEST = 1888;
	private static final int RESULT_OK = -1; 
	private static int RESULT_LOAD_IMAGE = 1;
	 private static final int SELECT_PICTURE = 1;
	private TextView tv_preview,tv_confirm,tvHeader,tvSignatureText;;
	private ImageView ivLogout;
	
	private String signature;
	//private  Bitmap bm;
	private Intent intent;
	 Uri contentUri;
	Bitmap signatureBitmap;
	
	 private SignaturePad mSignaturePad;
	 
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		signature=new String();
		setContentView(R.layout.activity_upload_signature);
		getId();
		tvHeader.setText("Upload Signature");
		setListener();
		
		RotateAnimation rotate= (RotateAnimation)AnimationUtils.loadAnimation(this,R.anim.rotateanimation);
		  tvSignatureText.setAnimation(rotate);
	}

	private void setListener() {
		
		tv_preview.setOnClickListener(this);
		tv_confirm.setOnClickListener(this);
		//iv_signature.setOnClickListener(this);
		ivLogout.setOnClickListener(this);
		
	}

	private void getId() {
		
		tv_preview = (TextView)findViewById(R.id.tv_preview);
		tv_confirm = (TextView)findViewById(R.id.tv_confirm);
	//	iv_signature = (ImageView)findViewById(R.id.iv_signature);
		tvHeader = (TextView)findViewById(R.id.tvHeader);
		ivLogout = (ImageView)findViewById(R.id.ivLogout);
		 mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
		 tvSignatureText=(TextView)findViewById(R.id.tv_signaturetext);
		
		 /*RotateAnimation rotate= (RotateAnimation)AnimationUtils.loadAnimation(this,R.anim.rotateanimation);
		  tvSignatureText.setAnimation(rotate);*/
		 
		 mSignaturePad.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
			
				tvSignatureText.clearAnimation();
				
				tvSignatureText.setVisibility(View.INVISIBLE);
			
				return false;
			}
		});
		 mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
	            @Override
	            public void onSigned() {
	                //mSaveButton.setEnabled(true);
	            	
	            	tv_preview.setEnabled(true);
	            	tv_confirm.setEnabled(true);
	            	//mClearButton.setEnabled(true);
	            }

	            @Override
	            public void onClear() {
	             	tv_preview.setEnabled(true);
	            	tv_confirm.setEnabled(false);
	            	
	            }
	        });
	}
	
	@Override
	public void onClick(View v) {
		
		
		switch(v.getId()){
	/*	case R.id.iv_signature:
			//Toast.makeText(this, "Work in progress.", Toast.LENGTH_SHORT).show();
			selectImage();
			break;*/
		case R.id.tv_confirm:
			//Toast.makeText(this, "Work in progress.", Toast.LENGTH_SHORT).show();
		//	saveSig();
			 
			Alert(this);
			break;
		case R.id.tv_preview:
			//Toast.makeText(this, "Work in progress.", Toast.LENGTH_SHORT).show();
		//	intent = new Intent(UploadSignatureActivity.this,PreviewSignatureActivity.class);
			//intent.putExtra("BitmapImage", signatureBitmap);
			/*if(bm==null)
				Toast.makeText(getApplicationContext(), "error here", Toast.LENGTH_LONG).show();*/
			if(mSignaturePad.isEmpty())
			{
				CommonUtils.ShowalertTitleCustomize("Please do signature here", this);
			}
			else
			{
			 signatureBitmap = mSignaturePad.getSignatureBitmap();
             if(addSignatureToGallery(signatureBitmap)) {
              //   Toast.makeText(UploadSignatureActivity.this, "Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
             } else {
                 Toast.makeText(UploadSignatureActivity.this, "Unable to store the signature", Toast.LENGTH_SHORT).show();
             }
		//	mSignaturePad.clear();
			startActivity(new Intent(UploadSignatureActivity.this,PreviewSignatureActivity.class).putExtra("uri", contentUri.toString()));
			//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	//		startActivity(intent);
			}
			break;
		case R.id.ivLogout:
			CommonUtils.AlertLogout(this);
			break;
		}
		
	}
	
	 public boolean addSignatureToGallery(Bitmap signature) {
	        boolean result = false;
	        try {
	            File photo = new File(getAlbumStorageDir("SignaturePad"),this.signature= String.format("Signature_%d.jpg", System.currentTimeMillis()));
	            saveBitmapToJPG(signature, photo);
	            Log.d("mess", this.signature);
	            Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
	             contentUri = Uri.fromFile(photo);
	            Log.d("mess", contentUri.toString());
	            mediaScanIntent.setData(contentUri);
	            UploadSignatureActivity.this.sendBroadcast(mediaScanIntent);
	            result = true;
	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 
	   public File getAlbumStorageDir(String albumName) {
	        // Get the directory for the user's public pictures directory.
	        File file = new File(Environment.getExternalStoragePublicDirectory(
	                Environment.DIRECTORY_PICTURES), albumName);
	        if (!file.mkdirs()) {
	            Log.e("SignaturePad", "Directory not created");
	        }
	        return file;
	    }

	    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
	        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
	        Canvas canvas = new Canvas(newBitmap);
	        canvas.drawColor(Color.WHITE);
	        canvas.drawBitmap(bitmap, 0, 0, null);
	        OutputStream stream = new FileOutputStream(photo);
	        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
	        stream.close();
	    }
	
	/*public void saveSig() {
        try {
          GestureOverlayView gestureView = (GestureOverlayView) findViewById(R.id.signaturePad);
          gestureView.setDrawingCacheEnabled(true);
           bm = Bitmap.createBitmap(gestureView.getDrawingCache());
          File f = new File(Environment.getExternalStorageDirectory()
                 + File.separator + "signature.png");
         f.createNewFile();
         FileOutputStream os = new FileOutputStream(f);
        os = new FileOutputStream(f);
         //compress to specified format (PNG), quality - which is ignored for PNG, and out stream
         bm.compress(Bitmap.CompressFormat.PNG, 100, os);
     os.close();
    } catch (Exception e) {
        Log.v("Gestures", e.getMessage());
         e.printStackTrace();
      }
   }
*/

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
	          //  iv_signature.setImageBitmap(photo);
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
			    Bitmap bt_image = BitmapFactory.decodeFile(picturePath);
			  //  iv_signature.setImageBitmap(bt_image);
			    }
			}
	  private void Alert(final Activity mActivity) {
		 	
			 	CheckBox cb_Send_sms;
			 	final TextView tv_ok;
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
				View dialoglayout = inflater.inflate(R.layout.dialog_alert, null);
				mDialog.setContentView(dialoglayout);
				mDialog.show();
				cb_Send_sms = (CheckBox)dialoglayout.findViewById(R.id.cb_Send_sms);
				tv_ok = (TextView)dialoglayout.findViewById(R.id.tv_ok);
				tv_ok.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						intent = new Intent(UploadSignatureActivity.this,LoginScreenActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						//startActivity(intent);
						mDialog.dismiss();
					}
				});
				mDialog.show();
				}
	    } 

