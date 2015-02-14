package example.pack.man;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		if (item.getItemId() == R.id.menu_settings) {

			Intent i = getPackageManager().getLaunchIntentForPackage(
					"com.android.settings");
			startActivity(i);

		}

		else if (item.getItemId() == R.id.galry) {
			Intent i = getPackageManager().getLaunchIntentForPackage(
					"com.android.gallery");
			startActivity(i);
		}
		return super.onOptionsItemSelected(item);
	}
}
