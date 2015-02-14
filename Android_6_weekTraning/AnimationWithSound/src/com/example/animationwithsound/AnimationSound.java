package com.example.animationwithsound;

/*
 * This class is used to handle playing the sounds when animation is started/stopped
 */

import android.media.MediaPlayer;
import android.content.Context;

public class AnimationSound {
	MediaPlayer mpsound;

	/*
	 * Constructor which takes as input the context and the raw mp3 file identifier
	 */
	AnimationSound(Context context, int id) {

		/*
		 * Creates an instance of the mediaplayer using the passed mp3 file
		 */
		mpsound = MediaPlayer.create(context, id);

	}

	/*
	 * When this method is called, the sound is played in a loop until the stopsound method is called
	 */
	public void startsound() {
		mpsound.start();
		mpsound.setLooping(true);
	}

	/*
	 * When this method is called , the playing of the sound is stoppes
	 */
	public void stopsound() {
		if (mpsound != null) {
			if (mpsound.isPlaying()) {
				mpsound.stop();
				mpsound.setLooping(false);
			}

			/*
			 * Finally release everything and clear out the mediaplayer object
			 */
			mpsound.release();
			mpsound = null;
		}

	}
}
