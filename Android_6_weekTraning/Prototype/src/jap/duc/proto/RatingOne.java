package jap.duc.proto;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class RatingOne extends Activity {

	RatingBar r;
	Button b;
	TextView t11,tx22;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingone);
		r=(RatingBar)findViewById(R.id.ratingBar1);
		t11=(TextView)findViewById(R.id.tex1);
		tx22=(TextView)findViewById(R.id.tex2);
		b=(Button)findViewById(R.id.bu1);
		
		r.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			public void onRatingChanged(RatingBar r1, float rating,
					boolean fromUser) {
				// TODO Auto-generated method stub

				tx22.setText(String.valueOf(rating));

			}
		});
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(RatingOne.this,
						String.valueOf(r.getRating()), Toast.LENGTH_SHORT)
						.show();
			}
		});
		
	}
}
