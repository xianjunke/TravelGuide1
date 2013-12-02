package com.example.travelguide;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class City extends ListActivity {
	
	public void onCreate(Bundle savedInstancesState){
		super.onCreate(savedInstancesState);
		String[] attraction={"Miami","Los Angels","New York",
				"Washionton DC","Vegas","Orlando"};
		 setListAdapter(new ArrayAdapter<String>(this,
	               R.layout.city, R.id.travel, attraction));
		}
		protected void onListItemClick(ListView l, View v, int position, long id) {
		 switch(position){
	
		 case 0:
			 startActivity(new Intent(City.this, Miami.class));
			break;
		 case 1:
			startActivity(new Intent(City.this, La.class));
			break;
		 case 2:
			 startActivity(new Intent(City.this, Newyork.class));
			 break;
		 case 3:
			 startActivity(new Intent(City.this, Dc.class));
			break;
		 case 4:
			 startActivity(new Intent(City.this, Vegas.class));
			break;
		 case 5:
			 startActivity(new Intent(City.this, Orlando.class));
			break;
		 }
		}

}
