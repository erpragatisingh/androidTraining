package com.example.swipegesture;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity implements SimpleGestureListener{

	private SimpleGestureFilter detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector=new SimpleGestureFilter(this,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean dispatchTouchEvent(MotionEvent me)
    {
    	this.detector.onTouchEvent(me);
    	return super.dispatchTouchEvent(me);
    }

	@Override
	public void onSwipe(int direction) {
		// TODO Auto-generated method stub
		
		String str="";
		switch(direction)
		{
		case SimpleGestureFilter.SWIPE_RIGHT:str="Swipe"
		}
	}

	@Override
	public void onDoubleTap() {
		// TODO Auto-generated method stub
		
	}
    
    
}
