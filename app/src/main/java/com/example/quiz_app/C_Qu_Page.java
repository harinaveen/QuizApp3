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

public class C_Qu_Page extends Activity {
	
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
		setContentView(R.layout.activity_c__qu__page);
		
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
		/*
		tv.setText(ques[0]);
		rb1.setText(option1[0]);
		rb2.setText(option2[0]);
		rb3.setText(option3[0]);
		rb4.setText(option4[0]);
		*/
		
		
		//------------------------b_check_answer on click start--------------------------------
		
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
				
			}		// closing of onclick
		});
		
		//------------------------b_check_answer on click listener Close--------------------------------
		
		
		
		
	//------------------------b_next on click listener start--------------------------------
		
		
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
							
							//MainActivity.this.finish();
							String ch="C";
							Intent ob=new Intent(C_Qu_Page.this,Result.class);
							ob.putExtra("SEND", count);
							ob.putExtra("PAGE_NAME", ch);
							startActivity(ob);
							finish();
							
						}
					});
					AlertDialog alert1=alert.create();
					alert1.show();
					
					
					//-------------Alert Box  Close-----------------------------------------
					/*
					Intent ob=new Intent(C_Qu_Page.this,Result.class);
					ob.putExtra("SEND", count);
					startActivity(ob);
					finish();
					*/
					
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
		
		//------------------------b_next on click listener close--------------------------------
		
}	// ---------------------onCreate  close---------------------------------
	
	public void Questions()				//  function to Store all Questions
	{
		//Question---1
		ques[0]="The case keyword is followed by ?";
		option1[0]="Float values";
		option2[0]="Character values";
		option3[0]="integer values";
		option4[0]="Both b and c";
		answer[0]="Both b and c";
		// Question---2	
		ques[1]=" #include<stdio.h> \n" +
				"void main()\n" +
				"{char suite =3;\n" +
				"switch(suite)\n" +
				"{\n" +
				"case 1:printf(\"ALL QUIZ\");\n" +
				"case 2:printf(\"All quiz is great\");\n" +
				"default: printf(\"All quiz contains MCQs\");\n" +
				"}\n" +
				"printf(\"Are you like All quiz ?\");}";
		option1[1]="ALL QUIZ";
		option2[1]="All quiz is great"; 
		option3[1]="All quiz contains MCQs";
		option4[1]="All quiz is great Are you like Al quiz ?";
		answer[1]="All quiz is great Are you like Al quiz ?";
		// Question---3	
		ques[2]="Who is father of C Language?";
		option1[2]="Bjarne Stroustrup";
		option2[2]="Dennis Ritchie"; 
		option3[2]="James A. Gosling";
		option4[2]="Dr. E.F. Codd";
		answer[2]="Dennis Ritchie";
		// Question---4
		ques[3]="For 16-bit compiler allowable range for integer constants is ______";
		option1[3]="-3.4e38 to 3.4e38";
		option2[3]="-32767 to 32768"; 
		option3[3]="-32768 to 32767";
		option4[3]="-32668 to 32667";
		answer[3]="-32768 to 32767";
		// Question---5
		ques[4]="Bitwise operators can operate upon?";
		option1[4]="double and chars";
		option2[4]="Floats and doubles"; 
		option3[4]="ints and floats";
		option4[4]="ints and chars";
		answer[4]="ints and chars";
		// Question---6
		ques[5]="What is C Tokens?";
		option1[5]="The smallest individual units of c program";
		option2[5]="The basic element recognized by the compiler"; 
		option3[5]="A & B Both";
		option4[5]="The largest individual units of program";
		answer[5]="A & B Both";
		// Question---7
		ques[6]="What will be the value of `a` after the following code is executed \n" +
				"#define square(x)x*x \n" +
				"a = square(2+3)";
		option1[6]="10";
		option2[6]="25"; 
		option3[6]="11";
		option4[6]="13";
		answer[6]="11";
		// Question---8
		ques[7]="#include void func()\n" +
				"{\n" +
				"int x = 0;\n" +
				"static int y = 0;\n" +
				"x++; y++;\n" +
				"printf( \"%d -- %d\n\", x, y );\n" +
				"}\n" +
				"int main()\n" +
				"{\n" +
				"func();\n" +
				"func();\n" +
				"return 0;\n" +
				"}";
		option1[7]="1 -- 1\n" +
					"1 -- 1";
		option2[7]="1 -- 1\n" +
					"2 -- 1"; 
		option3[7]="1 -- 1\n" +
					"2 -- 2";
		option4[7]="1 -- 1\n" +
					"1 -- 2";
		answer[7]="1 -- 1\n" +
					"1 -- 2";
		//Question-----9
		ques[8]="long factorial (long x)\n" +
				"{\n" +
				"????\n" +
				"return x * factorial(x - 1);\n" +
				"}\n" +
				"With what do you replace the ???? to make the function shown above return the correct answer?";
		option1[8]="if (x == 0) return 0;";
		option2[8]="return 1;"; 
		option3[8]="if (x >= 2) return 2;";
		option4[8]="if (x <= 1) return 1;";
		answer[8]="if (x <= 1) return 1;";
		//Question-----10
		ques[9]="What will be output if you will compile and execute the following c code?\n" +
				"void main(){\n" +
				"if(printf(\"cquestionbank\"))\n" +
						"printf(\"I know c\");\n" +
						"else printf(\"I know c++\");\n" +
						"}";
		option1[9]="I know c";
		option2[9]="cquestionbankI know c"; 
		option3[9]="I know c++;";
		option4[9]="Compiler error";
		answer[9]="cquestionbankI know c";
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
	public void calculation(String u_a[],String a[])
	{
		int x=0;
		for(int j=0;j<=2;j++)
		{
			if(u_a[0].equals(a[0]))
			{
				x++;
			}
		}
		/*
		
		int x=0;
		for(int j=0;j<=2;j++)
		{
			if(u_a[j].equals(a[j]))
			{
				x++;
			}
		}
		*/
	//	Toast.makeText(getApplicationContext(), "Done "+x, Toast.LENGTH_SHORT).show();
		
		//Toast.makeText(getApplicationContext(), " "+x, Toast.LENGTH_SHORT).show();
		//Intent ob=new Intent(C_Qu_Page.this,Result.class);
		// ob.putExtra("SEND", x);
		//startActivity(ob);
	}
	
}
