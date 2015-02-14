package com.example.animationwithsound;

/*
 * This activity shows how a sound can be played along with a frameanimation
 */

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationwithSound extends Activity implements OnClickListener{

	/* 
	 * Getting a reference of all the views on the UI
	 */
	ImageView animationview;
	Button btstart,btstop;
	
	/*
	 * Getting a reference of the frameanimation and the Animationsound class
	 */
	AnimationDrawable frameAnimation;
	AnimationSound asound ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		animationview = (ImageView)findViewById(R.id.AnimatedIview);
		btstart = (Button)findViewById(R.id.btStart);
		btstop = (Button)findViewById(R.id.btStop);
		
		/*
		 * To start with , just need the start button to be enabled, user should not be able to click stop until the animation 
		 * is started 
		 */
		btstart.setEnabled(true);
		btstop.setEnabled(false);
		
		/*
		 * Registering the buttons to the onclicklistener
		 */
		btstart.setOnClickListener(this);
		btstop.setOnClickListener(this);
		
		/*
		 * Setting the background of the image view to the animation XML which defines how the image frames should be
		 * displayed one after the other
		 */
		animationview.setBackgroundResource(R.anim.horseanimation);
		
		/*
		 * Instantiating the frameanimation. Getting an instance of AnimationDrawable
		 */
		frameAnimation = 
				(AnimationDrawable) animationview.getBackground();	
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * Handling the logic when the start and stop animation buttons are clicked
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.btStart:
			/*
			 * First create an instance of the AnimationSound class. This will call the AnimationSound constructor in 
			 * AnimationSound.java and create an instance of the MP3 sound file. Passing the MP3 file which will be used
			 * to create the instance of the MediaPlayer
			 */
			asound = new AnimationSound(this,R.raw.galop);
			/*
			 * Starting the animation
			 * calling the startsound method in AnimationSound class
			 * disabling the start button so that user cannot click it until the animation is stopped
			 * enabling the stop animation button to allow te user to stop the animation
			 */
			frameAnimation.start();
			asound.startsound();
			btstart.setEnabled(false);
			btstop.setEnabled(true);
			break;
			
		case R.id.btStop:
			/*
			 * On click of the stop animation button, stopping the frame animation and also the sound
			 * enabling the start animation button so that user can restart the animation
			 * disabling the stop animation button, so that user cannot click it until the animation is started
			 */
			frameAnimation.stop();
			asound.stopsound();
			btstart.setEnabled(true);
			btstop.setEnabled(false);
			break;
		default:
			break;
		}
		
	}

}
