package com.exple.activitysaveinstantstate;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView timeTV;
	String p="Pragati";
//	private Calendar startTime = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle outState) {
		super.onCreate(outState);
		// Always call the superclass first
		setContentView(R.layout.activity_main);
	    // Check whether we're recreating a previously destroyed instance
		 Log.v("TAG", "Inside of onCreate");
		        
		         timeTV = (TextView) findViewById(R.id.tv);
		   
		        if ((outState != null)
		                && (outState.getSerializable("p") != null)) {
		        	p="Pragati";
//		            startTime = (Calendar) outState
//		                    .getSerializable("starttime");
		       
		        
		        }
		        
		        timeTV.setText( p);
	}

	 
              @Override
            protected void onSaveInstanceState(Bundle outState) {
            	// TODO Auto-generated method stub
            	super.onSaveInstanceState(outState);
            	outState.putSerializable("starttime", p);
            }
              
              
              @Override
            protected void onRestoreInstanceState(Bundle savedInstanceState) {
            	// TODO Auto-generated method stub
            	super.onRestoreInstanceState(savedInstanceState);
            	p =    (String) savedInstanceState.getSerializable("starttime");
            	     Bundle viewHierarchy = savedInstanceState
            	                .getBundle("android:viewHierarchyState");
            	        if (viewHierarchy != null) {
            	            SparseArray views = viewHierarchy.getSparseParcelableArray("android:views");
            	            if (views != null) {
            	                for (int i = 0; i < views.size(); i++) {
            	                   Log.v("TAG", "value --> " + views.valueAt(i));
            	               }
            	          }
            	       } else {
            	          Log.v("TAG", "no view data");
            	     }
//                  super.onRestoreInstanceState(savedInstanceState);
//            	     Log.v("TAG", "Inside of onRestoreInstanceState");
//            	 
//                Log.v("TAG", "Inside of onRestoreInstanceState");
//                startTime = (Calendar) savedInstanceState.getSerializable("starttime");
            	
            }
              
}
/*
 * 
 * Allowed Bundle Value Types
boolean
boolean[ ]
Bundle (yes – store a Bundle in a Bundle)
byte
byte[ ]
char
char[ ]
CharSequence
CharSequence[ ]
ArrayList<CharSequence>
double
double[ ]
float
float[ ]
int
int [ ]
ArrayList<Integer>
long
long[ ]
Serializable
short
short[ ]
SparseArray – a map of integer to Object and is more efficient than a HashMap.  Used more internally by Android (see below)
String
String[ ]
ArrayList<String>
 */
 