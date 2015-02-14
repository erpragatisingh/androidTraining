package ramansingh.newdatabase;

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
import android.widget.Toast;

public class MainActivity extends Activity {
EditText e1,e2,e3;
Button b1,b2;
MYsqllitehlper obj=new MYsqllitehlper(this, "MyDb.db", null, 1, null);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);

		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				insert();
				
			}

			private void insert() {
				// TODO Auto-generated method stub
				try{
					SQLiteDatabase db=obj.getWritableDatabase();
					ContentValues cur=new ContentValues();
					cur.put(MYsqllitehlper.key_day,e1.getText().toString());
					cur.put(MYsqllitehlper.key_work1,e2.getText().toString() );
					cur.put(MYsqllitehlper.key_work2,e3.getText().toString() );

					db.insert(MYsqllitehlper.table_name, null, cur);
					Toast.makeText(getApplicationContext(), "Insert Successful",Toast.LENGTH_LONG).show();
					db.close();
					e1.setText("");
					e2.setText("");
					e3.setText("");
					
				}
				catch(Exception e)
				{
					String mag=e.toString();
					Toast.makeText(getBaseContext(), mag, Toast.LENGTH_LONG).show();
					Log.d("Del Exp",mag);
				}
			}
		});
		
		
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(MainActivity.this,Disp.class);
				startActivity(i);
				
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
