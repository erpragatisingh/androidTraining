package com.example.music;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

public class second extends Activity {
	MediaPlayer mMediaPlayer;
	Button b1, b2, b3;
	  private static final int UPDATE_FREQUENCY = 500;
	String filename;
	SeekBar seek;
	
	  
    private final Handler handler = new Handler();
     
    private final Runnable updatePositionRunnable = new Runnable() {
            public void run() {
                    updatePosition();
            }
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player);
		seek=(SeekBar)findViewById(R.id.seekBar1);
		 mMediaPlayer = new MediaPlayer();
		Intent i= getIntent();
		filename= i.getStringExtra("name");
		System.out.println("Helloooooo"+filename);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				seek.setProgress(0);
                
	           
		               try {
						mMediaPlayer.setDataSource(filename);
						 mMediaPlayer.prepare();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		               System.out.println("DDDDDD");
		               seek.setMax(mMediaPlayer.getDuration());
		               mMediaPlayer.start();
		               updatePosition();
		           //    seek.setProgress(mMediaPlayer.getCurrentPosition());
		         
			}
		});
		
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				  mMediaPlayer.pause();
			}
		});
	
b3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		  mMediaPlayer.stop();
		  mMediaPlayer.reset();
	}
});

		
   }
	
	 private void updatePosition(){
         handler.removeCallbacks(updatePositionRunnable);
          
         seek.setProgress(mMediaPlayer.getCurrentPosition());
          
         handler.postDelayed(updatePositionRunnable, UPDATE_FREQUENCY);
 }
	}


