package com.mahesh.mydbluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {

	private ToggleButton tb;
	private BluetoothAdapter bl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Ui();
	}

	public void Ui() {

		tb = (ToggleButton) findViewById(R.id.tb);
		tb.setOnClickListener(this);
		bl = BluetoothAdapter.getDefaultAdapter();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		if (v == tb) {

			if ((tb.isChecked())) {
				try {
					bl.enable();

				} catch (Exception e) {

				}

			} else {
				try {

					bl.disable();
				} catch (Exception ee) {

				}

			}

		}

	}

}
