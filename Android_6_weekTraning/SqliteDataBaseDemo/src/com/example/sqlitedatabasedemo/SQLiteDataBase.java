package com.example.sqlitedatabasedemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteDataBase extends Activity {
	EditText e1, e2;
	Button b1;
	DataBase d1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_base);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);
        d1= new DataBase(this);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				d1.addData(e1.getText().toString(), e2.getText().toString());
			System.out.println("Get Data");
			Toast.makeText(getApplicationContext(),"GetData" , Toast.LENGTH_LONG).show();
			
			
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sqlite_data_base, menu);
        return true;
    }
}
