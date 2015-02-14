package ramansingh.external_fonts;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	//font path
		String fontpath="fonts/ARABTYPE.TTF";
		String fp="fonts/PALSCRI.TTF";
		String fb="fonts/PLAYBILL.TTF";
		
	//text view label
		TextView textGhost=(TextView) findViewById(R.id.textView1);
		TextView tv2=(TextView) findViewById(R.id.textView2);
		TextView tv3=(TextView) findViewById(R.id.textView3);
		
		// loading font face
	
		Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
		//Applying fonts
		textGhost.setTypeface(tf);
		
		Typeface tf2=Typeface.createFromAsset(getAssets(), fp);
		//Applying fonts
		textGhost.setTypeface(tf2);
		
		
		Typeface tf3=Typeface.createFromAsset(getAssets(), fb);
		
		//Applying fonts
		textGhost.setTypeface(tf3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
