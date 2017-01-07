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

public class Java_Qu_Page extends Activity {
	
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
		setContentView(R.layout.activity_java__qu__page);
		
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
		
		//------------------b_next listenner-------------------------------------
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
							
							String ch="Java";
							//MainActivity.this.finish();
							Intent ob=new Intent(Java_Qu_Page.this,Result.class);
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
		
		
		
		//------------------closing of b_next listener-----------------------------
	}	//  closing of oncreate

	public void Questions()				//  function to Store all Questions
	{
		//Question---1
		ques[0]="What is byte code in the context of Java?";
		option1[0]="The type of code generated by a Java compiler";
		option2[0]="The type of code generated by a Java Virtual Machine";
		option3[0]="It is another name for a Java source file";
		option4[0]="It is the code written within the instance methods of a class.";
		answer[0]="The type of code generated by a Java compiler";
		// Question---2	
		ques[1]="What is different between a Java applet and a Java application?";
		option1[1]="An application can in general be trusted whereas an applet can't.";
		option2[1]="An applet must be executed in a browser environment."; 
		option3[1]="An applet is not able to access the files of the computer it runs on";
		option4[1]="All of the above";
		answer[1]="All of the above";
		// Question---3	
		ques[2]="Which is true about an anonymous inner class?";
		option1[2]="It can extend exactly one class and implement exactly one interface.";
		option2[2]="It can extend exactly one class and can implement multiple interfaces"; 
		option3[2]="It can implement multiple interfaces regardless of whether it also extends a class.";
		option4[2]="None of th e above";
		answer[2]="It can extend exactly one class and can implement multiple interfaces"; 
		// Question---4
		ques[3]="If a thread is to be declared as a daemon thread, it must be declared before";
		option1[3]="start method";
		option2[3]="run method"; 
		option3[3]="stop method";
		option4[3]="none";
		answer[3]="start method";
		// Question---5
		ques[4]="Which of the following is the correct syntax for suggesting that the JVM performs garbage collection";
		option1[4]="System.free();";
		option2[4]="System.setGarbageCollection();"; 
		option3[4]="System.out.gc()";
		option4[4]="System.gc();";
		answer[4]="System.gc();";
		// Question---6
		ques[5]="A class that cannot be a subclass is called as______ class.";
		option1[5]="abstract";
		option2[5]="parent class "; 
		option3[5]="Final";
		option4[5]="none of these";
		answer[5]="Final";
		// Question---7
		ques[6]="Which model used in swing component?";
		option1[6]="Model view controller";
		option2[6]="Event delegation model"; 
		option3[6]="Document object model";
		option4[6]="network model";
		answer[6]="Model view controller";
		// Question---8
		ques[7]="rocess of storing the object contain into the file is known as _______";
		option1[7]="synchronization";
		option2[7]="serialization"; 
		option3[7]="zip";
		option4[7]="doping";
		answer[7]="serialization"; 
		//Question-----9
		ques[8]="What is the default buffer size used by any buffered class?";
		option1[8]="128 bytes ";
		option2[8]="256 bytes "; 
		option3[8]="512 bytes";
		option4[8]="1024 bytes";
		answer[8]="512 bytes";
		//Question-----10
		ques[9]="FileOutputStream class store the data in the form of _____";
		option1[9]="characters";
		option2[9]="file"; 
		option3[9]="bytes";
		option4[9]="bit";
		answer[9]="bytes";
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
	
	
}		//closing of main
