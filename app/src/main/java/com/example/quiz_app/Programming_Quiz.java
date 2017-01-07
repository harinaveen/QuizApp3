package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Programming_Quiz extends Activity implements OnClickListener{

	Button b_c,b_cplspls,b_java,b_php,b_android;
	Button b_apptitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_programming__quiz);
		
	//	b_apptitude=(Button)findViewById(R.id.b_apptitude);
     //   b_apptitude.setOnClickListener(this);
        
        
        b_c=(Button)findViewById(R.id.b_c);
        b_cplspls=(Button)findViewById(R.id.b_cplspls);
        b_java=(Button)findViewById(R.id.b_java);
        b_php=(Button)findViewById(R.id.b_php);
        b_android=(Button)findViewById(R.id.b_android);
        
        b_c.setOnClickListener(this);
        b_cplspls.setOnClickListener(this);
        b_java.setOnClickListener(this);
        b_php.setOnClickListener(this);
        b_android.setOnClickListener(this);
		
		
		
	}		// close oncreate

	@Override
	public void onClick(View v) 
	{
		switch (v.getId()) 
		{
		case R.id.b_c:
			Intent ob=new Intent(Programming_Quiz.this,C_Qu_Page.class);
			startActivity(ob);
			break;
		case R.id.b_java:
			Intent ob1=new Intent(Programming_Quiz.this,Java_Qu_Page.class);
			startActivity(ob1);
			break;
		case R.id.b_cplspls:
			Intent ob2=new Intent(Programming_Quiz.this,Cplspls_Qu_page.class);
			startActivity(ob2);
			break;
		case R.id.b_php:
			Intent ob3=new Intent(Programming_Quiz.this,Php_Qu_Page.class);
			startActivity(ob3);
			break;
		case R.id.b_android:
			Intent ob4=new Intent(Programming_Quiz.this,Android_Qu_Page.class);
			startActivity(ob4);
			break;
		
		default:
			break;
		}
		
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
			Intent ob=new Intent(Programming_Quiz.this,About_us.class);
			startActivity(ob);
			break;
		case R.id.instruction:
			Intent ob1=new Intent(Programming_Quiz.this,Instruction.class);
			startActivity(ob1);
			break;
		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
}		// close main
