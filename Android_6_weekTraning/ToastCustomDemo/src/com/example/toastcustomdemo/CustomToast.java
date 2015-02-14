package com.example.toastcustomdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);
        showToast("Hello from Android");
    }

    public void showToast(String message) {
		// TODO Auto-generated method stub
		LayoutInflater l1= getLayoutInflater();
		View v1= l1.inflate(R.layout.custom, null);
		ImageView i1= (ImageView)v1.findViewById(R.id.imageView1);
		TextView t1= (TextView)v1.findViewById(R.id.textView1);
		i1.setImageResource(R.drawable.ic_launcher);
		t1.setText(message);
		Toast t12= new Toast(getApplicationContext());
		t12.setDuration(Toast.LENGTH_LONG);
		t12.setGravity(Gravity.BOTTOM, 12, 10);
		t12.setView(v1);
		t12.show();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_custom_toast, menu);
        return true;
    }
}
