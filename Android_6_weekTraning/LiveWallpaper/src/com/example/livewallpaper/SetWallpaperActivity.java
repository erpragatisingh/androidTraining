package com.example.livewallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetWallpaperActivity extends Activity {
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_live_wallpaper);
	  }

	  public void onClick(View view) {
	    Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
	    intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
	        new ComponentName(this, MyWallpaperService.class));
	    startActivity(intent);
	  }
	  public void onWallpaperSettings(View view) {
		    Intent wallpaperSettings = new Intent(Intent.ACTION_SET_WALLPAPER);
		    startActivity(wallpaperSettings);
		}
	} 
