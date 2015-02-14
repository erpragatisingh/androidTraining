package jap.duc.proto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 

public class Browse1 extends Activity {


Button b1,b2,b3,b4,b5,b6;
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.browsermenu);
	 b1=(Button)findViewById(R.id.B1);
	b2=(Button)findViewById(R.id.B2);
	b3=(Button)findViewById(R.id.B3);
	b4=(Button)findViewById(R.id.B4);
	b5=(Button)findViewById(R.id.B5);
	b6=(Button)findViewById(R.id.B6);
	b1.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(Browse1.this,BrowserOne.class);
			startActivity(i);
			
		}
	});
	
b2.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i2=new Intent(Browse1.this,BrowserTwo.class);
			startActivity(i2);
		}
	});

b3.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
	// TODO Auto-generated method stub
	Intent i3=new Intent(Browse1.this,BrowserThree.class);
	startActivity(i3);
}
});

b4.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
});

b5.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
});

b6.setOnClickListener(new OnClickListener() {

public void onClick(View v) {
	// TODO Auto-generated method stub
	
}
});
}


}
