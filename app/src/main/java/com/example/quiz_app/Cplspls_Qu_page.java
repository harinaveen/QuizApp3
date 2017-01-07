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

public class Cplspls_Qu_page extends Activity {
	
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
		setContentView(R.layout.activity_cplspls__qu_page);
		
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
		
		//--------------------b_next Listener ------------------------------
		
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
							
							String ch="C++";
							//MainActivity.this.finish();
							Intent ob=new Intent(Cplspls_Qu_page.this,Result.class);
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

		
		//--------------------b_next Listener  close------------------------------
		
}			// closing of oncreate
	
	public void Questions()				//  function to Store all Questions
	{
		//Question---1
		ques[0]="What does STL stand for?";
		option1[0]="Simple Template Library";
		option2[0]="Standard Template Library";
		option3[0]="Static Type Library";
		option4[0]="Single Type-based Library";
		answer[0]="Standard Template Library";
		// Question---2	
		ques[1]="Which of the following is the most common way of implementing C++?";
		option1[1]="C++ programs are directly compiled into native code by a compiler";
		option2[1]="C++ programs are first compiled to intermediate code by a compiler " +
					"and then executed by a virtual machine"; 
		option3[1]="C++ programs are interpreted by an interpreter";
		option4[1]="C++ editor directly compiles and executes the program";
		answer[1]="C++ programs are directly compiled into native code by a compiler";
		// Question---3	
		ques[2]="If X is the name of the class, what is the correct way to declare copy constructor of X?";
		option1[2]="X(X arg)";
		option2[2]="X(X* arg)"; 
		option3[2]="X(const X* arg)";
		option4[2]="X(const X& arg)";
		answer[2]="X(const X& arg)";
		// Question---4
		ques[3]="Which of the following operators can be overloaded?";
		option1[3]=". (dot or member access operator)";
		option2[3]="& (address-of operator)"; 
		option3[3]="sizeof operator";
		option4[3]="?: (conditional operator)";
		answer[3]="& (address-of operator)";
		// Question---5
		ques[4]="How do we declare an abstract class?";
		option1[4]="By providing at least one pure virtual method (function signature followed by ==0;) in a class";
		option2[4]="By declaring at least one method abstract using the keyword ‘abstract’ in a class"; 
		option3[4]="By declaring the class abstract with the keyword ‘abstract’";
		option4[4]="It is not possible to create abstract classes in C++";
		answer[4]="By providing at least one pure virtual method (function signature followed by ==0;) in a class";
		// Question---6
		ques[5]="Which of the following correctly describes C++ language?";
		option1[5]="Statically typed language";
		option2[5]="Dynamically typed language"; 
		option3[5]="Both Statically and dynamically typed language";
		option4[5]="Type-less language";
		answer[5]="Statically typed language";
		// Question---7
		ques[6]="Which of the following is the most preferred way of throwing and handling exceptions?";
		option1[6]="Throw by value and catch by reference.";
		option2[6]="Throw by reference and catch by reference."; 
		option3[6]="Throw by value and catch by value";
		option4[6]="Throw the pointer value and provide catch for teh pointer type.";
		answer[6]="Throw by value and catch by reference.";
		// Question---8
		ques[7]="Minimum number of temporary variable needed to swap the contents of 2 variable is:";
		option1[7]="2";
		option2[7]="1"; 
		option3[7]="3";
		option4[7]="0";
		answer[7]="0";
		//Question-----9
		ques[8]="Which of the following is not a file operation:";
		option1[8]="Repositioning"; 
		option2[8]="Truncating";
		option3[8]="Appending";
		option4[8]="None of above";
		answer[8]="None of above";
		//Question-----10
		ques[9]="Which of the following is not recommended in a header file?";
		option1[9]="Type definitions (typedefs)";
		option2[9]="Class definitions"; 
		option3[9]="Function definitions";
		option4[9]="Template definitions";
		answer[9]="Function definitions";
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
	}		// closing of main

