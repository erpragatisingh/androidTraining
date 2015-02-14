package com.example.multimediademo;

import java.io.IOException;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Multimedia extends Activity {
	Button b1, b2, b3;
	MediaPlayer mp;
	VideoView v1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multimedia);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        v1=(VideoView)findViewById(R.id.videoView1);
        mp= new MediaPlayer();
        mp.create(getApplicationContext(), R.raw.abc);
        String str= "/sdcard/abc.mp3";
  //     mp= MediaPlayer.create(this, R.raw.abc);
        v1.setVideoURI(Uri.parse("file:///sdcard/sample.3gp"));
     
    /*    try {
			mp.setDataSource(str);
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
				v1.start();
			}
		});
        
 b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.pause();
				v1.pause();
			}
		});
 
 b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mp.stop();
			v1.stopPlayback();
		}
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_multimedia, menu);
        return true;
    }
}
