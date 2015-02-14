package japnek.ratingbar.duc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public RatingBar r1;
	public Button b1;
	public TextView t1,t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		r1 = (RatingBar) findViewById(R.id.ratingBar1);
		b1 = (Button) findViewById(R.id.button1);
		t1 = (TextView) findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);

		r1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			public void onRatingChanged(RatingBar r1, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub

				t2.setText(String.valueOf(rating));

			}
		});

		b1.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this,
						String.valueOf(r1.getRating()), Toast.LENGTH_SHORT)
						.show();

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
