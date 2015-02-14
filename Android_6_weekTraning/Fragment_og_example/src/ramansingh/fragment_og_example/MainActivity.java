package ramansingh.fragment_og_example;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
String tag= "LOG EXAMPLE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
Log.d("LOGEXAMPLE", "[ACTIVITY]:onCreate()---"+"before SetContentView");
setContentView(R.layout.activity_main);
Log.d("LOG EXAMPLE", "[ACTIVITY]:onCreate()---"+"after SetContentView");

	
	}

	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("LOG EXAMPLE", "[ACTIVITY]:onResume()");
		
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("LOG EXAMPLE", "[ACTIVITY]:onPause()");
		
	}

	
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("LOG EXAMPLE", "[ACTIVITY]:onStop()");
		
	}
	
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("LOG EXAMPLE", "[ACTIVITY]:onDestroy()");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
