package com.exaple.impliintentp;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
 ImageButton fb,call,cam;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	fb=(ImageButton) findViewById(R.id.imageBuFB)	;
	call=(ImageButton) findViewById(R.id.imageButton1)	;
	cam=(ImageButton) findViewById(R.id.imageButton3)	;
	cam.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				Intent fb=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivity(fb);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Action can't be handaled", Toast.LENGTH_LONG);
			}
		}
	});
	call.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent fb=new Intent(Intent.ACTION_CALL_BUTTON);
			startActivity(fb);
		}
	});
	fb.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent fb=new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.facebook.com"));
			startActivity(fb);
			
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

public void AudioRecord(View v) {
	
	Intent i=new Intent(Media.RECORD_SOUND_ACTION);
	startActivity(i);
	
	
}



public void AudioPlayer(View v) {
	
	@SuppressWarnings("deprecation")
	Intent i=new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
	startActivity(i);
	
	
}

}
