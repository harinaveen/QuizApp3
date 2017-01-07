package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	
	TextView right_answer,wrong_answer,per_result,advice,tv_nu_of_qu;
	Button go_to_home,go_to_check_answer;
	ImageView img_view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		Toast.makeText(getApplicationContext(), "result page ", Toast.LENGTH_SHORT).show();
		
		
		go_to_home=(Button)findViewById(R.id.go_to_home);
		go_to_check_answer=(Button) findViewById(R.id.go_to_check_answer);
		
		right_answer=(TextView)findViewById(R.id.right_answer);
		wrong_answer=(TextView)findViewById(R.id.wrong_answer);
		per_result=(TextView)findViewById(R.id.per_result);
		advice=(TextView)findViewById(R.id.advice);
		tv_nu_of_qu=(TextView)findViewById(R.id.tv_nu_of_qu);
		
		Bundle ob=getIntent().getExtras();
		int score;
		score=ob.getInt("SEND");
		
		Bundle ob1=getIntent().getExtras();
		final String name;
		name=ob1.getString("PAGE_NAME");
		
		
		// Toast.makeText(getApplicationContext(), "result page "+score, Toast.LENGTH_SHORT).show();
		
		if(name.equals("Apptitude"))
		{
			tv_nu_of_qu.setText("30");
			right_answer.setText(""+score);
			wrong_answer.setText(""+(30-score));
			
			float  aa=(float)(score/30.0);
			float f=aa*100;
			per_result.setText(""+f+" %");
			// Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
			switch(score) 
			{
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 12:
			case 13:
			case 14:
					advice.setText("Try Hard.");
					break;
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
					advice.setText("Much Better.");
					break;
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
					advice.setText("More Better.");
					break;
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
					advice.setText("Good Performance.");
				break;
			}
		}
		else
		{
			tv_nu_of_qu.setText("10");

			
			right_answer.setText(""+score);
			wrong_answer.setText(""+(10-score));
			
			float f=score*10;
			per_result.setText(""+f+" %");
			
			switch(score) 
			{
			case 1:
			case 2:
			case 3:
					advice.setText("Try Hard.");
					break;
			case 4:
			case 5:
					advice.setText("Much Better.");
					break;
			case 6:
			case 7:
					advice.setText("More Better.");
					break;
			case 8:
			case 9:
			case 10:
					advice.setText("Good Performance.");
				break;
			}
		}
		
		
		go_to_home.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
			Intent ob=new Intent(Result.this,Home_Page.class);
			startActivity(ob);
				
			}
		});
		
		go_to_check_answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent ob=new Intent(Result.this,All_Answers.class);
				ob.putExtra("PAGE_NAME", name);
				startActivity(ob);
				
			}
		});
		
	}

	
}
