package media.demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

public class MymediaActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	Button b1,b2,b3;
	MediaPlayer m;
	 	
	int flag=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        String pathToFile = "/sdcard/p.mp3";
        System.out.println(pathToFile);
      //create mediaplayer
      m = new MediaPlayer();
      //set audio file path
      try {
        m.setDataSource(pathToFile);
      } catch (IllegalArgumentException e) {
    	  e.printStackTrace();
    	} catch (IllegalStateException e) {
    	  e.printStackTrace();
    	} catch (IOException e) {
    	  e.printStackTrace();
    	}
   
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
    }
   
    
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1){
			
			
			if(flag==0){
				 try {
					m.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			m.start();
			
			//b1.setText("Pause");
			
			flag=1;
			b1.setVisibility(0);
			
			v.setVisibility(View.GONE);
			b3.setVisibility(1);
			}
			if(flag==2){
				m.start();
				//b1.setText("Pause");
				flag=1;
				v.setVisibility(View.GONE);
				b3.setVisibility(View.VISIBLE);
			
	    	}
		}	
		if(v.getId()==R.id.button2){
			m.stop();
			b1.setVisibility(View.VISIBLE);
			b3.setVisibility(View.INVISIBLE);
			m.release();
			finish();
			//b1.setText("Start");
			//m.seekTo(time);
			//flag=0;
		}
		
		if(v.getId()==R.id.button3){
					
			 if(flag==1){
				m.pause();
				
				//b3.setVisibility(0);
			//b1.setText("resume");
				flag=2;
				v.setVisibility(View.INVISIBLE);
				b1.setVisibility(View.VISIBLE);
				flag=0;
			}
			
		}
	}
    }

    
 