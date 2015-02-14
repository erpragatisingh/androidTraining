package com.example.live2;



import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Live extends Activity{
	 protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_live2);
		  }

		  public void onClick(View view) {
		    Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
		    intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
		        new ComponentName(this, Live2.class));
		    System.out.println("AAA");
		    startActivity(intent);
		  }

}
