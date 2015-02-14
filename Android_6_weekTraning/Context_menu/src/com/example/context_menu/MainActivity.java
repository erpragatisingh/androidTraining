package com.example.context_menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	b1=(Button) findViewById(R.id.button1);
	b1.setOnCreateContextMenuListener(this);
	
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		CreateMenu(menu);
		
	}


	private void CreateMenu(ContextMenu menu) {
		// TODO Auto-generated method stub
		MenuItem mnu1= menu.add(0, 0, 0, "item1");
		/*The group id entifier that this item should be part of. This can be used to define groups of items for batch state changes. Normally use NONE if an item should not be in a group. 
		itemId  Unique item ID. Use NONE if you do not need a unique ID. 
		order  The order for the item. Use NONE if you do not care about the order. See getOrder(). 
		title  The text to display for the item. */

		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);
			
		}
		
		MenuItem m2=menu.add(0, 1, 1, "item2");
		{
			m2.setAlphabeticShortcut('b');
			m2.setIcon(R.drawable.ic_launcher);
			
		}
		MenuItem m3=menu.add(0, 2, 2, "item3");
		{
			m3.setAlphabeticShortcut('c');
			m3.setIcon(R.drawable.ic_launcher);
			
		}
		MenuItem m4=menu.add(0, 2, 2, "item4");
		{
			m4.setAlphabeticShortcut('d');
		
			
		}
		menu.add(0, 3, 3, "Item5");
		menu.add(0, 3, 3, "Item6");
		menu.add(0, 3, 3, "Item7");
		}
private boolean MenuChoice(MenuItem item){
	switch (item.getItemId()) {
	case 0:
		Toast.makeText(this, "you clicked 1", 3000).show();
		
		return true;
		
	case 1:
		Toast.makeText(this, "you clicked 2", 3000).show();
		
		return true;

		
	case 2:
		Toast.makeText(this, "you clicked 3", 3000).show();
		
		return true;

		
	case 3:
		Toast.makeText(this, "you clicked 4", 3000).show();
		
		return true;


	case 4:
		Toast.makeText(this, "you clicked 5", 3000).show();
		
		return true;

	case 5:
		Toast.makeText(this, "you clicked 6", 3000).show();
		
		return true;

	case 6:
		Toast.makeText(this, "you clicked 7", 3000).show();
		
		return true;

	
	}
	return true;
	
}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return MenuChoice(item) ;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
