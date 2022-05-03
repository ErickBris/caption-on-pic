package com.gkcrop.captiononpic;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity
{

	TextView txt_appname;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		txt_appname=(TextView)findViewById(R.id.txt_appname);
	
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setInterpolator(new AccelerateInterpolator()); //add this
		fadeIn.setDuration(500);
		Typeface font = Typeface.createFromAsset(getAssets(), "molten.ttf");
		txt_appname.setTypeface(font);
		Thread splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (waited < 2000) {
						sleep(100);
						waited += 100;
					}
				} catch (InterruptedException e) {
					// do nothing
				} finally {

					Intent i = new Intent(getApplicationContext(),LaunchActivity.class);
					startActivity(i);
					finish();

				}
			}
		};
		splashThread.start();
	}

}
