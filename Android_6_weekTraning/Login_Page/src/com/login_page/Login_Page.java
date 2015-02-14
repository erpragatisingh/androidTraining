package com.login_page;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Page extends Activity {
	TextView t1, t2;
	EditText e1, e2;
	Button b1;
	Intent i;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login__page);
	t1=(TextView)findViewById(R.id.textView1);
	t2=(TextView)findViewById(R.id.textView3);
	e1=(EditText)findViewById(R.id.editText1);
	e2=(EditText)findViewById(R.id.editText2);
	b1=(Button)findViewById(R.id.button1);
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();
			i= new Intent(Login_Page.this,second.class);
			startActivity(i);
		}
	});
	
}
}
