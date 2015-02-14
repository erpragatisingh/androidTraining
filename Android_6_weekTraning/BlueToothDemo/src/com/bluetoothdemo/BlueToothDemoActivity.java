package com.bluetoothdemo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BlueToothDemoActivity extends Activity {
	Button button, button2, button3;
	BluetoothAdapter bluetoothAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter == null) {
			Toast.makeText(this, "No BT support", Toast.LENGTH_LONG).show();
		}
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (!bluetoothAdapter.isEnabled()) {
					Toast.makeText(BlueToothDemoActivity.this,
							"BT not enabled", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(	BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivityForResult(intent, 0);
				}
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (!bluetoothAdapter.isDiscovering()) {
					Intent intent = new Intent(
							BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
					startActivityForResult(intent, 0);
				}
			}
		});

		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if (bluetoothAdapter.isEnabled()) {
					Toast.makeText(BlueToothDemoActivity.this,
							"Turning off BT", Toast.LENGTH_LONG).show();
					bluetoothAdapter.disable();
				}
			}
		});

	}
}