package com.splash;

import java.util.Calendar;
import java.util.List;
import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
@SuppressWarnings("unused")
public class MainScreen extends ListActivity {

	TextView textView;
	Manager manager;
	Cursor c;
	LinearLayout layout;
	TextView textView2;
	Button button;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.mainscreen);
		manager = new Manager(this);
		c = manager.getRow();

	//	setContentView(R.layout.mainscreen);
		setListAdapter(new abc(this, c));

		ListView listView = getListView();
	//	registerForContextMenu(listView);*/

		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainScreen.this, AddTask.class);
				startActivity(intent);
				// MainScreen.this.finish();

			}
		});

		ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainScreen.this, Welcome.class);
				startActivity(intent);
				// MainScreen.this.finish();

			}
		});

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String str = Long.toString(id);
		Intent intent = new Intent(this, Detail.class);
		intent.putExtra("name", str);
		startActivity(intent);
		// finish();

	}

		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mymenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.item1:
			// Toast.makeText(this, "Add Task", 1000).show();
			intent = new Intent(this, AddTask.class);
			startActivity(intent);
			// finish();

			break;
		case R.id.item2:
			// Toast.makeText(this, "Delete All", 1000).show();

			manager.deleteRow();
			intent = new Intent(this, MainScreen.class);
			startActivity(intent);
			finish();
			break;

		case R.id.item3:
			// Toast.makeText(this, "Info.", 1000).show();
			intent = new Intent(this, Welcome.class);
			startActivity(intent);
			// finish();
			break;
		case R.id.item4:
			Toast.makeText(this, "Press Home", 1000).show();
			// finish();
			break;
		default:
			break;
		}

		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		menu.add(0, 1, 0, "Edit Task");
		menu.add(0, 2, 0, "Delete Task");
		menu.add(0, 3, 0, "Change Priority");
		menu.add(0, 4, 0, "Postpone Task");
		menu.add(0, 5, 0, "Mark As Done/Undone");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		Intent intent;
		switch (item.getItemId()) {
		case 1:
			// Toast.makeText(this, "Edit Task", 1000).show();
			intent = new Intent(this, Update.class);
			intent.putExtra("name", Long.toString(info.id));
			startActivity(intent);
			// finish();
			break;
		case 2:
			// Toast.makeText(this, "Delete Task", 1000).show();
			manager.deleteRow(info.id);
			intent = new Intent(this, MainScreen.class);
			startActivity(intent);
			finish();

			break;
		case 3:
			// Toast.makeText(this, "Change Priority", 1000).show();
			intent = new Intent(this, Update.class);
			intent.putExtra("name", Long.toString(info.id));
			startActivity(intent);
			// finish();
			break;
		case 4:

			// Toast.makeText(this, "Postpone Task", 1000).show();
			intent = new Intent(this, Update.class);
			intent.putExtra("name", Long.toString(info.id));
			startActivity(intent);
			// finish();
			break;
		case 5:
			// Toast.makeText(this, "Mark As Done/Undone", 1000).show();
			c.moveToPosition(info.position);
			String str = c.getString(5);
			if (str.equals("done")) {
				manager.updateDone(info.id, "undone");
			} else {
				manager.updateDone(info.id, "done");
			}

			intent = new Intent(this, MainScreen.class);
			startActivity(intent);
			// finish();
			break;
		default:
			break;
		}
		return true;
	}

}
