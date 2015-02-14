package com.example.attendancemaster;



import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMon extends Activity{

	TextView t1,t2,t3,t4,t5,t6,t7,t8;
	EditText e1,e2,e3,e4,e5,e6,e7,e8;
	Button b;
	My_SqliteHelper obj=new My_SqliteHelper(this, "attendancemaster.db", null, 1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addmonday);
		t1=(TextView)findViewById(R.id.lec1);
		t2=(TextView)findViewById(R.id.lec2);
		t3=(TextView)findViewById(R.id.lec3);
		t4=(TextView)findViewById(R.id.lec4);
		t5=(TextView)findViewById(R.id.lec5);
		t6=(TextView)findViewById(R.id.lec6);
		t7=(TextView)findViewById(R.id.lec7);
		t8=(TextView)findViewById(R.id.lec8);
		
		e1=(EditText)findViewById(R.id.editLec1);
		e2=(EditText)findViewById(R.id.editLec2);
		e3=(EditText)findViewById(R.id.editLec3);
		e4=(EditText)findViewById(R.id.editLec4);
		e5=(EditText)findViewById(R.id.editLec5);
		e6=(EditText)findViewById(R.id.editLec6);
		e7=(EditText)findViewById(R.id.editLec7);
		e8=(EditText)findViewById(R.id.editLec8);
		b=(Button)findViewById(R.id.submit1);
		
		String fontpath="fonts/BRADHITC.TTF";
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        e1.setTypeface(tf);
        e2.setTypeface(tf);
        e3.setTypeface(tf);
        e4.setTypeface(tf);
        e5.setTypeface(tf);
        e6.setTypeface(tf);
        e7.setTypeface(tf);
        e8.setTypeface(tf);
        
        
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					SQLiteDatabase db=obj.getWritableDatabase();
					ContentValues cur=new ContentValues();
					cur.put(My_SqliteHelper.lec1,e1.getText().toString());
					cur.put(My_SqliteHelper.lec2,e2.getText().toString() );
					cur.put(My_SqliteHelper.lec3,e3.getText().toString() );
					cur.put(My_SqliteHelper.lec4,e4.getText().toString() );
					cur.put(My_SqliteHelper.lec5,e5.getText().toString() );
					cur.put(My_SqliteHelper.lec6,e6.getText().toString() );
					cur.put(My_SqliteHelper.lec7,e7.getText().toString() );
					cur.put(My_SqliteHelper.lec8,e8.getText().toString() );
					db.insert(My_SqliteHelper.dtable, null, cur);
					Toast.makeText(getApplicationContext(), "Insert Successful",Toast.LENGTH_LONG).show();
					db.close();
					//et1.setText("");
					//et2.setText("");
				}
				catch(Exception e)
				{
					String mag=e.toString();
					Toast.makeText(getBaseContext(), mag, Toast.LENGTH_LONG).show();
					Log.d("Del Exp",mag);
				}
			}
		});
		
	}
}
