package com.example.drawable;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;

public class Drwaable extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drwaable);
     // Get the AssetManager
        AssetManager manager = getAssets();

        // Read a Bitmap from Assets
        InputStream open = null;
        try {
          open = manager.open("icon1.jpg");
          Bitmap bitmap = BitmapFactory.decodeStream(open);
          Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.mir); 
          Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, 100, 50, false);
          // Assign the bitmap to an ImageView in this layout
          ImageView view = (ImageView) findViewById(R.id.imageView1);
          ImageView view1 = (ImageView) findViewById(R.id.imageView2);
          
          // Convert Bitmap to Drawable
          Drawable d = new BitmapDrawable(getResources(),bitmap); 
          view.setImageBitmap(resizedBitmap);
       //   view.setImageDrawable(d);
          view1.setImageBitmap(b);
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
          if (open != null) {
            try {
              open.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        } 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_drwaable, menu);
        return true;
    }
}
