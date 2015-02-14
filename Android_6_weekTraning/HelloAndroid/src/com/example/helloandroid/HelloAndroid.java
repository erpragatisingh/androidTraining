package com.example.helloandroid;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;


public class HelloAndroid extends Activity {
	TextView t1;
	EditText e1;
	Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_android);
        b1=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText1);
        t1=(TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), e1.getText(), 3000).show();
			}
		});
    }

   
}
