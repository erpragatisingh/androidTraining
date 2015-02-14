package com.japnek.customtoast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			LayoutInflater inf=getLayoutInflater();
			View tlayout=inf.inflate(R.layout.tost, (ViewGroup)findViewById(R.id.LinearLayout1));
			TextView tv=(TextView)tlayout.findViewById(R.id.textView1);
			tv.setText("Dear All");
			Toast tst=new Toast(getApplicationContext());
			tst.setGravity(Gravity.CENTER_VERTICAL, 10, 10);
			tst.setDuration(Toast.LENGTH_LONG);
			tst.setView(tlayout);
			tst.show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
