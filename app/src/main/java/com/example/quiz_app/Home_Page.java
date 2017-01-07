package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Home_Page extends Activity {

	ImageView img_technical,img_aptitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home__page);
		
		img_aptitude=(ImageView)findViewById(R.id.img_aptitude);
		img_technical=(ImageView)findViewById(R.id.img_technical);
		
		img_aptitude.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				
				Intent ob=new Intent(Home_Page.this,Apptitude_Qu_Page.class);
				startActivity(ob);
			}
		});
		
		img_technical.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent ob=new Intent(Home_Page.this,Programming_Quiz.class);
				startActivity(ob);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.programming__quiz, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) 
	{
		switch (item.getItemId()) 
    	{
		case R.id.about_us:
			Intent ob=new Intent(Home_Page.this,About_us.class);
			startActivity(ob);
			break;
		case R.id.instruction:
			Intent ob1=new Intent(Home_Page.this,Instruction.class);
			startActivity(ob1);
			break;
		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
