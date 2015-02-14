package ramansingh.personaldairy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//font path
				String fontpath="Fonts/BRUSHSCRIPTSTD.OTF";
				String fp="Fonts/COOPBL.TTF";
				
				
			//text view label
				TextView textGhost=(TextView) findViewById(R.id.textlable);
				TextView tv2=(TextView) findViewById(R.id.textcontinue);
				TextView tv3=(TextView) findViewById(R.id.textexit);
				
				// loading font face
			
				Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
				//Applying fonts
				textGhost.setTypeface(tf);
				
				Typeface tf2=Typeface.createFromAsset(getAssets(), fp);
				//Applying fonts
				tv2.setTypeface(tf2);
				
				
				Typeface tf3=Typeface.createFromAsset(getAssets(), fp);
				
				//Applying fonts
				tv3.setTypeface(tf3);
				
				Button b1 = (Button) findViewById(R.id.button1);
				b1.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent i= new Intent(MainActivity.this,Continue.class);
						startActivity(i);
						
					}
				});
				
				Button b2=(Button) findViewById(R.id.button2);
				b2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
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
