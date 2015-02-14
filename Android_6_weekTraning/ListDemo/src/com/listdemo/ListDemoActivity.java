package com.listdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListDemoActivity extends Activity {
	ListView listView;
	String[] dataStrings = {"A","B","C","D","E","F","G","H","I","J","K","L"};
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		listView = (ListView)findViewById(R.id.listView);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataStrings);
		listView.setAdapter(arrayAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String itemAtPosition = parent.getItemAtPosition(position).toString();
				int a1= parent.getPositionForView(view);
				System.out.println(a1);
			
				Toast.makeText(ListDemoActivity.this, itemAtPosition, 3000).show();
			}
		});
	}
}