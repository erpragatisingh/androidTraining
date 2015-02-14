package ishan.bhatnagar;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity{

	Button register,log;
	EditText nam,pas;
	Helpere hlp=new Helpere(this, "agro.db", null, 1);
	/*SQLiteDatabase db;*/
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		register=(Button) findViewById(R.id.reg);
		log=(Button) findViewById(R.id.log);
		nam=(EditText) findViewById(R.id.farmer);
		pas=(EditText) findViewById(R.id.pass);
		
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View a) {
				// TODO Auto-generated method stub
				String namee=nam.getText().toString();
				String pwd=pas.getText().toString();
				String storedPassword=getsingleentry(namee);
				if(pwd.equals(storedPassword))
				{
					Toast.makeText(Login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
					Intent lo=new Intent(Login.this,Crop.class);
					startActivity(lo);
				}
				else
				{
					Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				}
			}
		});
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent rg=new Intent(Login.this,Register.class);
				startActivity(rg);
			}
		});
	}
	public String getsingleentry(String namee){
		SQLiteDatabase db=hlp.getReadableDatabase();
		Cursor cu=db.query("farmer",null,"name=?",new String[]{namee}, null,null,null);
		if(cu.getCount()<1)
		{
			cu.close();
			return "not exist";
		}
		cu.moveToFirst();
		String pass=cu.getString(cu.getColumnIndex("pass"));
		cu.close();
		return pass;
	}
}
