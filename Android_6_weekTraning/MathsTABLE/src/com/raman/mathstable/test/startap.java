package com.raman.mathstable.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class startap extends Activity  {
	
	
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startap);
    
    
	b1=(Button) findViewById(R.id.button1);
	b2=(Button) findViewById(R.id.button2);
	b3=(Button) findViewById(R.id.button3);
	b4=(Button) findViewById(R.id.button4);
	b5=(Button) findViewById(R.id.button5);
	b6=(Button) findViewById(R.id.button6);
	b7=(Button) findViewById(R.id.button7);
	b8=(Button) findViewById(R.id.button8);
	b9=(Button) findViewById(R.id.button9);
	b10=(Button) findViewById(R.id.button10);
	b11=(Button) findViewById(R.id.button11);
	b12=(Button) findViewById(R.id.button12);
	
	
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
Intent i= new Intent(startap.this,ableview.class);
			
			startActivity(i);
		}
	});
	
	
	
b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t2.class);
			
			startActivity(i);
		}
	});


b3.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t3.class);
		
		startActivity(i);
	}
});



b4.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t4.class);
		
		startActivity(i);
	}
});



b5.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t5.class);
		
		startActivity(i);
	}
});



b6.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t6.class);
		
		startActivity(i);
	}
});



b7.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t7.class);
		
		startActivity(i);
	}
});



b8.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t8.class);
		
		startActivity(i);
	}
});



b9.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t9.class);
		
		startActivity(i);
	}
});


b10.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t1.class);
		
		startActivity(i);
	}
});



b11.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t11.class);
		
		startActivity(i);
	}
});



b12.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
Intent i= new Intent(startap.this,t12.class);
		
		startActivity(i);
	}
});




	
		
	}}
