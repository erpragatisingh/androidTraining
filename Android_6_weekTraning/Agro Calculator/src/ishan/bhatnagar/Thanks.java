/**
 * 
 */
package ishan.bhatnagar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

/**
 * @author wahiguru
 *
 */
public class Thanks extends Activity
 {@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	
	setContentView(R.layout.thank_u);
	
	
	TextView tv=(TextView) findViewById(R.id.textmainPage);
	tv.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			
			startActivity(new Intent(getApplicationContext(),Login.class));
			
			return false;
		}
	});
	
	
	
}

	/**
	 * 
	 */
	 
}
