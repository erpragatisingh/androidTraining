package com.example.imagecapturedemo;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

@TargetApi(9)
public class ImageCaptureDemo extends Activity {
	final static String DEBUG_TAG = "MakePhotoActivity";
	  private Camera camera;
	  private int cameraId = 0;
	  Button b1;

 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture_demo);
        b1= (Button)findViewById(R.id.button12);
        
     // do we have a camera?
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
          Toast.makeText(this, "No camera on this device", Toast.LENGTH_LONG)
              .show();
        } else {
          cameraId = findFrontFacingCamera();
          if (cameraId < 0) {
            Toast.makeText(this, "No front facing camera found.",
                Toast.LENGTH_LONG).show();
          } else {
            camera = Camera.open(cameraId);
            
          }
        }
      }
    
    public void onClick(View view) {
    	
        camera.takePicture(null, null,
            new PhotoHandler(getApplicationContext()));
        Toast.makeText(this, "No a found.",
                Toast.LENGTH_LONG).show();
      }
    

	private int findFrontFacingCamera() {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
          CameraInfo info = new CameraInfo();
          Camera.getCameraInfo(i, info);
          if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
            Log.d(DEBUG_TAG, "Camera found");
            cameraId = i;
            break;
          }
        }
        return cameraId;
      }

	  @Override
	  protected void onPause() {
	    if (camera != null) {
	      camera.release();
	      camera = null;
	    }
	    super.onPause();
	  }

	} 