package ramansingh.moving_text;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	tv=(TextView) findViewById(R.id.textView1);
	
	Animation anm= new TranslateAnimation(0, 0, 100, -100);
	anm.setDuration(9000);
	anm.setRepeatCount(-1);
	
	
	tv.setAnimation(anm);
	
	}
public void function(View v){
	Toast.makeText(getApplicationContext(), "yankee", 3000).show();
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
