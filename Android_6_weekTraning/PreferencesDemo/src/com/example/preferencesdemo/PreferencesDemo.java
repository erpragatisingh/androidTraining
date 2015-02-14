package com.example.preferencesdemo;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PreferencesDemo extends Activity {
	 SharedPreferences preferences;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_demo);
        Button button = (Button) findViewById(R.id.button1);
        // Initialize preferences
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            String username = preferences.getString("username", "nikhil");
            String password = preferences.getString("password", "n/a");
            showPrefse(username, password);
          }
        });
        Button buttonChangePreferences = (Button) findViewById(R.id.button2);
        buttonChangePreferences.setOnClickListener(new OnClickListener() {
          public void onClick(View v) {
            
            updatePreferenceValue();
          }
        });
      }
      
      private void showPrefse(String username, String password){
        Toast.makeText(PreferencesDemo.this,
            "Input: " + username + " and password: "
                + password, Toast.LENGTH_LONG).show();

      }
      
      private void updatePreferenceValue(){
        Editor edit = preferences.edit();
        String username = preferences.getString("username", "n/a");
        // We will just revert the current user name and save again
        StringBuffer buffer = new StringBuffer();
        for (int i = username.length() - 1; i >= 0; i--) {
          buffer.append(username.charAt(i));
        }
        edit.putString("username", buffer.toString());
        edit.commit();
        // A toast is a view containing a quick little message for the
        // user. We give a little feedback
        Toast.makeText(PreferencesDemo.this,
            "Reverted string sequence of user name.",
            Toast.LENGTH_LONG).show();
      } 
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_preferences_demo, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	  switch (item.getItemId()) {
    	  // We have only one menu option
    	  case R.id.menu_settings:
    	    // Launch Preference activity
    	    Intent i = new Intent(PreferencesDemo.this, second.class);
    	    startActivity(i);
    	    // Some feedback to the user
    	    Toast.makeText(PreferencesDemo.this, "Enter your user credentials.",
    	      Toast.LENGTH_LONG).show();
    	    break;

    	  }
    	  return true;
    	} 
}
