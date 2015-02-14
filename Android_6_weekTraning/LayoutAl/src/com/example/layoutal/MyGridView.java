package com.example.layoutal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MyGridView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		GridView gv = (GridView) findViewById(R.id.gridview);
		gv.setAdapter(new ImageAdapter(this));

		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MyGridView.this, "" + position, Toast.LENGTH_SHORT).show();
				
				if(position==1)
				{
					startActivity(new Intent(MyGridView.this,MyDog.class));
				}
				
			}
		});

	}
}
