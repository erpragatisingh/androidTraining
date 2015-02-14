package com.example.broadcastdemocustom;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Broadcast extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }
        @Override
        public void onResume() {
          super.onResume();

          // Register mMessageReceiver to receive messages.
          LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
              new IntentFilter("my-event"));
         
        }

        // handler for received Intents for the "my-event" event 
        private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
          @Override
          public void onReceive(Context context, Intent intent) {
            // Extract data included in the Intent
            String message = intent.getStringExtra("message");
            Log.d("receiver", "Got message: " + message);
            Toast.makeText(context, message, 3000).show();
          }
        };

        @Override
        protected void onPause() {
          // Unregister since the activity is not visible
          LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
          super.onPause();
        } 
        // This method is assigned to button in the layout
        // via the onClick property
        public void onClick(View view) {
          sendMessage();
        }

        // Send an Intent with an action named "my-event". 
        private void sendMessage() {
          Intent intent = new Intent("my-event");
          // Add data
          intent.putExtra("message", "data123");
          LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } 
        
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_broadcast, menu);
        return true;
    }
}
