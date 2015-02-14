package ramansingh.set_vol;

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
	
	sb=(SeekBar) findViewById(R.id.seekBar1);
	mp=MediaPlayer.create(this, R.raw.akay);
	am=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
	
	mp.start();
	int maxVol=am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
	int curVol=am.getStreamVolume(AudioManager.STREAM_MUSIC);
	sb.setMax(maxVol);
	sb.setProgress(curVol);
	sb.setOnSeekBarChangeListener(this);
	
	
	}

	protected void onPause() {
		mp.pause();
		
	}
	
	protected void onResume() {
		mp.pause();
		
	}
	
	
	public void onProgressChanged(SeekBar seb,int progress,boolean arg2){
		am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
		volume = progress;
		
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "volume:", 3000).show();
	}

}
