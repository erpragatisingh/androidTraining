package com.example.camera;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends Activity { 
	private static final int TAKE_PICTURE_CODE = 100;
	private static final int MAX_FACES = 5;
	Button b1;
	private Bitmap cameraBitmap = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1=(Button)findViewById(R.id.button1);
        
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	
		if(TAKE_PICTURE_CODE == requestCode){
			processCameraImage(data);
		}
	}
    
    private void processCameraImage(Intent intent){
    	setContentView(R.layout.detect);
    	
    	
    	
    	ImageView imageView = (ImageView)findViewById(R.id.imageView1);
    	
    	cameraBitmap = (Bitmap)intent.getExtras().get("data");
    	
    	imageView.setImageBitmap(cameraBitmap);
    }
    
    public void onClick(View v) {
		// TODO Auto-generated method stub
      Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
    	
    	startActivityForResult(intent, TAKE_PICTURE_CODE);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_camera, menu);
        return true;
    }
}
