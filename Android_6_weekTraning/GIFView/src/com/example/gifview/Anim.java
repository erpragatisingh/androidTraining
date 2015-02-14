package com.example.gifview;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;

public class Anim extends View{
	private Movie movie;
	private long mMoviestart;

	public Anim(Context context, InputStream i) {
		super(context);
		// TODO Auto-generated constructor stub
		 movie = Movie.decodeStream(i);  
		
		
	}
	 @Override
	    protected void onDraw(Canvas canvas) {
	       canvas.drawColor(Color.TRANSPARENT);
	   //    super.onDraw(canvas);
	       final long now = SystemClock.uptimeMillis();
	       if (mMoviestart == 0) {
	          mMoviestart = now;
	       }
	       final int relTime = (int)((now - mMoviestart) % movie.duration());
	       movie.setTime(relTime);
	       movie.draw(canvas, 10, 10);
	       this.invalidate();
	    }
}

