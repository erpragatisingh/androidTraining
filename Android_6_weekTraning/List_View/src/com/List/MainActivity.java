package com.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView mtext;
	ListView mlist;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mtext=(TextView)findViewById(R.id.textView1);
        mlist=(ListView)findViewById(R.id.listView1);
        String[] a1= new String[]{"Delhi","Mumbai","Banglore","Manglore"};
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, a1);
        mlist.setAdapter(adapter);
        mlist.setOnItemClickListener(new OnItemClickListener() {

			@SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				// TODO Auto-generated method stub
				 final String item = (String) parent.getItemAtPosition(position);
			        view.animate().setDuration(2000).alpha(1).rotation(0)
			            .withEndAction(new Runnable() {
			              
			              public void run() {
			               // list.remove(item);
			            //    adapter.notifyDataSetChanged();
			                view.setAlpha(1);
			                view.setRotation(360);
			                view.setBackgroundColor(Color.BLUE);
			                
			              }
			            
			//	Toast.makeText(getApplicationContext(), ((TextView)abc).getText(), 3000).show();
				
			            });
			}
        });
			        
        
			    
    }

   
}