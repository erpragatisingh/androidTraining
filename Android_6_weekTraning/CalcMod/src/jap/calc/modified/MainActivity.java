package jap.calc.modified;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button b1, b2, b3, b4 ,b5;
	TextView t1, t2, t3, t4, t5, t6;
	EditText e1, e2;
	public double a = 0.0, b = 0.0, ans = 0.0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5=  (Button) findViewById(R.id.button5);
		e1 = (EditText) findViewById(R.id.editText1);
		e2 = (EditText) findViewById(R.id.editText2);
		t1 = (TextView) findViewById(R.id.textView1);
		t2 = (TextView) findViewById(R.id.textView2);
		t3 = (TextView) findViewById(R.id.textView3);
		t4 = (TextView) findViewById(R.id.textView4);
		t5 = (TextView) findViewById(R.id.textView5);
		t6 = (TextView) findViewById(R.id.textView6);

		b1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				a = Double.parseDouble(e1.getText().toString());
				b = Double.parseDouble(e2.getText().toString());
				ans = a + b;

				
			}
		});

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a = Double.parseDouble(e1.getText().toString());
				b = Double.parseDouble(e2.getText().toString());
				ans = a - b;

				

			}
		});

		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a = Double.parseDouble(e1.getText().toString());
				b = Double.parseDouble(e2.getText().toString());
				ans = a * b;

				

			}
		});

		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a = Double.parseDouble(e1.getText().toString());
				b = Double.parseDouble(e2.getText().toString());
				ans = a / b;

				

			}
		});

		
		b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String s3 = String.valueOf(ans);
				t6.setText(s3);
				
		
				
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
