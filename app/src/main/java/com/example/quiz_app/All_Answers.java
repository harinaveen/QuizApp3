package com.example.quiz_app;


import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.webkit.WebSettings.TextSize;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class All_Answers extends ListActivity {

	
	String arr[]=new String[10];
	String ss[]=new String[30];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_all__answers);
		
		
		
		Bundle ob1=getIntent().getExtras();
		final String name;
		name=ob1.getString("PAGE_NAME");
		
		if(name.equals("C"))
		{
			C_Qu_Page ob=new C_Qu_Page();
			ob.Questions();
			for(int i=0;i<=9;i++)
			{
			arr[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
		}
		else if (name.equals("Android")) 
		{
			Android_Qu_Page ob=new Android_Qu_Page();
			ob.Questions();
			for(int i=0;i<=9;i++)
			{
			arr[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
		}
		else if (name.equals("Php")) 
		{
			Php_Qu_Page ob=new Php_Qu_Page();
			ob.Questions();
			for(int i=0;i<=9;i++)
			{
			arr[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
		}
		else if (name.equals("Java")) 
		{
			Java_Qu_Page ob=new Java_Qu_Page();
			ob.Questions();
			for(int i=0;i<=9;i++)
			{
			arr[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
		}
		else if (name.equals("C++")) 
		{
			Cplspls_Qu_page ob=new Cplspls_Qu_page();
			ob.Questions();
			for(int i=0;i<=9;i++)
			{
			arr[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr));
		}
		else if (name.equals("Apptitude")) 
		{
			Apptitude_Qu_Page ob=new Apptitude_Qu_Page();
			ob.Questions();
			for(int i=0;i<30;i++)
			{
			ss[i]=(i+1)+". "+ob.answer[i];
			}
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ss));
		}
		
		//Toast.makeText(getApplicationContext(), ""+arr[0], Toast.LENGTH_SHORT).show();
		
		
		
		
		
	
	}	// close of oncreate


}
