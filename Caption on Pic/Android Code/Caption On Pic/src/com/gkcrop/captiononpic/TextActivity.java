package com.gkcrop.captiononpic;

import yuku.ambilwarna.AmbilWarnaDialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TextActivity extends Activity {

	static String edit_text_str;
	static Typeface externalFont;
	static EditText text_edt;
	static int textcolor = 0xff000000;
	LinearLayout fint_style_lay;
	Button font_color_but;
	Button font_done_but;
	Gallery font_size_ga;
	Button font_style_but;
	Gallery font_style_ga;
	String fontstyle_drawable[]={"COOPBL.TTF","crystal radio kit.otf","Feed The Bears.ttf","murro.ttf",
			"Otaku Rant.ttf","SamysBookifiedTuffy.ttf","times.ttf","ZnikomitNo25.otf"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textsyles);
		text_edt = (EditText)findViewById(R.id.text_edt);
		font_style_but = (Button)findViewById(R.id.font_style_but);
		font_color_but = (Button)findViewById(R.id.font_color_but);
		font_done_but = (Button)findViewById(R.id.text_done_but);
		font_style_ga = (Gallery)findViewById(R.id.font_style_ga);
		font_style_ga.setAdapter(new FontStyleAdapter(TextActivity.this));


		font_style_ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				TextActivity.externalFont = Typeface.createFromAsset(getAssets(), fontstyle_drawable[arg2]);
				TextActivity.text_edt.setTypeface(TextActivity.externalFont);
			}
		});


		font_color_but.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				colorpicker();

			}
		});

			font_done_but.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				edit_text_str = text_edt.getText().toString();
				Intent intmain=new Intent(TextActivity.this,FirstActivity.class);
				startActivity(intmain);
					
					
				}
			});

	}


	public void colorpicker()
	{
		(new AmbilWarnaDialog(this, 0xff00ff00, new yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener() {



			public void onCancel(AmbilWarnaDialog ambilwarnadialog)
			{
			}

			public void onOk(AmbilWarnaDialog ambilwarnadialog, int i)
			{
				TextActivity.textcolor = i;
				TextActivity.text_edt.setTextColor(i);
			}



		})).show();
	}

	public class FontStyleAdapter extends BaseAdapter
	{

		Context ctx;

		public FontStyleAdapter(TextActivity text) {
			// TODO Auto-generated constructor stub
			this.ctx=text;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fontstyle_drawable.length;
		}

		@Override
		public Object getItem(int arg0) {
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
			TextView text=new TextView(ctx);
			text.setText("Font");
			String fontPath = fontstyle_drawable[position];
			text.setTextSize(20f);
			text.setPadding(5, 5, 5, 5);
			text.setBackgroundColor(Color.WHITE);
			Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
			text.setTypeface(tf);
			return text;
		}

	}

}
