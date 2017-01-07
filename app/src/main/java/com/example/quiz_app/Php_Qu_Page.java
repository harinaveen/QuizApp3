package com.example.quiz_app;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Php_Qu_Page extends Activity {
	
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
		setContentView(R.layout.activity_php__qu__page);
		
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
		
		//------------------------on click start--------------------------------
		
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
							
							String ch="Php";
							//MainActivity.this.finish();
							Intent ob=new Intent(Php_Qu_Page.this,Result.class);
							ob.putExtra("SEND", count);
							ob.putExtra("PAGE_NAME", ch);
							startActivity(ob);
							Php_Qu_Page.this.finish();
							
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
		
		//-----------------------close click start--------------------------------
		
		
	}	//closing of oncreate
	
	public void Questions()				//  function to Store all Questions
	{
		//Question---1
		ques[0]="PHP scripts are used in";
		option1[0]="Server-side scripting";
		option2[0]="Command-line scripting";
		option3[0]="Client-side GUI applications";
		option4[0]="All of these above";
		answer[0]="All of these above";
		// Question---2	
		ques[1]="Which is/are of the following is/are true about PHP-GTK ?";
		option1[1]="-GTK provides an object-oriented interface to GTK+ classes and functions";
		option2[1]="PHP-GTK is a library for PHP programming language which implements language bindings."; 
		option3[1]="Only A";
		option4[1]="Both [A] and [B]";
		answer[1]="Both [A] and [B]";
		// Question---3	
		ques[2]="PHP does not have an built in support for which one of the following ?";
		option1[2]="JPEG";
		option2[2]="GIF"; 
		option3[2]="MPEG";
		option4[2]="PDF";
		answer[2]="MPEG";
		// Question---4
		ques[3]="In PHP language PEAR stands for";
		option1[3]="PHP Enhancement and Application reduce";
		option2[3]="PHP Event and Application Repository"; 
		option3[3]="PHP Extension and Application Repository";
		option4[3]="None of these above";
		answer[3]="PHP Extension and Application Repository";
		// Question---5
		ques[4]="PHP stands for :";
		option1[4]="Hypertext preprocessor";
		option2[4]="Hypertext processor";
		option3[4]="HTML preprocessor";
		option4[4]="HTNL processor";
		answer[4]="Hypertext preprocessor";
		// Question---6
		ques[5]="PHP configuration settings are maintained in";
		option1[5]="pws-php5cgi.reg";
		option2[5]="php.ini"; 
		option3[5]="httpd.conf";
		option4[5]="httpd-info.conf";
		answer[5]="php.ini"; 
		// Question---7
		ques[6]="During PHP installation which function creates a HTML " +
				"page to display records how PHP was installed ?";
		option1[6]="phpconf()";
		option2[6]="phpinfo()"; 
		option3[6]="phprec()";
		option4[6]="phpdisplay()";
		answer[6]="phpinfo()";
		// Question---8
		ques[7]="Select the incorrect statement about PHP programming language";
		option1[7]="Classes are case-insensitive";
		option2[7]="Functions rae case-insensitive"; 
		option3[7]="Variables are case-insensitive";
		option4[7]="Constants are case-sensitive";
		answer[7]="Variables are case-insensitive";
		//Question-----9
		ques[8]="In PHP programming literal is a";
		option1[8]="Class"; 
		option2[8]="Function";
		option3[8]="Data Value";
		option4[8]="None of these above";
		answer[8]="Data Value";
		//Question-----10
		ques[9]="Which class name is reserveed in PHP ?";
		option1[9]="stdClass";
		option2[9]="nameClass"; 
		option3[9]="newClass";
		option4[9]="None of these above";
		answer[9]="stdClass";
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
