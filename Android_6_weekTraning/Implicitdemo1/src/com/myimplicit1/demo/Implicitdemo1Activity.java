package com.myimplicit1.demo;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Implicitdemo1Activity extends Activity {
	Button button;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(Implicitdemo1Activity.this,SecondActivity.class);
				startActivity(intent);
				/*Intent i= new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://facebook.com/nikhilkathuria9"));
				startActivity(i);*/
			/*	Intent i1= new Intent(Intent.ACTION_SEND);
				i1.setType("text/plain");
				i1.putExtra(android.content.Intent.EXTRA_TEXT, "nnnnnnnn");
				startActivity(i1);
			*/
				
				
			}
		});
    }
}