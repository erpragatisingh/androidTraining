package com.example.livewallpaper;

import java.util.ArrayList;
import java.util.List;



import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Paint;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.service.wallpaper.WallpaperService;

import android.view.SurfaceHolder;
public class MyWallpaperService extends WallpaperService {

	  @Override
	  public Engine onCreateEngine() {
	    return new MyWallpaperEngine();
	  }
	  
	  private class MyWallpaperEngine extends Engine {
		
		  
	    private final Handler handler = new Handler();
	    private final Runnable drawRunner = new Runnable() {
	      @Override
	      public void run() {
	    	  System.out.println("AAA");
	    	 
	        draw();
	      }

	    };
	    private List<MyPoint> circles;
	    private Paint paint = new Paint();
	    private int width;
	    int height;
	    private boolean visible = true;
	    private int maxNumber;
	    private boolean touchEnabled;

	    public MyWallpaperEngine() {
	      SharedPreferences prefs = PreferenceManager
	          .getDefaultSharedPreferences(MyWallpaperService.this);
	      System.out.println("BBB");
	     maxNumber = Integer
	         .valueOf(prefs.getString("numberOfCircles", "10"));
	      touchEnabled = prefs.getBoolean("touch", true);
	     
	      System.out.println(maxNumber);
	      System.out.println(touchEnabled);
	      circles = new ArrayList<MyPoint>();
	   //   paint.setAntiAlias(true);
	      paint.setColor(Color.CYAN);
	      paint.setStyle(Paint.Style.FILL_AND_STROKE);
	   //   paint.setStrokeJoin(Paint.Join.MITER);
	      paint.setStrokeWidth(15f);
	  //    handler.post(drawRunner);
	    }
	    @Override
	    public void onSurfaceChanged(SurfaceHolder holder, int format,
	        int width, int height) {
	      this.width = width;
	      this.height = height;
	      super.onSurfaceChanged(holder, format, width, height);
	      System.out.println("EEE");
	    }

	    @Override
	    public void onVisibilityChanged(boolean visible) {
	      this.visible = visible;
	      if (visible) {
	    	  System.out.println("VVV");
	        handler.post(drawRunner);
	        System.out.println("CCC");
	      } else {
	  //      handler.removeCallbacks(drawRunner);
	        System.out.println("ZZZ");
	      }
	    }

	    

	  
/*	  @Override
	    public void onSurfaceDestroyed(SurfaceHolder holder) {
	      super.onSurfaceDestroyed(holder);
	      this.visible = false;
	      handler.removeCallbacks(drawRunner);
	      System.out.println("DDD");
	    }
*/
	   
	/*    @Override
	    public void onTouchEvent(MotionEvent event) {
	      if (touchEnabled) {

	        float x = event.getX();
	        float y = event.getY();
	        SurfaceHolder holder = getSurfaceHolder();
	        Canvas canvas = null;
	        try {
	          canvas = holder.lockCanvas();
	          if (canvas != null) {
	            canvas.drawColor(Color.GRAY);
	            circles.clear();
	            circles.add(new MyPoint(String.valueOf(circles.size() + 1), x, y));
	            drawCircles(canvas, circles);
	            System.out.println("FFF");

	          }
	        } finally {
	          if (canvas != null)
	            holder.unlockCanvasAndPost(canvas);
	          System.out.println("GGG");
	        }
	        super.onTouchEvent(event);
	      }
	    }
*/
	    private void draw() {
	      SurfaceHolder holder = getSurfaceHolder();
	      Canvas canvas = null;
	      try {
	        canvas = holder.lockCanvas();
	        System.out.println("HHH");
	        if (canvas != null) {
	          if (circles.size() >= maxNumber) {
	            circles.clear();
	          }
	          int x = (int) (width * Math.random());
	          int y = (int) (height * Math.random());
	          circles.add(new MyPoint(String.valueOf(circles.size() + 1),
	              x, y));
	          drawCircles(canvas, circles);
	        }
	      } finally {
	        if (canvas != null)
	          holder.unlockCanvasAndPost(canvas);
	      }
	      handler.removeCallbacks(drawRunner);
	      if (visible) {
	        handler.postDelayed(drawRunner, 1000);
	      }
	    }

	    // Surface view requires that all elements are drawn completely
	    private void drawCircles(Canvas canvas, List<MyPoint> circles) {
	      canvas.drawColor(Color.WHITE);
	      for (MyPoint point : circles) {
	        canvas.drawCircle(point.x, point.y, 20.0f, paint);
	        System.out.println("III");
	      }
	    }
	  }
}
