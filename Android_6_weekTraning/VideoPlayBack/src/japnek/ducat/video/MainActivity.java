package japnek.ducat.video;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	static private final String pathToFile="p.mp3";
	VideoView videoView;
	MediaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // setContentView(R.layout.activity_main);
        
        File root=Environment.getExternalStorageDirectory();
        videoView=new VideoView(this);
        videoView.setVideoURI(Uri.parse(root+"/"+pathToFile));
        controller=new MediaController(this);
        videoView.setMediaController(controller);
        videoView.start();
        setContentView(videoView);
        
       
    }
    public void onDestroy()
    {
    	super.onDestroy();
    	videoView.stopPlayback();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
