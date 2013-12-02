package com.example.travelguide;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Food extends TabActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food);
		TabHost tabHost= getTabHost();
		//first tab
		TabSpec photospec =tabHost.newTabSpec("Food");
		photospec.setIndicator("Photos",getResources().getDrawable(R.drawable.tab1));
		Intent photosIntent = new Intent(this,Tab1.class);
		photospec.setContent(photosIntent);
		//Tab2
		TabSpec tourspec =tabHost.newTabSpec("Tour");
		tourspec.setIndicator("Tour",getResources().getDrawable(R.drawable.tab2));
		Intent tourIntent = new Intent(this,Tab2.class);
		tourspec.setContent(tourIntent);
		//tab3
		TabSpec webspec =tabHost.newTabSpec("Web Site");
		webspec.setIndicator("Web site",getResources().getDrawable(R.drawable.tab3));
		Intent webIntent = new Intent(this,Tab3.class);
		webspec.setContent(webIntent);
		//add tabspace to TabHost
		tabHost.addTab(photospec);
		tabHost.addTab(tourspec);
		tabHost.addTab(webspec);
		
	}

}


