package com.example.musicplayerdemo;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

public class MusicPlayerDemo extends Activity {
	MediaPlayer media;
	Button button;
	VideoView v1;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_demo);
        button=(Button)findViewById(R.id.button1);
        v1=(VideoView)findViewById(R.id.videoView1);
        String s2= "/sdcard/sample.3gp";
        v1.setVideoPath(s2);
        v1.start();
        media= new MediaPlayer();
        String s1= "/sdcard/Gurbani.mp3";
        try {
			media.setDataSource(s1);
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
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					media.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					media.start();
				}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_music_player_demo, menu);
        return true;
    }
}
