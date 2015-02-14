package com.intentdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class IntentDemo extends Activity {
	Button mb1;
	EditText e1, e2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);
        mb1=(Button)findViewById(R.id.button1);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        Intent i= new Intent(this, Second.class);
        
        mb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				Intent i= new Intent(IntentDemo.this, Second.class);
				i.putExtra("name", e1.getText().toString());
				i.putExtra("Pass", e2.getText().toString());
				startActivity(i);
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_intent_demo, menu);
        return true;
    }
}
