package ramansingh.animationframeapp;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
AnimationDrawable ad;
Button b1,b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	b1=(Button) findViewById(R.id.buton1);
	b2=(Button) findViewById(R.id.buton2);
	ImageView im=(ImageView) findViewById(R.id.imageView1);
	
	b1.setOnClickListener((OnClickListener) this);
	b2.setOnClickListener((OnClickListener) this);
	im.setBackgroundResource(R.drawable.burns);
	
	ad=(AnimationDrawable) im.getBackground();
	
	
	}

	
	public void Onclick(View v){
		if(v.getId()==R.id.buton1){
			ad.start();
			
		}
		if(v.getId()==R.id.buton2){
			ad.stop();
			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
