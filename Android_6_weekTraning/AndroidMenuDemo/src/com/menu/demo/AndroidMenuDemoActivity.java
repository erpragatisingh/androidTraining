package com.menu.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class AndroidMenuDemoActivity extends Activity {
	Button button;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		registerForContextMenu(button);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(0, 1, 0, "A");
		menu.add(0, 2, 0, "B");
		menu.add(0, 3, 0, "C");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(getApplicationContext(), "A", 3000).show();
			break;
		case 2:
			Toast.makeText(this, "B", 3000).show();
			break;
		case 3:
			Toast.makeText(this, "C", 3000).show();
			break;

		default:
			break;
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem add1 = menu.add(0, 1, 0, "A");
		add1.setIcon(R.drawable.icon);
		MenuItem add2 = menu.add(0, 2, 0, "B");
		add2.setIcon(R.drawable.icon);
		menu.add(0, 3, 0, "C");
		// menu.add(0, 4, 0, "D");
		SubMenu addSubMenu = menu.addSubMenu(0, 4, 0, "D");
		// addSubMenu.add(groupId, itemId, order, titleRes)
		SubMenu subMenu = menu.addSubMenu(0, 5, 0, "Sub menu");
		subMenu.add(0, 6, 0, "Sub 1");
		subMenu.add(0, 7, 0, "Sub 2");
		subMenu.add(0, 8, 0, "Sub 3");
		// MenuInflater menuInflater = getMenuInflater();
		// menuInflater.inflate(R.menu.my_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
			// finish();
			break;
		case R.id.item2:
			Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item3:
			Toast.makeText(this, "C", Toast.LENGTH_SHORT).show();
			break;
		case R.id.item4:
			Toast.makeText(this, "D", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
		return true;
	}

}