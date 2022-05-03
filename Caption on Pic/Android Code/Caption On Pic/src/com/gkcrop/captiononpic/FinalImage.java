package com.gkcrop.captiononpic;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FinalImage extends Activity {
	
	private String tempimagepath;
	Button btn_save,btn_share;
	 ImageView finalimag;
	 private AdView mAdView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finalimage);
		btn_save=(Button)findViewById(R.id.save_but);
		btn_share=(Button)findViewById(R.id.share_but);
		finalimag=(ImageView)findViewById(R.id.final_img);
        finalimag.setImageBitmap(FirstActivity.cpture_bmp);
        
        mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());
		
		btn_share.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File file = new File(saveImageFoShare(getString(R.string.app_name), 100, FirstActivity.cpture_bmp));
				boolean flag = file.exists();
				Uri uri = null;
				if (flag)
				{
					uri = Uri.fromFile(file);
				}
				Intent share = new Intent(Intent.ACTION_SEND);
				share.setType("image/jpg");
				share.putExtra(Intent.EXTRA_STREAM, uri);
				startActivity(Intent.createChooser(share, "Share Image"));
				
			}
		});
		
		btn_save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				File file = new File(saveImageFoShare(getString(R.string.app_name), 100, FirstActivity.cpture_bmp));
				boolean flag = file.exists();
				if(flag)
				{
					Toast.makeText(FinalImage.this, "Save", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
	
	
	 private String saveImageFoShare(String s, int i, Bitmap bitmap)
	    {
	        String s1;
	        s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append(s).append(File.separator).toString();
	        (new File(s1)).mkdirs();
	        File file;
	        boolean flag;
	        (new android.graphics.BitmapFactory.Options()).inSampleSize = 5;
	        String s2 = UUID.randomUUID().toString();
	        tempimagepath = (new StringBuilder(String.valueOf(s1))).append(s2).append(".jpg").toString();
	        file = new File(tempimagepath);
	        flag = file.exists();
	        String as[] = null;
	        try
	        {
	        	 if (flag)  
	 	        {
	 	        	file.delete();
	 		        file.createNewFile();
	 	        }
	 	        else
	 	        {
	 	        	 file.createNewFile();
	 	        }
	        	 
	        	FileOutputStream fileoutputstream = new FileOutputStream(file);
	 	        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(fileoutputstream);
	            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, bufferedoutputstream);
	            bufferedoutputstream.flush();
	            bufferedoutputstream.close();
		        as = new String[1];
		        as[0] = file.toString();
	        }
	        catch (NullPointerException nullpointerexception) { }
	        
	        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        MediaScannerConnection.scanFile(this, as, null, new android.media.MediaScannerConnection.OnScanCompletedListener() {
	            public void onScanCompleted(String s1, Uri uri)
	            {
	            }
	             
	        });
	        return tempimagepath;
	    }

}
