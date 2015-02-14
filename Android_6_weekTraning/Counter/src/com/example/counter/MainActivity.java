package com.example.counter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b;
	TextView t;
	Toast tt;
	int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.textView1);
        b=(Button)findViewById(R.id.button1);
    }

    public void counter(View v)
    {
    	c++;
    	t.setText("Counter= "+c);
    	tt.makeText(this, "Button pressed"+" "+c+" "+"times", Toast.LENGTH_LONG).show();
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
