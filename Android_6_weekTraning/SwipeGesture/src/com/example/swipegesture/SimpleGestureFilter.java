package com.example.swipegesture;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class SimpleGestureFilter extends SimpleOnGestureListener {

	public final static int SWIPE_UP=1;
	public final static int SWIPE_DOWN=2;
	public final static int SWIPe_LEFT=3;
	public final static int SWIPE_RIGHT=4;
	
	public final static int MODE_TRANSPARENT=0;
	public final static int MODE_SOLID=1;
	public final static int MODE_DYNAMIC=2;
	
	public final static int ACTION_FAKE=-13;
	private int swipe_Min_Distance=100;
	private int swipe_Max_Distance=350;
	private int swipe_Min_Velocity=100;
	
	private int mode=MODE_DYNAMIC;
	private boolean running=true;
	private boolean tapIndicator=false;
	
	private Activity context;
	private GestureDetector detector;
	private SimpleGestureListener listener;
	
	public SimpleGestureFilter(Activity context,SimpleGestureListener sgl)
	{
		this.context=context;
		this.detector=new GestureDetector(context,this);
		this.listener=sgl;
	}
	
	public void onTouchEvent(MotionEvent event)
	{
		if(!this.running)
			return;
		boolean result=this.detector.onTouchEvent(event);
		if(this.mode==MODE_SOLID)
			event.setAction(MotionEvent.ACTION_CANCEL);
		else if(this.mode==MODE_DYNAMIC)
		{
			if(event.getAction()==ACTION_FAKE)
				event.setAction(MotionEvent.ACTION_UP);
			else if(result)
				event.setAction(MotionEvent.ACTION_CANCEL);
			else if(this.tapIndicator)
			{
				event.setAction(MotionEvent.ACTION_DOWN);
				this.tapIndicator=false;
			}
		}
	}
	
	public void setMode(int m)
	{
		this.mode=m;
	}
	
	public int getMode()
	{
		return this.mode;
	}
	
	public void setEnabled(boolean status)
	{
		this.running=status;
	
	}
	
	public void setSwipeMaxDistance(int distance)
	{
		this.swipe_Max_Distance=distance;
	

	}
	public void setSwipeMinDistance(int distance)
	{
		this.swipe_Min_Distance=distance;
	}
	
	public void setSwipeMinVelocity(int distance)
	{
		this.swipe_Min_Velocity=distance;
	}
	public int getSwipeMaxDistance()
	{
		return this.swipe_Max_Distance;
	}
	public  int getSwipeMinDistance()
	{
		return this.swipe_Min_Distance;
	}
	public int getSwipeMinVelocity()
	{
		return this.swipe_Min_Velocity;
	}
	public boolean onFling(MotionEvent)
}
