package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Instruction extends Activity {
	
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instruction);
		
		tv=(TextView)findViewById(R.id.tv_instru);
		
		String aaa="1.\tTechnical Quiz have nu. of Topics. " +
				"Each topic Contains 10 Questions.\n\n" +
				"2. \tIn Aptitude Test section, there  are 30 nu. of questions.\n\n" +
				"3.\tYou can check your answer after select an option.\n\n" +
				"4.\tAfter Click the 'check answer' button you will not able to select " +
				"any different option on that particular question.\n\n" +
				"6.\tNow go back Home page to Start.";

		tv.setText(""+aaa);
		
	}
	
	
	

}
