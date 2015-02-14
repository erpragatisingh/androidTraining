package com.btdemo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BTtestActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final TextView out=(TextView)findViewById(R.id.out);
		final Button button = (Button) findViewById(R.id.button1);
		final Button button1 = (Button) findViewById(R.id.button2);
		final Button button2 = (Button) findViewById(R.id.button3);
		final BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (mBluetoothAdapter == null) {
			out.append("device not supported");
		}
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (!mBluetoothAdapter.isEnabled()) {
					Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(enableBtIntent, 0);
				}
			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (!mBluetoothAdapter.isDiscovering()) {
					Context context = getApplicationContext();
					Toast.makeText(context, "MAKING YOUR DEVICE DISCOVERABLE", Toast.LENGTH_SHORT).show();
					Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
					startActivityForResult(enableBtIntent, 0);
				}
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {    
				mBluetoothAdapter.disable();
				Context context = getApplicationContext();
				Toast.makeText(context, "TURNING_OFF BLUETOOTH", Toast.LENGTH_LONG).show();
			}
		});
	}
}