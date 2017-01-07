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

public class Apptitude_Qu_Page extends Activity {

	Button b_next,b_check_answer;
	TextView tv;
	RadioGroup radioGroup;
	RadioButton rb1,rb2,rb3,rb4,rb;
	public static int count=0;
	public static int count_last_i=0;
	
	public String ques[]=new String[30];
	public String option1[]=new String[30];
	public String option2[]=new String[30];
	public String option3[]=new String[30];
	public String option4[]=new String[30];
	public String answer[]=new String[30];
	public String user_answer[]=new String[30];
	
	int i=0;
	
	final Context context=this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apptitude__qu__page);
		
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
				if(i>29)
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
							
							String ch="Apptitude";
							//MainActivity.this.finish();
							Intent ob=new Intent(Apptitude_Qu_Page.this,Result.class);
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
		
		
	}		// close of oncreate
	
	public void Questions()				//  function to Store all Questions
	{
		//Question---1
				ques[0]="The number of prime numbers in \n (25)13*(10)7*(27)5 is?";
				option1[0]="25";
				option2[0]="32";
				option3[0]="55";
				option4[0]="42";
				answer[0]="55";
				// Question---2	
				ques[1]="what will be the remainder when\n (29)36 is divided by 28?";
				option1[1]="0";
				option2[1]="1"; 
				option3[1]="29";
				option4[1]="5";
				answer[1]="1";
				// Question---3	
				ques[2]="what will be the digit in the unit place in the product\n (3807)194 * (932)84?";
				option1[2]="1";
				option2[2]="9"; 
				option3[2]="4";
				option4[2]="2";
				answer[2]="4"; 
				// Question---4
				ques[3]="There is a number 8*20 which if multiplied by 6, the product is divisible by 8. The digit replacing * mark is?";
				option1[3]="4";
				option2[3]="0"; 
				option3[3]="Any digit in between 0 and 9";
				option4[3]="2";
				answer[3]="Any digit in between 0 and 9";
				// Question---5
				ques[4]="The ratio between two numbers is 4:5 and their sum is 540. The greater of the two numbers is?";
				option1[4]="360";
				option2[4]="240"; 
				option3[4]="300";
				option4[4]="700";
				answer[4]="300";
				// Question---6
				ques[5]="1/4 of a number subtracted from 1/3 of the number gives 12. The Number is";
				option1[5]="144";
				option2[5]="188"; 
				option3[5]="196";
				option4[5]="225";
				answer[5]="144";
				// Question---7
				ques[6]="Three fifth of one fourth of a number is 90. The number is?";
				option1[6]="400";
				option2[6]="600"; 
				option3[6]="800";
				option4[6]="500";
				answer[6]="600";
				// Question---8
				ques[7]="What is the total number of numbers up to 9999?";
				option1[7]="98900";
				option2[7]="10000"; 
				option3[7]="9999";
				option4[7]="98100";
				answer[7]="9999"; 
				//Question-----9
				ques[8]="low temperature at the night in a city is 1/3 more than 1/2 hinge as higher temperature in a day. sum of the low temp and higherst temp is 100C. then what is the low temperature";
				option1[8]="30 C";
				option2[8]="40 C"; 
				option3[8]="50 C";
				option4[8]="60 C";
				answer[8]="40 C";
				//Question-----10
				ques[9]="In a mixture, R is 2 parts, S is 1 part. in order to make S to 25% of the mixture, howmuch R is to be added";
				option1[9]="one part";
				option2[9]="two part"; 
				option3[9]="three part";
				option4[9]="four part";
				answer[9]="one part";
				//Question-----11
				ques[10]="There are two circles, one circle is inscribed and another circle is circumscribed over a square. What is the ratio of area of inner to outer circle?";
				option1[10]="1:2";
				option2[10]="2:1"; 
				option3[10]="1:1/2";
				option4[10]="1/2:1";
				answer[10]="1:2";
				//Question-----12
				ques[11]="If the operation,^ is defined by the equation x ^ y = 2x + y,what is the value of a in 2 ^ a = a ^3";
				option1[11]="0";
				option2[11]="1"; 
				option3[11]="-1";
				option4[11]="4";
				answer[11]="1";
				//Question-----13
				ques[12]="In a group of 15,7 have studied Latin, 8 have studied Greek, and 3 have not studied either.How many of these studied both Latin and Greek";
				option1[12]="0";
				option2[12]="3"; 
				option3[12]="4";
				option4[12]="5";
				answer[12]="3";
				//Question-----14
				ques[13]="If 13 = 13w/(1-w) ,then (2w)2 =";
				option1[13]="1/4";
				option2[13]="1/2"; 
				option3[13]="1";
				option4[13]="2";
				answer[13]="1";
				//Question-----15
				ques[14]="If a and b are positive integers and (a-b)/3.5 = 4/7, then";
				option1[14]="b < a";
				option2[14]="b > a"; 
				option3[14]="b = a";
				option4[14]="b >= a";
				answer[14]="b < a";
				//Question-----16
				ques[15]="If the value of x lies between 0 & 1 which of the following is the largest?";
				option1[15]="x";
				option2[15]="x^2"; 
				option3[15]="-x";
				option4[15]="1/x";
				answer[15]="1/x";
				//Question-----17
				ques[16]="An equilateral triangle of sides 3 inch each is given. How many equilateral triangles of side 1 inch can be formed from it?";
				option1[16]="1";
				option2[16]="3"; 
				option3[16]="6";
				option4[16]="9";
				answer[16]="9";
				//Question-----18
				ques[17]="If the value of x lies between 0 & 1 which of the following is the largest?";
				option1[17]="x";
				option2[17]="x^2"; 
				option3[17]="-x";
				option4[17]="1/x";
				answer[17]="1/x";
				//Question-----19
				ques[18]="(X% of Y+Y%of X)=?";
				option1[18]="2% of x+y";
				option2[18]="1% of x+y"; 
				option3[18]="1% of xy";
				option4[18]="2% of xy";
				answer[18]="2% of xy";
				//Question-----20
				ques[19]="If three fifth of a number is 40 more than 40% of the same number. What is the number";
				option1[19]="200";
				option2[19]="100"; 
				option3[19]="400";
				option4[19]="300";
				answer[19]="200";
				//Question-----21
				ques[20]="A student has to secure 40% marks to pass. He gets 178 marks and fails by 22 marks. The maximum marks are :";
				option1[20]="100";
				option2[20]="300"; 
				option3[20]="500";
				option4[20]="700";
				answer[20]="500";
				//Question-----22
				ques[21]="If the radius of a circle is diminished by 10%, then its area is diminished by:";
				option1[21]="10%";
				option2[21]="19%"; 
				option3[21]="20%";
				option4[21]="36%";
				answer[21]="19%";
				//Question-----23
				ques[22]="What is the missing number in this series? 8 2 14 6 11 ? 14 6 18 12";
				option1[22]="16";
				option2[22]="9"; 
				option3[22]="15";
				option4[22]="6";
				answer[22]="9";
				//Question-----24
				ques[23]="8 15 24 35 48 63 _?";
				option1[23]="70";
				option2[23]="80"; 
				option3[23]="75";
				option4[23]="88";
				answer[23]="80";
				//Question-----25
				ques[24]="2 numbers differ by 5.If their product is 336,then the sum of the 2 numbers is:";
				option1[24]="21";
				option2[24]="51"; 
				option3[24]="28";
				option4[24]="37";
				answer[24]="37";
				//Question-----26
				ques[25]="Which number is the odd one out? \n 9678, 4572, 5261, \n3527";
				option1[25]="3527";
				option2[25]="5261"; 
				option3[25]="4572";
				option4[25]="9678";
				answer[25]="3527";
				//Question-----27
				ques[26]="If x=y=2z and xyz=256 then what is the value of x?";
				option1[26]="3";
				option2[26]="8"; 
				option3[26]="6";
				option4[26]="5";
				answer[26]="8";
				//Question-----28
				ques[27]="In a single throw of a dice, what is the probability of getting a number greater than 4?";
				option1[27]="1/2";
				option2[27]="2/3"; 
				option3[27]="1/4";
				option4[27]="1/3";
				answer[27]="1/3";
				//Question-----29
				ques[28]="The cost of 16 packets of salt,each weighing 900 grams is Rs.28.What will be the cost of 27 packets ,if each packet weighs 1Kg?";
				option1[28]="Rs.52.50";
				option2[28]="Rs.56"; 
				option3[28]="Rs.58.50";
				option4[28]="Rs.64.75";
				answer[28]="Rs.52.50";
				//Question-----30
				ques[29]="The product of two fractions is 14/15 and their quotient is 35/24. the greater fraction is";
				option1[29]="4/5";
				option2[29]="4/7"; 
				option3[29]="7/4";
				option4[29]="7/5";
				answer[29]="4/5";
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
	

}			// close of main
