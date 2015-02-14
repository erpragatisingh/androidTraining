package com.example.parcel;


import android.os.Bundle;

import android.os.Parcelable;
import android.app.Activity;
import android.view.Menu;

public class Parcel extends Activity {
	abc a1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);
        System.out.println(8889);
        a1= new abc();
        
    }
        

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_parcel, menu);
        return true;
    }
}
