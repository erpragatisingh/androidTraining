package com.example.impintent;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ImpIntent extends Activity {
	Button b1, b2, b3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_intent);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.facebook.com"));
				startActivity(i);
			}
		});
        
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel://012345678"));
				startActivity(i);
				
			}
		});
        
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent( MediaStore.INTENT_ACTION_MUSIC_PLAYER);
				startActivity(i);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_imp_intent, menu);
        return true;
    }
}
