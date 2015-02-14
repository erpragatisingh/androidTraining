package com.datapassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DataPassingByIntentsActivity extends Activity {
	Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(DataPassingByIntentsActivity.this, SecondActivity.class);
				MyClass myClass = new MyClass();
				myClass.setName("ABC");
				myClass.setPassword("XYZ");
				intent.putExtra("myKey", "Miracle Tech. Noida");
				intent.putExtra("myKey1", "Miracle Tech. Noida 1");
				intent.putExtra("myKey2", "Miracle Tech. Noida 2");
//				intent.putExtra("MyClassObj", myClass);
				startActivity(intent);
			}
		});
    }
}