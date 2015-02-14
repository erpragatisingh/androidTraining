package com.examle.camerademopra;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	private static final String TAG = "CameraDemo";
	Camera camera;
	Preview preview;
	Button buttonClick;

	/*
	 * To take pictures with this class, use the following steps:
	 * 
	 * 1 Obtain an instance of Camera from open(int). 2 Get existing (default)
	 * settings with getParameters(). If necessary, modify the returned
	 * Camera.Parameters object and call setParameters(Camera.Parameters). If
	 * desired, call setDisplayOrientation(int). Important: Pass a fully
	 * initialized SurfaceHolder to setPreviewDisplay(SurfaceHolder). Without a
	 * surface, the camera will be unable to start the preview. Important: Call
	 * startPreview() to start updating the preview surface. Preview must be
	 * started before you can take a picture. When you want, call
	 * takePicture(Camera.ShutterCallback, Camera.PictureCallback,
	 * Camera.PictureCallback, Camera.PictureCallback) to capture a photo. Wait
	 * for the callbacks to provide the actual image data. After taking a
	 * picture, preview display will have stopped. To take more photos, call
	 * startPreview() again first. Call stopPreview() to stop updating the
	 * preview surface. Important: Call release() to release the camera for use
	 * by other applications. Applications should release the camera immediately
	 * in onPause() (and re-open() it in onResume()). To quickly switch to video
	 * recording mode, use these steps:
	 * 
	 * Obtain and initialize a Camera and start preview as described above. Call
	 * unlock() to allow the media process to access the camera. Pass the camera
	 * to setCamera(Camera). See MediaRecorder information about video
	 * recording. When finished recording, call reconnect() to re-acquire and
	 * re-lock the camera. If desired, restart preview and take more photos or
	 * videos. Call stopPreview() and release() as described above. This class
	 * is not thread-safe, and is meant for use from one event thread. Most
	 * long-running operations (preview, focus, photo capture, etc) happen
	 * asynchronously and invoke callbacks as necessary. Callbacks will be
	 * invoked on the event thread open(int) was called from. This class's
	 * methods must never be called from multiple threads at once.
	 * 
	 * Caution: Different Android-powered devices may have different hardware
	 * specifications, such as megapixel ratings and auto-focus capabilities. In
	 * order for your application to be compatible with more devices, you should
	 * not make assumptions about the device camera specifications.
	 */

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		preview = new Preview(this);
		((FrameLayout) findViewById(R.id.previewFrmm)).addView(preview);

		buttonClick = (Button) findViewById(R.id.buttonClick);
		buttonClick.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				preview.camera.takePicture(shutterCallback, rawCallback,
						jpegCallback);
			}
		});

		Log.d(TAG, "onCreate'd");
	}

	ShutterCallback shutterCallback = new ShutterCallback() {
		public void onShutter() {
			Log.d(TAG, "onShutter'd");
		}
	};

	/** Handles data for raw picture */
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			Log.d(TAG, "onPictureTaken - raw");
		}
	};

	/** Handles data for jpeg picture */
	PictureCallback jpegCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			FileOutputStream outStream = null;
			long time = 0;
			try {
				// write to local sandbox file system
				// outStream =
				// CameraDemo.this.openFileOutput(String.format("%d.jpg",
				// System.currentTimeMillis()), 0);
				// Or write to sdcard
				time = System.currentTimeMillis();
				outStream = new FileOutputStream(String.format(
						"/sdcard/%d.jpg", time));
				outStream.write(data);
				outStream.close();
				Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}
			Log.d(TAG, "onPictureTaken - jpeg");
		}
	};

}
