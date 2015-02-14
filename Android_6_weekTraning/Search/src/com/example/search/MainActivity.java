package com.example.search;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	ArrayAdapter<String> adapter;
	EditText e;
	ArrayList<HashMap<String,String>> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String products[]={"Dell","HTC One","Wildfire S","Htc Sense","iPhone4S","Samsung S duos","GalaxyNote","MacBook"};
        
        lv=(ListView)findViewById(R.id.listView1);
        e=(EditText)findViewById(R.id.editText1);
        adapter=new ArrayAdapter<String>(this, R.layout.newlay, R.id.textView1,products);
        lv.setAdapter(adapter);
        
        e.addTextChangedListener(new TextWatcher()
        {

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				MainActivity.this.adapter.getFilter().filter(cs);
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
