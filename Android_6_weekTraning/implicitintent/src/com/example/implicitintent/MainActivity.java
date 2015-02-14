package com.example.implicitintent;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
	//	Intent i = new Intent(android.provider.MediaStore.Audio.Media.RECORD_SOUND_ACTION);
 
		
		
		 Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.java.com"));
		startActivity(i);
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	public void Mcamera() {
		Intent a=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivity(a);
		
	}
	
	public void Song() {
		Intent a=new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
		startActivity(a);
	}

}
