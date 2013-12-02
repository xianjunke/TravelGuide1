package com.example.travelguide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Tab1 extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tab1);
	GridView g =(GridView)findViewById(R.id.photos);
	g.setAdapter(new ImageAdapter(this));
}
  public class ImageAdapter extends BaseAdapter{
    private Context context;
    private Integer[] Bikes={R.drawable.bike1, R.drawable.bike2, R.drawable.bike3, 
    		R.drawable.bike4,R.drawable.bike5,R.drawable.bike6};
    
	public ImageAdapter(Context c) {
		// TODO Auto-generated constructor stub
		context = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Bikes.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ImageView pic = new ImageView(context);
		pic.setLayoutParams(new GridView.LayoutParams(275,250));
		pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
		pic.setPadding(8,8,8,8);
		pic.setImageResource(Bikes[arg0]);
		return pic;
	}
	  
  }
}
