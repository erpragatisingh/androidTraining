package com.exple.activitysaveinstantstate;

import android.app.Activity;
import android.os.Bundle;

 

public class Second extends Activity{
	static final String STATE_SCORE = "playerScore";
	static final String STATE_LEVEL = "playerLevel";
	int mCurrentScore,mCurrentLevel;
	@Override
	protected void onCreate(Bundle outState) {
		// TODO Auto-generated method stub
		super.onCreate(outState);
		// Check whether we're recreating a previously destroyed instance
	    if (outState != null) {
	        // Restore value of members from saved state
	        mCurrentScore = outState.getInt(STATE_SCORE);
	        mCurrentLevel = outState.getInt(STATE_LEVEL);
	    } else {
	        // Probably initialize members with default values for a new instance
	    }
	}
   
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
		// Save the user's current game state
		outState.putInt(STATE_SCORE, mCurrentScore);
		outState.putInt(STATE_LEVEL, mCurrentLevel);
	    
	    // Always call the superclass so it can save the view hierarchy state
		
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		
		// Restore state members from saved instance
	    mCurrentScore = savedInstanceState.getInt(STATE_SCORE);
	    mCurrentLevel = savedInstanceState.getInt(STATE_LEVEL);
	}
}
