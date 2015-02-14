package com.example.listviewwithxmlparsing;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String xmlData="<countries>"+
        "<country name='India Flag='"+Integer.toString(R.drawable.apple)+"'>"+"<language>Hindi</language>"+"<capital city='New Delhi' />"+"</country>"+
        "<country name='Pakistan Flag='"+Integer.toString(R.drawable.doggy)+"'>"+"<language>Urdu</language>"+"<capital city='Islamabad' />"+"</country>"+
        "<country name='Sri Lanka Flag='"+Integer.toString(R.drawable.elephant)+"'>"+"<language>Sinhala</language>"+"<capital city='Colombo' />"+"</country>"+
        "</countries>";
        
        ListViewLoaderTask l=new ListViewLoaderTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
