package com.example.tabsjapnek;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();
        
        // Tab for Photos
        TabSpec photospec = tabHost.newTabSpec("Monday");
        photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.speak48));
        // setting Title and Icon for the Tab
        Intent photosIntent = new Intent(this, Monday.class);
        photospec.setContent(photosIntent);
         
        // Tab for Songs
        TabSpec songspec = tabHost.newTabSpec("Tues");  
        photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.speak48));
        Intent songsIntent = new Intent(this, Tuesday.class);
        songspec.setContent(songsIntent);
         
        // Tab for Videos
        TabSpec videospec = tabHost.newTabSpec("Wed");
        photospec.setIndicator("Photos", getResources().getDrawable(R.drawable.speak48));
        Intent videosIntent = new Intent(this, Wednesday.class);
        videospec.setContent(videosIntent);
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
        tabHost.addTab(videospec); // Adding videos tab
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
