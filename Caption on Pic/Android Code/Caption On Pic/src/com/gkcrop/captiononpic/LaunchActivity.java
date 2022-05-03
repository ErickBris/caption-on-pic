package com.gkcrop.captiononpic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class LaunchActivity extends Activity {

	Button start,btnmore,btnfree;
	private AdView mAdView;
	private InterstitialAd mInterstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		start=(Button)findViewById(R.id.start);
		btnmore=(Button)findViewById(R.id.btnMore);
		btnfree=(Button)findViewById(R.id.btnFree);

		mAdView = (AdView) findViewById(R.id.adViewad);
		mAdView.loadAd(new AdRequest.Builder().build());

		mInterstitial = new InterstitialAd(LaunchActivity.this);
		mInterstitial.setAdUnitId(getResources().getString(R.string.admob_intertestial_id));
		mInterstitial.loadAd(new AdRequest.Builder().build());

		mInterstitial.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				// TODO Auto-generated method stub
				super.onAdLoaded();
				if (mInterstitial.isLoaded()) {
					mInterstitial.show();
				}
			}
		});

		start.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent launch=new Intent(LaunchActivity.this,TextActivity.class);
				startActivity(launch);
			}
		});

		btnmore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse(getString(R.string.play_more_apps))));
			}
		});

		btnfree.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String appName = getPackageName();//your application package name i.e play store application url
				try {
					startActivity(new Intent(Intent.ACTION_VIEW,
							Uri.parse("market://details?id="
									+ appName)));
				} catch (android.content.ActivityNotFoundException anfe) {
					startActivity(new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://play.google.com/store/apps/details?id="
									+ appName)));
				}
			}

		});


	}

}
