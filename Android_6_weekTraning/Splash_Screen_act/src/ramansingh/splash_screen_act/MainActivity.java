package ramansingh.splash_screen_act;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	TimerTask tt= new TimerTask() {
	
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Intent i= new Intent(MainActivity.this,newin.class);
			startActivity(i);
			
		}
	};
	
	Timer t= new Timer();
	t.schedule(tt, 3000);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
