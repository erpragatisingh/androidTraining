package rinkle.test.androidtablayoutactivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_main);
		TabHost tabhost=getTabHost();
		
		//tab for photos
		TabSpec photospec = tabhost.newTabSpec("Photos");
		photospec.setIndicator("Photos",getResources().getDrawable(android.R.drawable.ic_dialog_alert));
		Intent photosIntent=new  Intent(this,PhotosActivity.class);
		photospec.setContent(photosIntent);
		
		//tab for songs
		TabSpec songspec=tabhost.newTabSpec("Songs");
		//setting title and icon for tab
		songspec.setIndicator("Songs",getResources().getDrawable(android.R.drawable.ic_dialog_dialer));
		Intent songsIntent=new Intent(this,SongsActivity.class);
		songspec.setContent(songsIntent);
		
		//tab for videos
		TabSpec videospec=tabhost.newTabSpec("Videos");
		videospec.setIndicator("Videos", getResources().getDrawable(android.R.drawable.ic_dialog_email));
		Intent videosIntent=new Intent(this,VideosActivity.class);
		videospec.setContent(videosIntent);
		
		//adding all tabspec to tabhost
		tabhost.addTab(photospec);
		tabhost.addTab(songspec);
		tabhost.addTab(videospec);
		
	}

 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
