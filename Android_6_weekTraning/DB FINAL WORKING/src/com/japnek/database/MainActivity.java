package com.japnek.database;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	EditText et1,et2,et3,et4,et5;
	Button but1,but2,dis,del;
	TextView t1,t2,t3,t4,t5;
	
	My_SqliteHelper obj=new My_SqliteHelper(this, "d.db", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        t1=(TextView) findViewById(R.id.textView1);
        t2=(TextView) findViewById(R.id.textView2);
        t3=(TextView) findViewById(R.id.textView3);
        t4=(TextView) findViewById(R.id.textView4);
        t5=(TextView) findViewById(R.id.textView5);
        
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3mail);
        et4=(EditText)findViewById(R.id.editText4address);
        et5=(EditText)findViewById(R.id.editText5phone);


        but1=(Button)findViewById(R.id.button1);
        but2=(Button)findViewById(R.id.button2);
        dis=(Button)findViewById(R.id.button3);
        del=(Button)findViewById(R.id.button4);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        dis.setOnClickListener(this);
        del.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			insertt();
			break;

		case R.id.button2:
			Intent intent=new Intent(MainActivity.this,Update.class);
			startActivity(intent);
		    break;
		case R.id.button3:
			Intent i=new Intent(MainActivity.this,Display.class);
			startActivity(i);
			break;
		case R.id.button4:
			long id=0;
			deletedataSqlite(id);
			break;
			
		}
	}

	private void deletedataSqlite(long id) {
		// TODO Auto-generated method stub
		try
		{
			SQLiteDatabase db=obj.getReadableDatabase();
			String whr="_id="+et1.getText().toString();
			db.delete(My_SqliteHelper.dtable, whr, null);
			et1.setText("");
			db.close();
		}
		catch(Exception msg)
		{
			String mag=msg.toString();
			Toast.makeText(getApplicationContext(), mag, Toast.LENGTH_LONG).show();
			Log.d("Del Exp", mag);
		}
	}

	public void insertt() {
		// TODO Auto-generated method stub
		try{
			SQLiteDatabase db=obj.getWritableDatabase();
			ContentValues cur=new ContentValues();
			cur.put(My_SqliteHelper.user,et1.getText().toString());
			cur.put(My_SqliteHelper.pass,et2.getText().toString() );
			cur.put(My_SqliteHelper.email,et3.getText().toString());
			cur.put(My_SqliteHelper.address,et4.getText().toString() );
			//cur.put(My_SqliteHelper.phone,et5.getText().toString());
			
			
			db.insert(My_SqliteHelper.dtable, null , cur);
			Toast.makeText(getApplicationContext(), "Insert Successful",Toast.LENGTH_LONG).show();
			db.close();
			et1.setText("");
			et2.setText("");
			et3.setText("");
			et4.setText("");
			et5.setText("");
		}
		catch(Exception e)
		{
			String mag=e.toString();
			Toast.makeText(getBaseContext(), mag, Toast.LENGTH_LONG).show();
			Log.d("Del Exp",mag);
		}
	}
    
}
