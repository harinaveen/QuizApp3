package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class About_us extends Activity {
	
	TextView tv_clg,tv_about;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		
		//tv_branch=(TextView)findViewById(R.id.tv_branch);
		tv_clg=(TextView)findViewById(R.id.tv_college);
		tv_about=(TextView)findViewById(R.id.tv_about);
		
		String a="Kruti Institute of Tech. & Engg. Raipur(C.G.)";
	//	String b="Computer Science & Engineering";
		
	//	tv_branch.setText(""+b);
		
		tv_clg.setText(""+a);
		
		/*
		String c="\t Programming Quiz is one of the best app to test your programming Skill.\n " +
				"\t It checks your skill and gives you the performance result by asking nu. of " +
				" questions based on the different languages.\n" +
				" * It is My First Android Application. So Enjoy the App & give your feedback." +
				"So that i can improve more and more.";
		*/
		String d="\t Programming & Aptitude Test is one of the best app to test your programming Skill " +
				"and Aptitude.\n" +
				"\t Programming Quiz checks your Technical skill and gives you the performance result by asking nu. of " +
				"questions based on the different languages.\n" +
				"\t Aptitude Test is also a part of this application to improve your Aptitude knowledge.\n\n" +
				"Disclaimer : \t This is our First Android Application and It has been developed as a " +
				"part of our training project work for our Engineering course. It has been purely" +
				"built to demonstrate our Android Application development skill. The content present" +
				"in this Application has been gathered from varios internet sources and we do not " +
				"guarantee the validity and correctness of the same.\n\n" +
				"\t Please give your feedback and Rating, So that i can improve more.";
		tv_about.setText(""+d);
	}


}
