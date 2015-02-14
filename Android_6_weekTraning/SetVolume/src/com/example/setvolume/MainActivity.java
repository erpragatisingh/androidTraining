package com.example.setvolume;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSeekBarChangeListener {

	SeekBar sb;
	MediaPlayer mp;
	AudioManager am;
	int volume=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.seekBar1);
        mp=MediaPlayer.create(this, R.raw.lakh);
        am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        mp.start();
        int maxVolume=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxVolume);
        sb.setProgress(curVolume);
        sb.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	mp.pause();
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	mp.start();
    }
    
    @Override
    public void onProgressChanged(SeekBar seekb, int progress, boolean arg2) {
    	// TODO Auto-generated method stub
    	am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
    	volume=progress;
    }
  
    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
    	// TODO Auto-generated method stub
    	Toast.makeText(getApplicationContext(), "Volume="+volume, Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
