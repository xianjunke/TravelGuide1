package com.example.travelguide;



import android.app.Activity;
import android.os.Bundle;

public class WolfShootingActivity extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//设置界面
        new Listener(this);//核心类对象
    }
}