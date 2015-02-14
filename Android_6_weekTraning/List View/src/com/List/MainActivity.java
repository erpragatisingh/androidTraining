package com.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView mlist;
	TextView mtext;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlist=(ListView)findViewById(R.id.listView1);
        String[] a1= new String[]{"Delhi","Mumbai","Pune","Banglore"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a1);
        mlist.setAdapter(adapter);
        mlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Object s1= new String("2");
				Object s2= new String("2");
				if(s1==s2){
					System.out.println(66);
				}
				if(s1.equals(s2)){
					System.out.println(77);
				}
				
				// TODO Auto-generated method stub
				Intent i= new Intent(MainActivity.this, second.class);
				//String s1= Long.toString(id);
				String s12= parent.getItemAtPosition(position).toString();
				int a1= parent.getPositionForView(view);
				i.putExtra("name78", s12);
				i.putExtra("pass", a1);
				System.out.println(1+new String("2")+3);
				System.out.println(1+3);
				startActivity(i);
				
				Toast.makeText(getApplicationContext(), String.valueOf(position)+" Hello  "+((TextView)view).getText().toString(),Toast.LENGTH_SHORT).show();
			}
		});
        
        
    }

  
}
