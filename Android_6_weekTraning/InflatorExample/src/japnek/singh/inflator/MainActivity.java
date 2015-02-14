package japnek.singh.inflator;

import japnek.singh.inflator.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button b1;
	TextView tv;
	public int ctr = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LayoutInflater inf = getLayoutInflater();
				View tlayout = inf.inflate(R.layout.second,
						(ViewGroup) findViewById(R.id.second_layout));

				while (ctr <5) {
					
					switch (ctr) {
					case 1:
						tv = (TextView) tlayout.findViewById(R.id.text1);
						tv.setText("Apple");
						b1.setBackgroundResource(japnek.singh.inflator.R.drawable.apple);
						break;
					case 2:
						tv = (TextView) tlayout.findViewById(R.id.text1);
						tv.setText("");
						b1.setBackgroundResource(string.b);
						break;
					case 3:
						tv = (TextView) tlayout.findViewById(R.id.text1);
						tv.setText("Ball");
						b1.setBackgroundResource(japnek.singh.inflator.R.drawable.ball);
						break;
					case 4:
						tv = (TextView) tlayout.findViewById(R.id.text1);
						tv.setText("");
						b1.setBackgroundResource(string.c);
						break;
					case 5:
						tv = (TextView) tlayout.findViewById(R.id.text1);
						tv.setText("Cat");
						b1.setBackgroundResource(japnek.singh.inflator.R.drawable.cat);
						break;
						
					}
					++ctr;
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
