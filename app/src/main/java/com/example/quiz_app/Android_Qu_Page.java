package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Android_Qu_Page extends Activity {
	
	Button b_next,b_check_answer;
	TextView tv;
	RadioGroup radioGroup;
	RadioButton rb1,rb2,rb3,rb4,rb;
	public static int count=0;
	public static int count_last_i=0;
	
	public String ques[]=new String[10];
	public String option1[]=new String[10];
	public String option2[]=new String[10];
	public String option3[]=new String[10];
	public String option4[]=new String[10];
	public String answer[]=new String[10];
	public String user_answer[]=new String[10];
	
	int i=0;
	
	final Context context=this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android__qu__page);
		
		b_next=(Button)findViewById(R.id.b_next);
		b_check_answer=(Button)findViewById(R.id.b_check_answer);
		
		rb1=(RadioButton)findViewById(R.id.radio1);
		rb2=(RadioButton)findViewById(R.id.radio2);
		rb3=(RadioButton)findViewById(R.id.radio3);
		rb4=(RadioButton)findViewById(R.id.radio4);
		tv=(TextView)findViewById(R.id.textView1);
		
		radioGroup=(RadioGroup)findViewById(R.id.radioGroup1);

		Questions();
		
		print(i);
		
		
		
		//------------------------b_check_answer on click listener start--------------------------------
		
		b_check_answer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				if (rb1.isChecked()==false && rb2.isChecked()==false && rb3.isChecked()==false && rb4.isChecked()==false)
				{
					Toast.makeText(getApplicationContext(), "Please Select Your Answer", Toast.LENGTH_SHORT).show();
				}
				else
				{
				
					int r= radioGroup.getCheckedRadioButtonId();
					rb=(RadioButton)findViewById(r);
					String abcd=rb.getText().toString();
				
					if(abcd.equals(answer[count_last_i-1]))
					{
						
						rb1.setEnabled(false);
						rb2.setEnabled(false);
						rb3.setEnabled(false);
						rb4.setEnabled(false);
						Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT).show();
					}
					else 
					{
						rb1.setEnabled(false);
						rb2.setEnabled(false);
						rb3.setEnabled(false);
						rb4.setEnabled(false);
						Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
					}
				}
				
			}
		});
		
		//------------------------b_check_answer on click listener close--------------------------------
		
		
		
		
		//-------------------b_next onclick listener----------------------
		
		b_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				rb1.setEnabled(true);
				rb2.setEnabled(true);
				rb3.setEnabled(true);
				rb4.setEnabled(true);
				
				i++;
				count_last_i=i;
				if(i>9)
				{
					int r= radioGroup.getCheckedRadioButtonId();
					rb=(RadioButton)findViewById(r);
					user_answer[i-1]=rb.getText().toString();
					
					
					if(user_answer[i-1].equals(answer[i-1]))
					{
						count++;
						//Toast.makeText(getApplicationContext(), "Right answer ="+count, Toast.LENGTH_SHORT).show();
					}
					
					//calculation(user_answer,answer);
					//Toast.makeText(getApplicationContext(), "Total Right answer ="+count, Toast.LENGTH_SHORT).show();
					//-------------Alert Box  Open-----------------------------------------
					
					AlertDialog.Builder alert=new AlertDialog.Builder(context);
					
					alert.setTitle("Done");
					
					alert.setMessage("Click 'Go' for Result page").setCancelable(false).setPositiveButton("Go", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
							String ch="Android";
							//MainActivity.this.finish();
							Intent ob=new Intent(Android_Qu_Page.this,Result.class);
							ob.putExtra("SEND", count);
							ob.putExtra("PAGE_NAME", ch);
							startActivity(ob);
							finish();
							
						}
					});
					AlertDialog alert1=alert.create();
					alert1.show();
					
					
					//-------------Alert Box  Close-----------------------------------------
					
				}
				else if (rb1.isChecked()==false && rb2.isChecked()==false && rb3.isChecked()==false && rb4.isChecked()==false)
				{
					Toast.makeText(getApplicationContext(), "Please Select an option", Toast.LENGTH_SHORT).show();
					i--;
					count_last_i=i;
					print(i);
					
				}
				else
				{
				
				int r= radioGroup.getCheckedRadioButtonId();
				rb=(RadioButton)findViewById(r);
				user_answer[i-1]=rb.getText().toString();
				
					if(user_answer[i-1].equals(answer[i-1]))
					{
						count++;
						//Toast.makeText(getApplicationContext(), "Right answer ="+count, Toast.LENGTH_SHORT).show();
					}
				
				radioGroup.clearCheck();
				
				// Toast.makeText(getApplicationContext(), " "+user_answer[i-1], Toast.LENGTH_LONG).show();
				 print(i);
				}
			
			}
		});
		
		
		//-------------------b_next close onclick litener----------------------
	}	// closing of oncreate
	
	public void Questions()				//  function to Store all Questions
	{
		//Question---1
		ques[0]="Once installed on a device, each Android application lives in___";
		option1[0]="device memory";
		option2[0]="external memory";
		option3[0]="security sandbox";
		option4[0]="None of the above";
		answer[0]="security sandbox";
		// Question---2	
		ques[1]="Parent class of Activity?";
		option1[1]="Object";
		option2[1]="Context"; 
		option3[1]="ActivityGroup";
		option4[1]="ContextThemeWrapper";
		answer[1]="ContextThemeWrapper";
		// Question---3	
		ques[2]="What are the indirect Direct subclasses of Activity?";
		option1[2]="LauncherActivity";
		option2[2]="PreferenceActivity"; 
		option3[2]="TabActivity";
		option4[2]="All the above";
		answer[2]="All the above";
		// Question---4
		ques[3]="Which component is not activated by an Intent?";
		option1[3]="Activity";
		option2[3]="Services"; 
		option3[3]="ContentProvider";
		option4[3]="BroadcastReceiver";
		answer[3]="ContentProvider";
		// Question---5
		ques[4]="Which of the  important device characteristics that you should consider as you design and develop your application?";
		option1[4]="Screen size and density";
		option2[4]="Device features"; 
		option3[4]="Platform Version";
		option4[4]="All of the above";
		answer[4]="All of the above";
		// Question---6
		ques[5]="Which are the  screen densities in Android?";
		option1[5]="low density";
		option2[5]="medium density"; 
		option3[5]="high density";
		option4[5]="All of the above";
		answer[5]="All of the above";
		// Question---7
		ques[6]="How many ways to start services?";
		option1[6]="Started";
		option2[6]="Bound"; 
		option3[6]="a & b";
		option4[6]="None of the above.";
		answer[6]="a & b";
		// Question---8
		ques[7]="If you want share the data accross the all applications ,you should go for?";
		option1[7]="Shared Preferences";
		option2[7]="Internal Storage"; 
		option3[7]="SQLite Databases";
		option4[7]="content provider";
		answer[7]="content provider";
		//Question-----9
		ques[8]="Difference between android api and google api?";
		option1[8]="The google API includes Google Maps and other Google-specific libraries. The Android one only includes core android libraries.";
		option2[8]="The google API one only includes core android libraries. The Android  includes Google Maps and other Google-specific libraries."; 
		option3[8]="a and b both";
		option4[8]="None of the above.";
		answer[8]="The google API includes Google Maps and other Google-specific libraries. The Android one only includes core android libraries.";
		//Question-----10
		ques[9]="What is Intent?";
		option1[9]="A class Which describes what a caller desires to do";
		option2[9]="The Caller will send this intent to android's intent resolver"; 
		option3[9]="both";
		option4[9]="None of these";
		answer[9]="both";
	}
	public void print(int s)					// function to print Questions
	{
		tv.setText((s+1)+" : "+ques[s]);
		rb1.setText(option1[s]);
		rb2.setText(option2[s]);
		rb3.setText(option3[s]);
		rb4.setText(option4[s]);
	
		count_last_i++;
	}

}
