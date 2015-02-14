package ishan.bhatnagar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends Activity{
	Helpere hlp=new Helpere(this, "agro.db", null, 1);
	EditText ed,ed1,ed2,ed3;
	Button b,dis;
	RadioGroup rd;
	RadioButton rb;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		ed=(EditText) findViewById(R.id.editText1);
		ed1=(EditText) findViewById(R.id.editText2);
		ed2=(EditText) findViewById(R.id.editText3);
		ed3=(EditText) findViewById(R.id.editText4);
		b=(Button) findViewById(R.id.button1);
		dis=(Button) findViewById(R.id.display);
		rd=(RadioGroup) findViewById(R.id.ragp);
		dis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View ar) {
				// TODO Auto-generated method stub
				Intent dis=new Intent(Register.this,Display.class);
				startActivity(dis);
			}
		});
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				insertion();
			}
		});
	}
	public void insertion(){
		try{
		int selectid=rd.getCheckedRadioButtonId();
		rb=(RadioButton) findViewById(selectid);
		SQLiteDatabase sb=hlp.getWritableDatabase();
		ContentValues cn=new ContentValues();
		cn.put(Helpere.name, ed.getText().toString());
		cn.put(Helpere.lastname, ed1.getText().toString());
		cn.put(Helpere.pass, ed2.getText().toString());
		cn.put(Helpere.email, ed3.getText().toString());
		cn.put(Helpere.sex, rb.getText().toString());
		sb.insert(Helpere.table, null, cn);
		Toast.makeText(getApplicationContext(), "Thank you for your participation.....you registered successfully", Toast.LENGTH_SHORT).show();
		ed.setText("");
		ed1.setText("");
		ed2.setText("");
		ed3.setText("");
		sb.close();
		finish();//it is used to destroy current activity and move to last activity//
		
		startActivity( new Intent(this,Thanks.class));
		
		
		
		}
		catch(Exception e){
			String m=e.toString();
			Toast.makeText(getApplicationContext(),m,Toast.LENGTH_LONG).show();
		}	
		}
	}

