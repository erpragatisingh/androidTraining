package com.example.live2;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;

public class Live2 extends WallpaperService {
	 static final String TAG = "NYAN";
    @Override
    public Engine onCreateEngine() {
        try {
            return new NyanEngine();
        } catch (IOException e) {
            Log.w(TAG, "Error creating NyanEngine", e);
            stopSelf();
            return null;
        }
    }

    class NyanEngine extends Engine {
    	 
        final Handler mNyanHandler = new Handler();
        private final Movie mNyan;
        private final int mNyanDuration;
        private final Runnable mNyanNyan;
        float mScaleX;
        float mScaleY;
        int mWhen;
        long mStart;

        NyanEngine() throws IOException {
            InputStream is = getResources().openRawResource(R.raw.abc);
            if (is != null) {
                try {
                    mNyan = Movie.decodeStream(is);
                    System.out.println(mNyan);
                    mNyanDuration = mNyan.duration();
                    System.out.println(mNyanDuration);
                } finally {
                    is.close();
                }
            } else {
                throw new IOException("Unable to open R.raw.nyan");
            }

            mWhen = -1;
            mNyanNyan = new Runnable() {
                public void run() {
                	// System.out.println("EEE");
                    nyan();
                }
            };
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            mNyanHandler.removeCallbacks(mNyanNyan);
            System.out.println("DDD");
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);
            if (visible) {
                nyan();
                System.out.println("CCC");
            } else {
                mNyanHandler.removeCallbacks(mNyanNyan);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            mScaleX = width / (1f * mNyan.width());
            mScaleY = height / (1f * mNyan.height());
            nyan();
            System.out.println(mScaleX);
            System.out.println(mScaleY);
            System.out.println(width);
            System.out.println(height);
            System.out.println(mNyan.width());
            System.out.println(mNyan.height());
            System.out.println("BBB");
        }

        @Override
        public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep,
                float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            super.onOffsetsChanged(xOffset, yOffset, xOffsetStep, yOffsetStep, xPixelOffset, yPixelOffset);
            nyan();
            System.out.println("FFF");
        }

        void nyan() {
            tick();
            SurfaceHolder surfaceHolder = getSurfaceHolder();
            Canvas canvas = null;
         //   System.out.println("GGG");
            try {
                canvas = surfaceHolder.lockCanvas();
                if (canvas != null) {
                    nyanNyan(canvas);
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            mNyanHandler.removeCallbacks(mNyanNyan);
            if (isVisible()) {
                mNyanHandler.postDelayed(mNyanNyan, 1000L/25L);
            }
        }

        void tick() {
            if (mWhen == -1L) {
                mWhen = 0;
                mStart = SystemClock.uptimeMillis();
          //      System.out.println("HHH");
            } else {
                long mDiff = SystemClock.uptimeMillis() - mStart;
                mWhen = (int) (mDiff % mNyanDuration);
            }
        }

        void nyanNyan(Canvas canvas) {
            canvas.save();
            canvas.scale(mScaleX, mScaleY);
            mNyan.setTime(mWhen);
            mNyan.draw(canvas, 0, 0);
            canvas.restore();
        //    System.out.println("III");
        }
    }
}

