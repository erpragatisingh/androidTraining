package ramansingh.list_view_search;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lv;
	ArrayAdapter<String> adapter;
	EditText et;
	ArrayList<HashMap<String, String>> productlist;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	String products[]={"DELL","HTC","SONY","SAMSUNG","NOKIA","MICROMAX","APPLE","MOTOROLA","WINDOWS","KARBON"};
	
	lv=(ListView) findViewById(R.id.listView1);
	et=(EditText) findViewById(R.id.editText1);
	
	//adding items to list
	adapter=new ArrayAdapter<String>(this, R.layout.newxml, R.id.pv, products);
	lv.setAdapter(adapter);
	
	//enabling search
	et.addTextChangedListener(new TextWatcher(){

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence cs	, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			MainActivity.this.adapter.getFilter().filter(cs);
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
	});
	lv.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long id) {
			// TODO Auto-generated method stub
//			parent  The AdapterView where the selection happened 
//			view  The view within the AdapterView that was clicked 
//			position  The position of the view in the adapter 
//			id  The row id of the item that is selected  

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
