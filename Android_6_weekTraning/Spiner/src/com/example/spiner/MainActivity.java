package com.example.spiner;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class MainActivity extends Activity {
Spinner sp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				/* parent  The AdapterView where the selection happened 
				   view  The view within the AdapterView that was clicked 
				   position  The position of the view in the adapter 
				   id  The row id of the item that is selected               */
				
				switch (position) {
				case 0:
					
					break;
					
				case 1:
					
					break;


				default:
					break;
				}
				
				
				
				
				// TODO Auto-generated method stub
				 
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
