package jap.intent.ducat;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Spinner s;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		s = (Spinner) findViewById(R.id.spinner1);
		b = (Button) findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				int position = s.getSelectedItemPosition();
				Intent intent = null;
				switch (position) {
				case 0:
					intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("http://www.google.co.in"));
					break;
				case 1:
					intent = new Intent(Intent.ACTION_CALL, Uri
							.parse("tel:+919811855681"));
					break;
				case 2:
					intent = new Intent(Intent.ACTION_DIAL, Uri
							.parse("tel:+919811855681"));
					startActivity(intent);
					break;
				case 3:
					intent = new Intent("android.media.action.IMAGE_CAPTURE");
					break;
				case 4:
					intent = new Intent(Intent.ACTION_VIEW, Uri
							.parse("content://contacts/people/"));
					break;
				case 5:
					intent = new Intent(Intent.ACTION_EDIT, Uri
							.parse("content://contacts/people/1"));
					break;
                 
					

				}
				 if(intent!=null)
                 {
               	  startActivity(intent);
                 }
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
