package com.example.livewallpaper;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.widget.Toast;

public class MyPreferencesActivity extends PreferenceActivity {
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    addPreferencesFromResource(R.xml.prefs);

	    // We want to add a validator to the number of circles so that it only
	    // accepts numbers
	    Preference circlePreference = getPreferenceScreen().findPreference("numberOfCircles");

	    // Add the validator
	    circlePreference.setOnPreferenceChangeListener(numberCheckListener);
	    System.out.println("KKK");
	  }

	  
	/**
	   * Checks that a preference is a valid numerical value
	   */

	  Preference.OnPreferenceChangeListener numberCheckListener = new OnPreferenceChangeListener() {

	    @Override
	    public boolean onPreferenceChange(Preference preference, Object newValue) {
	      // Check that the string is an integer
	      if (newValue != null && newValue.toString().length() > 0
	          && newValue.toString().matches("\\d*")) {
	    	  System.out.println("JJJ");
	        return true;
	      }
	      // If now create a message to the user
	      Toast.makeText(MyPreferencesActivity.this, "Invalid Input",
	          Toast.LENGTH_SHORT).show();
	      return false;
	    }
	  };

	} 