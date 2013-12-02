package com.example.travelguide;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    Button b=(Button)findViewById(R.id.btnBamboo);
	    b.setOnClickListener(new OnClickListener(){
	    	
	    
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this,City.class));
				
			}
	    });
	
	
	Button c=(Button)findViewById(R.id.button6);
    c.setOnClickListener(new OnClickListener(){
    	
    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this,Music.class));
			
		}
    });
	Button d=(Button)findViewById(R.id.button3);
    d.setOnClickListener(new OnClickListener(){
    	
    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this,Food.class));
			
		}
    });
	Button e=(Button)findViewById(R.id.button2);
    e.setOnClickListener(new OnClickListener(){
    	
    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.booking.com/")));
			
		}
    });

	Button f=(Button)findViewById(R.id.button4);
    f.setOnClickListener(new OnClickListener(){
    	
    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://www.google.com/maps/preview")));
			
		}
    });
	Button g=(Button)findViewById(R.id.button5);
    g.setOnClickListener(new OnClickListener(){
    	
    
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(MainActivity.this,WolfShootingActivity.class));
		}
    });
	}

	
        
}
