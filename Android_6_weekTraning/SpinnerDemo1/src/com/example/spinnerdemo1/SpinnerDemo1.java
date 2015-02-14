package com.example.spinnerdemo1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerDemo1 extends Activity {
	Spinner s1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo1);
        s1=(Spinner)findViewById(R.id.spinner1);
     String[] s11= new String[]{"A", "B","C","D","E"};
     ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, s11);
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		ArrayAdapter a1= ArrayAdapter.createFromResource(this, R.array.Elements, android.R.layout.simple_spinner_item);
		a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        s1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_spinner_demo1, menu);
        return true;
    }
}
