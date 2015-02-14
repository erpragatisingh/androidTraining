package com.japnek.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends Activity {

	Button button;
	EditText t1,t2,t3;
	My_SqliteHelper obj=new My_SqliteHelper(this, "dba.db", null, 1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		t1=(EditText)findViewById(R.id.edit1);
		t2=(EditText)findViewById(R.id.edit2);
		t3=(EditText)findViewById(R.id.edit3);
		button=(Button)findViewById(R.id.but1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				long id=0;
				update(id);
			}

			private void update(long id) {
				// TODO Auto-generated method stub
				try
				{
					SQLiteDatabase db=obj.getReadableDatabase();
					ContentValues cv=new ContentValues();
					cv.put(My_SqliteHelper.user, t2.getText().toString());
					cv.put(My_SqliteHelper.pass, t3.getText().toString());
					String whr="_id="+t1.getText().toString();
					db.update(My_SqliteHelper.dtable, cv, whr, null);
					Toast.makeText(getApplicationContext(), "Update Successful", Toast.LENGTH_LONG).show();
				}
				catch(Exception e)
				{
					String Exp_msg=e.toString();
					Toast.makeText(getApplicationContext(), Exp_msg, Toast.LENGTH_LONG).show();
				}
			}
		});
		
	}
}
