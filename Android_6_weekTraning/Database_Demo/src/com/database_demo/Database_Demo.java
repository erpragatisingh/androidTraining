package com.database_demo;



import com.database_demo.data.Databasee;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Database_Demo extends Activity {
	EditText e1, e2;
	Button b1;
	data d11;
//	Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database__demo);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		ListView l1=(ListView)findViewById(R.id.listView1);
	    d11= new data(this);
//	    c= d11.getData();
//	    Adap adapter= new Adap(this, c, R.layout.list);
//	    l1.setAdapter(adapter);
	    
	    
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				d11.adddata(e1.getText().toString());
				
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Database_Demo.this, Listada.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database__demo, menu);
		return true;
	}

}
