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
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class EvaluateTest extends Activity {
	ArrayList<Question> ques_list = new ArrayList<Question>();
	Test_Activity activity=null;
	int total_marks=0;
	int marks_obtained=0;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.evaluate_test);
		 System.out.println("Inside Submit Test Activity");
		 activity=getIntent().getExtras().getParcelable("activity");
		 ques_list=activity.getQues_list();
		 TableLayout table = (TableLayout) findViewById(R.id.evaluate_table);
	     TableRow row = new TableRow(this);
	     row.setBackgroundColor(Color.WHITE);
	     row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
	     addTextView(row,"Sno.");
         addTextView(row,"Selected Option");
         addTextView(row,"Correct Option");
         addTextView(row,"State");
         addTextView(row,"Marks");        
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
	 	     addTextView(row,ques_list.get(i).getSolution());
	 	     if( ques_list.get(i).getSelected_option() !=null){
	                ImageView img1 = new ImageView(this);
	                if(ques_list.get(i).getSelected_option().equals(ques_list.get(i).getSolution())){
	                	marks_obtained+=Integer.parseInt(ques_list.get(i).getMarks());
	                	//img1.setImageResource(R.drawable.tick_mark);
	                }
	                else{
	                	//img1.setImageResource(R.drawable.wrong);
	                }
	                img1.setPadding(5, 5, 5, 5);
	                row.addView(img1);
	 	      }
	 	      else
	 	    	  addTextView(row,"-");
	          addTextView(row,ques_list.get(i).getMarks());
	          total_marks+=Integer.parseInt(ques_list.get(i).getMarks());
	          table.addView(row);
	      }		 
		  TextView tot_marks=(TextView) findViewById(R.id.total_marks);
		  TextView marks_obt=(TextView) findViewById(R.id.marks_obt);
		  tot_marks.setText(String.valueOf(total_marks));
		  marks_obt.setText(String.valueOf(marks_obtained));
	}
	void addTextView(TableRow row,String heading){
		 TextView text1 = new TextView(this);
         text1.setText(heading);
         text1.setTextColor(Color.BLACK);
         text1.setGravity(Gravity.CENTER);
         text1.setPadding(5, 5, 5, 5);
         text1.setTextSize(12);
         row.addView(text1);
	 }
}
