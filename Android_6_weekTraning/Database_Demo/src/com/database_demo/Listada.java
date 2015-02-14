package com.database_demo;






import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Listada extends ListActivity{
	data d11;
	Cursor cc;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.list123);
		 d11= new data(this);
		 cc= d11.getData();
		/* ListView l1= (ListView)findViewById(R.id.listView1);
		 Adap apap= new Adap(this, cc);
			l1.setAdapter(apap);*/
		 
		 setListAdapter(new Adap(this, cc));
		 ListView listView = getListView();
	}
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String str = Long.toString(id);
		Intent intent = new Intent(this, second.class);
		intent.putExtra("name", str);
		System.out.println(str);
		startActivity(intent);
		// finish();

	}

}
	



