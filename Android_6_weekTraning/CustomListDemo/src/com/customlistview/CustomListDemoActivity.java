package com.customlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class CustomListDemoActivity extends Activity {
	ListView listView;
	String[] data1 = {"A","B","C","D","E","F","G","A","B","C","D","E","F","G","A","B","C","D","E","F","G"};
	String[] data2 = {"AA","BB","CC","DD","EE","FF","GG","AA","BB","CC","DD","EE","FF","GG","AA","BB","CC","DD","EE","FF","GG"};
	
	Adap adapter;
//	MyCustomAdapter adapter;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView)findViewById(R.id.list);
       adapter= new Adap(this, data1, data2);
     //   adapter = new MyCustomAdapter(this, data1, data2);
        listView.setAdapter(adapter);
    }
}