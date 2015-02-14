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

public class Weather extends Activity
{
	ListView lv;
	Button crop;
	String[] weath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		lv=(ListView) findViewById(R.id.listView1);
		/*weath=getResources().getStringArray(R.array.Weath);*/
		crop=(Button) findViewById(R.id.crop);
		crop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Weather.this,Fetching.class);
				startActivity(i);
				
			}
		});
		lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Weath)));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int i,
					long arg3) {
				// TODO Auto-generated method stub
				switch (i) {
				case 0:
					Toast.makeText(getApplicationContext(), "Temperature for this crop", Toast.LENGTH_SHORT).show();
					Intent ii=new Intent(Weather.this,Weatherpara.class);
					ii.putExtra("str2", "Temperature");
					startActivity(ii);
					break;
				case 1:
					Toast.makeText(getApplicationContext(), "Rainfall for this crop", Toast.LENGTH_SHORT).show();
					/*Intent i1=new Intent(Weather.this,Fetching.class);
					i1.putExtra("str1", "Rainfall");
					startActivity(i1);*/
					break;
				case 2:
					Toast.makeText(getApplicationContext(), "Humidity for this crop", Toast.LENGTH_SHORT).show();
					/*Intent i2=new Intent(Weather.this,Fetching.class);
					i2.putExtra("str2", "Humidity");
					startActivity(i2);*/
					break;
				case 3:
					Toast.makeText(getApplicationContext(), "Evaporation for this crop", Toast.LENGTH_SHORT).show();
					/*Intent i3=new Intent(Weather.this,Fetching.class);
					i3.putExtra("str3", "Evaporation");
					startActivity(i3);*/
					break;	
				default:
					break;
				}
			}
			
		});
		
	}

}
