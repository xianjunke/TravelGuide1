package com.example.travelguide;



import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Music extends Activity {


	Button btBamboo,btPalace,btZ,btL;
	MediaPlayer mpBamboo,mpPalace,mpL,mpZ;
	int playing;


	@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.music);
			btBamboo =(Button)findViewById(R.id.btnBamboo);
			btPalace =(Button)findViewById(R.id.btnPalace);
			btZ=(Button)findViewById(R.id.btnZ);
			btL=(Button)findViewById(R.id.btnL);
            btBamboo.setOnClickListener(bBamboo);
            btPalace.setOnClickListener(bPalace);
            btZ.setOnClickListener(bZ);
            btL.setOnClickListener(bL);
            mpBamboo = new MediaPlayer();
			mpBamboo = MediaPlayer.create(this,R.raw.bamboo);
			mpPalace= new MediaPlayer();
			mpPalace = MediaPlayer.create(this,R.raw.palace);
            mpZ = new MediaPlayer();
			mpZ = MediaPlayer.create(this,R.raw.dachengxiaoshi);
            mpL = new MediaPlayer();
			mpL = MediaPlayer.create(this,R.raw.xiexie);
			playing=0;
			
		}
	    Button.OnClickListener bBamboo =new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(playing){
				case 0:
				mpBamboo.start();
				playing =1;
				btBamboo.setText("�����");
				btPalace.setVisibility(View.VISIBLE);
				break;
				case 1:
			      mpBamboo.pause();
			      playing=0;
			      btBamboo.setText("��ͣ�");
			      btPalace.setVisibility(View.VISIBLE);
			      break;
				}
			}
	    	
	    };
		
	    Button.OnClickListener bPalace =new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(playing){
				case 0:
				mpPalace.start();
				playing =1;
				btPalace.setText("��ͣħ���е���ʹ");
				btBamboo.setVisibility(View.VISIBLE);
				playing=1;
				break;
				case 1:
			      mpPalace.pause();
			      btPalace.setText("���� ħ���е���ʹ");
			      btBamboo.setVisibility(View.VISIBLE);
			      playing=0;
			      break;
				
			}
	    	
	    };

	};
	
	  Button.OnClickListener bZ =new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(playing){
				case 0:
				mpZ.start();
				playing =1;
				btZ.setText("���Ŵ��С��");
				btL.setVisibility(View.VISIBLE);
				break;
				case 1:
			      mpZ.pause();
			      playing=0;
			      btZ.setText("��ͣ���С��");
			      btL.setVisibility(View.VISIBLE);
			      break;
				}
			}
	    	
	    };
		
	    Button.OnClickListener bL =new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch(playing){
				case 0:
				mpL.start();
				playing =1;
				btL.setText("����лл��İ�");
				btZ.setVisibility(View.VISIBLE);
				playing=1;
				break;
				case 1:
			      mpL.pause();
			      btL.setText("��ͤлл��İ�");
			      btZ.setVisibility(View.VISIBLE);
			      playing=0;
			      break;
				
			}
	    	
	    };

	};
	}
