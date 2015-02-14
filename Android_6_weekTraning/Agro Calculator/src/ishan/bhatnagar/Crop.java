package ishan.bhatnagar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Crop extends Activity{

	ListView lv1;
	Button st;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crop);
		st=(Button) findViewById(R.id.crops);
		st.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View vw) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Crop.this,Season.class);
				startActivity(i);
			}
		});
		lv1=(ListView) findViewById(R.id.listView2);
		lv1.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.Crop)));
		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int i2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (i2) {
				case 0:
					Toast.makeText(getApplicationContext(), "Tea Crop selected", Toast.LENGTH_SHORT).show();
					Intent t=new Intent(Crop.this,Season.class);
					t.putExtra("str", "tea");
					startActivity(t);
					break;
				case 1:
					Toast.makeText(getApplicationContext(), "Coffee Crop selected", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(), "Cabbages Crop selected", Toast.LENGTH_SHORT).show();
					break;	
				case 3:
					Toast.makeText(getApplicationContext(), "Onion selected", Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(getApplicationContext(), "Potatoes Crop selected", Toast.LENGTH_SHORT).show();
					break;	
				case 5:
					Toast.makeText(getApplicationContext(), "Wheat Crop selected", Toast.LENGTH_SHORT).show();
					break;		
				default:
					break;
				}
			}

			
		});
	}

}
