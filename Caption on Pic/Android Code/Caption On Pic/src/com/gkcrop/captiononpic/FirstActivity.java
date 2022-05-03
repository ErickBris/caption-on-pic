package com.gkcrop.captiononpic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FirstActivity extends Activity implements OnClickListener {


	static Bitmap cpture_bmp = null;
	static Bitmap currentbitmap = null;
	static String str;
	private int CAMERA_PIC_REQUEST;
	public float Orientation;
	private int RESULT_LOAD_IMAGE;
	Bitmap bitmap;

	LinearLayout captiongallery_lay;
	RelativeLayout capture;
	Button cation_but;
	Gallery cation_ga;
	RelativeLayout child;
	int curreneffect;
	int currentframe;
	int currentthem;
	TextView dialogtext_tv;
	EditText dialogtext_tv2;
	Display display;
	Button done_but;
	Bitmap drawbitmap;
	EditText editext_edt;
	Button fonntsize_but;
	Button fontstyle_but;
	FrameLayout fram1;
	FrameLayout frame120;
	Button frame_but;
	Gallery frame_ga;
	Gallery sticker_ga;
	Bitmap framebmp;
	LinearLayout framegallery_lay;
	FrameLayout frametextnew2;
	int height;
	ImageView image;
	Button image_but;
	LinearLayout imagegaller_lay;
	int imageheight;
	int imagwidth;
	RelativeLayout layout;
	FrameLayout mainframe;
	float maxResolution;
	Bitmap original;
	Bitmap output;
	RelativeLayout parent;
	String picturePath;
	ImageView sticker_img[];
	ImageView stickerimg;
	Button stickers_but;
	Gallery stickersgallery_ga;
	LinearLayout stickersgallery_lay;
	TextView textView1;
	Button text_but;
	FrameLayout textframe;
	FrameLayout textframe1;
	FrameLayout textframe2;
	LinearLayout textgallery_lay;
	int textvalue;
	Gallery theams_ga;
	View v1;
	View vk;
	int width;
	private Uri fileUri;
	
	Integer thems_drawable[]={R.drawable.gallery_but,R.drawable.camera_but,R.drawable.themes1,R.drawable.themes2,R.drawable.themes3,R.drawable.themes4,R.drawable.themes5,R.drawable.themes6,R.drawable.themes7,R.drawable.themes8,R.drawable.themes9,R.drawable.themes10,R.drawable.themes11,R.drawable.themes12,R.drawable.themes13,R.drawable.themes14,R.drawable.themes15,R.drawable.themes16,R.drawable.themes17,R.drawable.themes18,R.drawable.themes19,R.drawable.themes20,R.drawable.themes21,R.drawable.themes22,R.drawable.themes23,R.drawable.themes24};
	Integer theams_big[]={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.theam_big1,R.drawable.theam_big2,R.drawable.theam_big3,R.drawable.theam_big4,R.drawable.theam_big5,R.drawable.theam_big6,R.drawable.theam_big7,R.drawable.theam_big8,R.drawable.theam_big9,R.drawable.theam_big10,R.drawable.theam_big11,R.drawable.theam_big12,R.drawable.theam_big13,R.drawable.theam_big14,R.drawable.theam_big15,R.drawable.theam_big16,R.drawable.theam_big17,R.drawable.theam_big18,R.drawable.theam_big19,R.drawable.theam_big20,R.drawable.theam_big21,R.drawable.theam_big22,R.drawable.theam_big23,R.drawable.theam_big24};
	Integer stickers_drawable[]={R.drawable.sticker_low1,R.drawable.sticker_low2,R.drawable.sticker_low3,R.drawable.sticker_low4,R.drawable.sticker_low5,R.drawable.sticker_low6,R.drawable.sticker_low7,R.drawable.sticker_low8,R.drawable.sticker_low9,R.drawable.sticker_low10,R.drawable.sticker_low11,R.drawable.sticker_low12,R.drawable.sticker_low13,R.drawable.sticker_low14,R.drawable.sticker_low15,R.drawable.sticker_low16,R.drawable.sticker_low17,R.drawable.sticker_low18,R.drawable.sticker_low19,R.drawable.sticker_low20,R.drawable.sticker_low21,R.drawable.sticker_low22,R.drawable.sticker_low23,R.drawable.sticker_low24,R.drawable.sticker_low25,R.drawable.sticker_low26};
	Integer stickers_big[]={R.drawable.stck1,R.drawable.stck2,R.drawable.stck3,R.drawable.stck4,R.drawable.stck5,R.drawable.stck6,R.drawable.stck7,R.drawable.stck8,R.drawable.stck9,R.drawable.stck10,R.drawable.stck11,R.drawable.stck12,R.drawable.stck13,R.drawable.stck14,R.drawable.stck15,R.drawable.stck16,R.drawable.stck17,R.drawable.stck18,R.drawable.stck19,R.drawable.stck20,R.drawable.stck21,R.drawable.stck22,R.drawable.stck23,R.drawable.stck24,R.drawable.stck25,R.drawable.stck26};
	Integer frames_drawable[]={R.drawable.frame1,R.drawable.frame2,R.drawable.frame3,R.drawable.frame4,R.drawable.frame5,R.drawable.frame6,R.drawable.frame7,R.drawable.frame8,R.drawable.frame9,R.drawable.frame10,R.drawable.frame11,R.drawable.frame12,R.drawable.frame13,R.drawable.frame14,R.drawable.frame15,R.drawable.frame16,R.drawable.frame17,R.drawable.frame18,R.drawable.frame19,R.drawable.frame20,R.drawable.frame21,R.drawable.frame22};
	Integer frame_big[]={R.drawable.frame_big1,R.drawable.frame_big2,R.drawable.frame_big3,R.drawable.frame_big4,R.drawable.frame_big5,R.drawable.frame_big6,R.drawable.frame_big7,R.drawable.frame_big8,R.drawable.frame_big9,R.drawable.frame_big10,R.drawable.frame_big11,R.drawable.frame_big12,R.drawable.frame_big13,R.drawable.frame_big14,R.drawable.frame_big15,R.drawable.frame_big16,R.drawable.frame_117,R.drawable.frame_118,R.drawable.frame_119,R.drawable.frame_120,R.drawable.frame_121,R.drawable.frame_122};
	Integer caption_drawable[]={R.drawable.caption_low1,R.drawable.caption_low2,R.drawable.caption_low3,R.drawable.caption_low4,R.drawable.caption_low5,R.drawable.caption_low6,R.drawable.caption_low7,R.drawable.caption_low8,R.drawable.caption_low9,R.drawable.caption_low10,R.drawable.caption_low11,R.drawable.caption_low12,R.drawable.caption_low13,R.drawable.caption_low14,R.drawable.caption_low15,R.drawable.caption_low16,R.drawable.caption_low17,R.drawable.caption_low18,R.drawable.caption_low19,R.drawable.caption_low20};
	Integer caption_big[]={R.drawable.caption_big1,R.drawable.caption_big2,R.drawable.caption_big3,R.drawable.caption_big4,R.drawable.caption_big5,R.drawable.caption_big6,R.drawable.caption_big7,R.drawable.caption_big8,R.drawable.caption_big9,R.drawable.caption_big10,R.drawable.caption_big11,R.drawable.caption_big12,R.drawable.caption_big13,R.drawable.caption_big14,R.drawable.caption_big15,R.drawable.caption_big16,R.drawable.caption_big17,R.drawable.caption_big18,R.drawable.caption_big19,R.drawable.caption_big20};
	
	public static final int MEDIA_TYPE_IMAGE = 1;
	private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstactivity);

		display = getWindowManager().getDefaultDisplay();
		height = display.getHeight();
		width = display.getWidth();
		parent = (RelativeLayout)findViewById(R.id.parent_rel);
		child = (RelativeLayout)findViewById(R.id.mainlay_rel);
		capture = (RelativeLayout)findViewById(R.id.capture);
		framebmp = BitmapFactory.decodeResource(getResources(), R.drawable.frame_big1);
		frame120 = (FrameLayout)findViewById(R.id.frame120);
		layout = (RelativeLayout)findViewById(R.id.relativeLayout1);
		layout.setVisibility(8);
		layout.setBackgroundResource(R.drawable.caption_big6);
		textView1 = (TextView)findViewById(R.id.textView1);
		textView1.setText(TextActivity.edit_text_str);
		textView1.setTextSize(28F);
		textView1.setTextColor(TextActivity.textcolor);
		textView1.setTypeface(TextActivity.externalFont);
		textView1.setGravity(17);
		imagegaller_lay = (LinearLayout)findViewById(R.id.imagegallery_lay);
		framegallery_lay = (LinearLayout)findViewById(R.id.framegallery_lay);
		framegallery_lay.setVisibility(8);
		captiongallery_lay = (LinearLayout)findViewById(R.id.captiongallery_lay);
		captiongallery_lay.setVisibility(8);
		stickersgallery_lay = (LinearLayout)findViewById(R.id.stickersgallery_lay);
		stickersgallery_lay.setVisibility(8);
		image = (ImageView)findViewById(R.id.imageView1);
		currentbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.theam_big13);
		image.setImageBitmap(currentbitmap);
		image_but = (Button)findViewById(R.id.image_but);
		image_but.setOnClickListener(this);
		cation_but = (Button)findViewById(R.id.cation_but);
		cation_but.setOnClickListener(this);
		stickers_but = (Button)findViewById(R.id.stikers_but);
		stickers_but.setOnClickListener(this);
		frame_but = (Button)findViewById(R.id.frames_but);
		frame_but.setOnClickListener(this);
		done_but = (Button)findViewById(R.id.done_but);
		done_but.setOnClickListener(this);
		layout.measure(android.view.View.MeasureSpec.makeMeasureSpec(layout.getLayoutParams().width, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(layout.getLayoutParams().height, 0x40000000));
		layout.layout(0, 0, layout.getMeasuredWidth(), layout.getMeasuredHeight());
		layout.setDrawingCacheEnabled(true);
		bitmap = Bitmap.createBitmap(layout.getDrawingCache());
		layout.setDrawingCacheEnabled(true);
		layout.setDrawingCacheEnabled(true);
		vk = new SandboxView(getApplicationContext(), bitmap);
		frame120 = (FrameLayout)findViewById(R.id.frame120);
		frame120.addView(vk);
		theams_ga = (Gallery)findViewById(R.id.image_gallery);
		cation_ga = (Gallery)findViewById(R.id.cation_ga);
		frame_ga = (Gallery)findViewById(R.id.frame_ga);
		sticker_ga = (Gallery)findViewById(R.id.sticker_ga);


		theams_ga.setAdapter(new ImageGalleryAdapter(this));
		cation_ga.setAdapter(new captionAdapter(this));
		frame_ga.setAdapter(new FrameGalleryAdapter(this));
		sticker_ga.setAdapter(new stickersAdapter(this));


		theams_ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				currentthem = arg2;
				if(arg2==0)
				{
					image.setVisibility(8);
					Intent intent1 = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
					intent1.setType("image/*");
					startActivityForResult(Intent.createChooser(intent1, "Select Picture"), RESULT_LOAD_IMAGE);

				}
				if(arg2==1)
				{
					image.setVisibility(8);
					Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
					intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
					// start the image capture Intent
					startActivityForResult(intent, CAMERA_PIC_REQUEST);

				}
				else
				{
					FirstActivity.currentbitmap = BitmapFactory.decodeResource(getResources(), theams_big[currentthem].intValue());
					image.setImageBitmap(FirstActivity.currentbitmap);
				}

			}
		});

		cation_ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				frame120.removeAllViews();
				layout.setBackgroundResource(caption_big[arg2]);
				layout.setDrawingCacheEnabled(true);
				layout.buildDrawingCache(true);
				bitmap = Bitmap.createBitmap(layout.getDrawingCache());
				layout.setDrawingCacheEnabled(false);
				vk = new SandboxView(getApplicationContext(), bitmap);
				frame120 = (FrameLayout)findViewById(R.id.frame120);
				frame120.addView(vk);
			}
		});


		frame_ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int i,
					long arg3) {
				// TODO Auto-generated method stub
				if (FirstActivity.currentbitmap == null)
				{
					Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), frame_big[i].intValue());
					image.setImageBitmap(bitmap3);
					return;
				} else
				{
					Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), frame_big[i].intValue());
					Bitmap bitmap2 = overlayEffect(FirstActivity.currentbitmap, bitmap1);
					image.setImageBitmap(bitmap2);
					return;
				}
			}
		});

		mainframe = (FrameLayout)findViewById(R.id.mainframe);
		stickerimg = (ImageView)findViewById(R.id.imageView27);
		stickerimg.setScaleType(android.widget.ImageView.ScaleType.MATRIX);

		sticker_ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), stickers_big[arg2]);
				SandboxView sandboxview = new SandboxView(getApplicationContext(), bitmap1);
				mainframe.addView(sandboxview);
			}
		});


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.image_but:
			framegallery_lay.setVisibility(8);
			imagegaller_lay.setVisibility(0);
			stickersgallery_lay.setVisibility(8);
			captiongallery_lay.setVisibility(8);
			return;

		case R.id.frames_but:
			framegallery_lay.setVisibility(0);
			imagegaller_lay.setVisibility(8);
			stickersgallery_lay.setVisibility(8);
			captiongallery_lay.setVisibility(8);
			return;

		case R.id.stikers_but:
			stickersgallery_lay.setVisibility(0);
			imagegaller_lay.setVisibility(8);
			framegallery_lay.setVisibility(8);
			captiongallery_lay.setVisibility(8);
			return;

		case R.id.cation_but:
			captiongallery_lay.setVisibility(0);
			stickersgallery_lay.setVisibility(8);
			imagegaller_lay.setVisibility(8);
			framegallery_lay.setVisibility(8);
			return;
		case R.id.done_but:
			 if (v1 != null)
		        {
		            v1.destroyDrawingCache();
		        }
		        if (cpture_bmp != null && !cpture_bmp.isRecycled())
		        {
		            cpture_bmp.recycle();
		            cpture_bmp = null;
		            System.gc();
		        }
		        v1 = parent.findViewById(R.id.mainlay_rel);
		        v1.setDrawingCacheEnabled(true);
		        cpture_bmp = v1.getDrawingCache();
		        startActivity(new Intent(this, FinalImage.class));
			return;
		default:
			break;
		}

	}

	class FrameGalleryAdapter extends BaseAdapter
	{
		Context ctx;

		public FrameGalleryAdapter(FirstActivity act) {
			// TODO Auto-generated constructor stub
			this.ctx=act;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return frames_drawable.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview = new ImageView(ctx);
			imageview.setImageResource(frames_drawable[position].intValue());
			imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
			// imageview.setBackgroundResource(imageBackground);
			return imageview;
		}

	}



	class ImageGalleryAdapter extends BaseAdapter
	{
		Context ctx;

		public ImageGalleryAdapter(FirstActivity act) {
			// TODO Auto-generated constructor stub
			this.ctx=act;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return thems_drawable.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview = new ImageView(ctx);
			imageview.setImageResource(thems_drawable[position].intValue());
			imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
			// imageview.setBackgroundResource(imageBackground);
			return imageview;
		}

	}


	class captionAdapter extends BaseAdapter
	{
		Context ctx;

		public captionAdapter(FirstActivity act) {
			// TODO Auto-generated constructor stub
			this.ctx=act;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return caption_drawable.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview = new ImageView(ctx);
			imageview.setImageResource(caption_drawable[position].intValue());
			imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
			// imageview.setBackgroundResource(imageBackground);
			return imageview;
		}

	}


	class stickersAdapter extends BaseAdapter
	{
		Context ctx;

		public stickersAdapter(FirstActivity act) {
			// TODO Auto-generated constructor stub
			this.ctx=act;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return stickers_drawable.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview = new ImageView(ctx);
			imageview.setImageResource(stickers_drawable[position].intValue());
			imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
			// imageview.setBackgroundResource(imageBackground);
			return imageview;
		}

	}

	protected Bitmap overlayEffect(Bitmap bitmap1, Bitmap bitmap2)
	{
		Bitmap bitmap3 = Bitmap.createBitmap(bitmap1.getWidth(), bitmap1.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas();
		canvas.setBitmap(bitmap3);
		canvas.drawBitmap(bitmap1, 0.0F, 0.0F, null);
		canvas.drawBitmap(bitmap2, 0.0F, 0.0F, null);
		return bitmap3;
	}

	private float getImageOrientation(String s)
	{
		int i;
		float f;
		try
		{
			i = (new ExifInterface(s)).getAttributeInt("Orientation", 1);
		}
		catch (IOException ioexception)
		{
			ioexception.printStackTrace();
			return 0.0F;
		}
		if (i == 6)
		{
			f = 90F;
		} else
		{
			if (i == 3)
			{
				return 180F;
			}
			f = 0.0F;
			if (i == 8)
			{
				return 270F;
			}
		}
		return f;
	}


	public static Bitmap getResizedBitmap(Bitmap bitmap1, int i, int j)
	{
		android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		bitmap1.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
		byte abyte0[] = bytearrayoutputstream.toByteArray();
		BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0), null, options);
		int k = bitmap1.getWidth();
		int l = bitmap1.getHeight();
		int i1 = 1;
		do
		{
			if (k / 2 <= i)
			{
				float f = (float)i / (float)k;
				float f1 = (float)j / (float)l;
				options.inJustDecodeBounds = false;
				options.inDither = false;
				options.inSampleSize = i1;
				options.inScaled = false;
				options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
				Bitmap bitmap2 = BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0), null, options);
				Matrix matrix = new Matrix();
				matrix.postScale(f, f1);
				matrix.postRotate(0.0F);
				return Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
			}
			k /= 2;
			l /= 2;
			i1 *= 2;
		} while (true);
	}

	private Bitmap getResizedOriginalBitmap(int i, int j)
	{
		android.graphics.BitmapFactory.Options options;
		int k;
		int l;
		int i1;
		float f;
		float f1;
		Bitmap bitmap1;
		Matrix matrix;
		try
		{
			options = new android.graphics.BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(picturePath), null, options);
			k = options.outWidth;
			l = options.outHeight;
		}
		catch (FileNotFoundException filenotfoundexception)
		{
			return null;
		}
		i1 = 1;
		do
		{
			if (k / 2 <= i)
			{
				f = (float)i / (float)k;
				f1 = (float)j / (float)l;
				options.inJustDecodeBounds = false;
				options.inDither = false;
				options.inSampleSize = i1;
				options.inScaled = false;
				options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
				try {
					bitmap1 = BitmapFactory.decodeStream(new FileInputStream(picturePath), null, options);
					matrix = new Matrix();
					matrix.postScale(f, f1);
					matrix.postRotate(Orientation);
					original = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), bitmap1.getHeight(), matrix, true);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return original;
			}
			k /= 2;
			l /= 2;
			i1 *= 2;
		}while(true);

	}

	public String getPath(Uri uri)
	{
		Cursor cursor = managedQuery(uri, new String[] {
				"_data"
		}, null, null, null);
		int i = cursor.getColumnIndexOrThrow("_data");
		cursor.moveToFirst();
		return cursor.getString(i);
	}

	private int getFileSize(Uri uri)
	{
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
		int i = cursor.getColumnIndex("_size");
		cursor.close();
		return i;
	}

	@Override
	protected void onActivityResult(int i, int j, Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(i, j, intent);

		if (i == CAMERA_PIC_REQUEST)
		{
			if(j==RESULT_OK)

				if (fileUri != null) 
				{
					picturePath = fileUri.getPath();
					Orientation = getImageOrientation(picturePath);
					currentbitmap = getResizedOriginalBitmap(framebmp.getWidth(), framebmp.getHeight());
					image.setVisibility(0);
					image.setImageBitmap(currentbitmap);
				}
		}
		  if(i == RESULT_LOAD_IMAGE && j == RESULT_OK && null != intent)
		{

			Uri uri = intent.getData();
			if (uri == null)
			{
				return;
			}
			else
			{
				picturePath = getPath(uri);
				Orientation = getImageOrientation(picturePath);
				currentbitmap = getResizedOriginalBitmap(framebmp.getWidth(), framebmp.getHeight());
				image.setVisibility(0);
				image.setImageBitmap(currentbitmap);
			}
		}

	}
	private static File getOutputMediaFile(int type) {

		// External sdcard location
		File mediaStorageDir = new File(
				Environment
				.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				IMAGE_DIRECTORY_NAME);

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
						+ IMAGE_DIRECTORY_NAME + " directory");
				return null;
			}
		}

		// Create a media file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
				Locale.getDefault()).format(new Date());
		File mediaFile;
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
		}   else {
			return null;
		}

		return mediaFile;
	}

	public Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}
}
