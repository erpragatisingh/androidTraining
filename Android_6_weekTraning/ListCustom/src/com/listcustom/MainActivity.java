package com.listcustom;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView l1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wtho w1[]= new Wtho[]{
        		
        		new Wtho(R.drawable.ic_launcher, "AAAAAAA"), new Wtho(R.drawable.ic_launcher, "NNNNN")
        		
        };
        Wadap adapter = new Wadap(this, 
                R.layout.listrow, w1);
        
        
        l1 = (ListView)findViewById(R.id.listView1);
         
        l1.setAdapter(adapter);
        l1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "FOOOOOOO", 3000).show();
			}
		});
    }
    
    }