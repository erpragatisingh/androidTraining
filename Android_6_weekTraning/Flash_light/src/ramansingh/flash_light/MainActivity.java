package ramansingh.flash_light;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private boolean isLighOn = false;

	private Camera camera;
	private ImageButton b1;

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub

		super.onStop();

		if (camera != null) {
			camera.release();
		}
	}

	@SuppressWarnings("static-access")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b1 = (ImageButton) findViewById(R.id.imageButton1);
		Context context = this;
		PackageManager pm = context.getPackageManager();
		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
			Log.e("err", "Device has no camera!");
			return;
		}

		camera = camera.open();
		final Parameters p = camera.getParameters();
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (isLighOn) {
					Log.i("info", "torch is turn off");
					p.setFlashMode(Parameters.FLASH_MODE_OFF);
					camera.setParameters(p);
					camera.stopPreview();
					isLighOn = false;
				} else {
					Log.i("ifo", "torch is on!");
					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
					camera.setParameters(p);
					camera.startPreview();
					isLighOn = true;
				}
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
