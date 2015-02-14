package ramansingh.personaldairy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Continue extends Activity {
	Button b1,b2,b3,b4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contnue);
		
b1= (Button) findViewById(R.id.binsert);
b2= (Button) findViewById(R.id.bview);
b3= (Button) findViewById(R.id.bupdate);
b4= (Button) findViewById(R.id.bdelete);

b1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i = new Intent(Continue.this,Insertcontacts.class);
		startActivity(i);
		
	}
})	;


b2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i= new Intent(Continue.this,Display.class);
		startActivity(i);
		
	}
});
				
				
				
}
}