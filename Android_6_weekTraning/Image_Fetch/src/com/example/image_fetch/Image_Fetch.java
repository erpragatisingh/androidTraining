package com.example.image_fetch;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class Image_Fetch extends Activity {
	Button button;
    ImageView img;
    VideoView vid;
    SurfaceView sur;
    private Bitmap bitmap; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__fetch);
        button=(Button)findViewById(R.id.button1);
        img=(ImageView)findViewById(R.id.imageView1);
        vid= (VideoView)findViewById(R.id.videoView1);
   //     sur=(SurfaceView)findViewById(R.id.surfaceView1);
      
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 
				intent.addCategory(Intent.CATEGORY_OPENABLE);
				intent.setType("*/*"); 
				startActivityForResult(Intent.createChooser(intent,"Select Pictureii"), 1); 
				
			}
		});
    }
        public void onActivityResult(int requestCode, int resultCode, Intent data) 
        { 
		if(requestCode == 1 && resultCode == Activity.RESULT_OK){
			
		//	Uri selectedImageUri = data.getData();
		//	img.setImageURI(selectedImageUri); 
			InputStream stream= null;   // use for read or consume data from internal or external device,  while outputstream is used for get the image on my application
			try {
				stream = getContentResolver().openInputStream(data.getData());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        bitmap = BitmapFactory.decodeStream(stream);
		        img.setImageBitmap(bitmap);
		        
		    //    vid.setVideoPath("/sdcard/Pitbull.mp4");
		        vid.setVideoURI(Uri.parse("file:///sdcard/sample.3gp"));
		        vid.setMediaController(new MediaController(this));
		        vid.requestFocus();
		        vid.start();
		        
		        
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_image__fetch, menu);
        return true;
    }
}
