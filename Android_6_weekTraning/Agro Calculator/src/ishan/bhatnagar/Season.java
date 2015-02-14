package ishan.bhatnagar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Season extends Activity{

	Button bs;
	ListView lv;
	String[] season;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.season);
		bs=(Button) findViewById(R.id.bs);
		bs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent we=new Intent(Season.this,Weather.class);
				startActivity(we);
			}
		});
		lv=(ListView) findViewById(R.id.listsea);
		lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.season)));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int a2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (a2) {
				case 0:
					Toast.makeText(getApplicationContext(), "winter selected", Toast.LENGTH_LONG).show();
					Intent win=new Intent(Season.this,Weather.class);
					win.putExtra("str1", "winter");
					startActivity(win);
					break;
				case 1:
					Toast.makeText(getApplicationContext(), "summer selected", Toast.LENGTH_LONG).show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(), "spring selected", Toast.LENGTH_LONG).show();
					break;	
				case 3:
					Toast.makeText(getApplicationContext(), "Rainy selected", Toast.LENGTH_LONG).show();
					break;	
				default:
					break;
				}
			}
			
		});
		
	}

}
