package ramansingh.personaldairy;


import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Insertcontacts extends Activity {
	
	
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
	EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11;
	Button b1;
	My_SqliteHelper obj=new My_SqliteHelper(this, "dbb.db", null, 1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertcontacts);
		
		
		 t1=(TextView) findViewById(R.id.textView1);
	        t2=(TextView) findViewById(R.id.textView2);
	        t3=(TextView) findViewById(R.id.textView3);
	        t4=(TextView) findViewById(R.id.textView4);
	        t5=(TextView) findViewById(R.id.textView5);
	        t6=(TextView) findViewById(R.id.textView6);
	        t7=(TextView) findViewById(R.id.textView7);
	        t8=(TextView) findViewById(R.id.textView8);
	        t9=(TextView) findViewById(R.id.textView9);
	        t10=(TextView) findViewById(R.id.textView10);
	        t11=(TextView) findViewById(R.id.textView11);
	        t12=(TextView) findViewById(R.id.textView12);
	        t13=(TextView) findViewById(R.id.textView13);
	        
	        
	        et1=(EditText)findViewById(R.id.editText_name);
	        et2=(EditText)findViewById(R.id.editText_adres);
	        et3=(EditText)findViewById(R.id.editph_m);
	        et4=(EditText)findViewById(R.id.editph_r);
	        et5=(EditText)findViewById(R.id.emailid); 
	        et6=(EditText)findViewById(R.id.ecompanyname);
	        et7=(EditText)findViewById(R.id.ecomaddrss);
	        et8=(EditText)findViewById(R.id.ecompphn);
	        et9=(EditText)findViewById(R.id.efax); 
	        et10=(EditText)findViewById(R.id.enotes);
	      
	        
	        b1=(Button) findViewById(R.id.buttinsertdata);
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					insert();
				}

				public void insert() {
					// TODO Auto-generated method stub
					
							try{
				    			SQLiteDatabase db=obj.getWritableDatabase();
				    			ContentValues cur=new ContentValues();
				    			cur.put(My_SqliteHelper.name,et1.getText().toString());
				    			cur.put(My_SqliteHelper.address,et2.getText().toString() );
				    			cur.put(My_SqliteHelper.phonenumm,et3.getText().toString());
				    			cur.put(My_SqliteHelper.phonenumr,et4.getText().toString() );
				    			cur.put(My_SqliteHelper.email,et5.getText().toString());
				    			cur.put(My_SqliteHelper.compname,et6.getText().toString() );
				    			cur.put(My_SqliteHelper.compaddress,et7.getText().toString());
				    			cur.put(My_SqliteHelper.compphone,et8.getText().toString() );	    			
				    		//	cur.put(My_SqliteHelper.compfax,et9.getText().toString());
				    			cur.put(My_SqliteHelper.cnote,et10.getText().toString() );
				    			
				    			db.insert(My_SqliteHelper.table1, null , cur);
				    			Toast.makeText(getApplicationContext(), "Insert Successful",Toast.LENGTH_LONG).show();
				    			db.close();
				    			et1.setText("");
				    			et2.setText("");
				    			et3.setText("");
				    			et4.setText("");
				    			et5.setText("");
				    			
				    			et6.setText("");
				    			et7.setText("");
				    			et8.setText("");
				    			et9.setText("");
				    			et10.setText("");
				    			
				    			
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