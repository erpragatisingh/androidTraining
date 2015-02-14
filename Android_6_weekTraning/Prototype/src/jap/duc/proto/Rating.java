package jap.duc.proto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class Rating extends Activity{
	
	ImageButton b1,b2,b3;
	TextView t1,t2,t3;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.rating);
	b1=(ImageButton)findViewById(R.id.imageButton1);
	b2=(ImageButton)findViewById(R.id.imageButton2);
	b3=(ImageButton)findViewById(R.id.imageButton3);
	t1=(TextView)findViewById(R.id.textone);
	t2=(TextView)findViewById(R.id.texttwo);
	t3=(TextView)findViewById(R.id.textthree);
	
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent ii=new Intent(Rating.this,RatingOne.class);
			startActivity(ii);
		}
	});
	
	b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	});
	
	b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	});
}
}
