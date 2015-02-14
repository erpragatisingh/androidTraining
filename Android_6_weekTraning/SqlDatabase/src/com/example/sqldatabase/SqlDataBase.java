package com.example.sqldatabase;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SqlDataBase extends Activity {
	EditText e1;
	Button b1, b2;
	DataBase db;
	Cursor c1;
	TextView t1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_data_base);
        e1=(EditText)findViewById(R.id.editText1);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        t1=(TextView)findViewById(R.id.textView2);
        db= new DataBase(this);
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				c1= db.getData();
				if (c1 != null) {
					c1.moveToFirst();
					for (int i = 0; i < c1.getCount(); i++) {
						
						String name = c1.getString(0);
						System.out.println(name);
						Toast.makeText(getApplicationContext(), name, 3000).show();
						t1.setText(name);
						c1.moveToNext();
					}
				}
			
				
			}
		});
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.addData(e1.getText().toString());
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sql_data_base, menu);
        return true;
    }
}
