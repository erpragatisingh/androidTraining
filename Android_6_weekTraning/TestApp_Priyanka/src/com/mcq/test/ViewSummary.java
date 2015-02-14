package com.mcq.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mcq.login.R;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;

public class ViewSummary extends Activity {
	ArrayList<Question> ques_list = new ArrayList<Question>();
	Test_Activity activity=null;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
		 	super.onCreate(savedInstanceState);
		 	setContentView(R.layout.view_summary);
		 	System.out.println("Inside Submit Test Activity");
		 	activity=getIntent().getExtras().getParcelable("activity");
			 ques_list=activity.getQues_list();
		 	TableRow.LayoutParams params = new TableRow.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		 	TableLayout table = (TableLayout) findViewById(R.id.summary_table);
	     	TableRow row = new TableRow(this);
	     	row.setBackgroundColor(Color.WHITE);
	     	row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
	     	addTextView(row,"S.no.");
	     	addTextView(row,"Selected Option");
	     	table.addView(row);
         	for (int i = 0; i < ques_list.size(); i++) {
            	 row = new TableRow(this);
            	 row.setBackgroundColor(Color.WHITE);
            	 row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            	 addTextView(row,ques_list.get(i).getId());
            	 if(ques_list.get(i).getSelected_option() != null)
            		 addTextView(row,ques_list.get(i).getSelected_option());
            	 else
            		 addTextView(row,"-");
            	 table.addView(row);
	     	} 

	 	}
		 void addTextView(TableRow row,String heading){
			 TextView text1 = new TextView(this);
             text1.setText(heading);
             text1.setGravity(Gravity.CENTER);
             text1.setTextColor(Color.BLACK);
        	 text1.setTextSize(12);
        	 text1.setPadding(5, 5, 5, 5);
        	 row.addView(text1);
		 }
	}
