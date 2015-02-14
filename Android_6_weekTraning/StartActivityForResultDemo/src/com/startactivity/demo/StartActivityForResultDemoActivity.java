package com.startactivity.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivityForResultDemoActivity extends Activity {
	Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(StartActivityForResultDemoActivity.this,SecondActivity.class);
				startActivityForResult(intent, 10);
	//			startActivity(intent);
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			System.out.println(requestCode);
			System.out.println(resultCode);
			Bundle extras = data.getExtras();
			String value = extras.getString("mydata");
			String value2 = extras.getString("mydata2");
			System.out.println(value);
			System.out.println(value2);
			
		}
    }
}