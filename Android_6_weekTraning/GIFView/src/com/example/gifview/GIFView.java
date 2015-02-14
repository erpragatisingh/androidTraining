package com.example.gifview;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.app.Activity;
import android.view.Menu;

public class GIFView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifview);
        InputStream stream = null;
        try {
           stream = getAssets().open("Pig.gif");
        } catch (IOException e) {
          e.printStackTrace();
        }
        Anim view = new Anim(this, stream);
        setContentView(view);
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gifview, menu);
        return true;
    }
}
