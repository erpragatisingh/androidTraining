

package com.splash;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotifyActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    TextView txt=new TextView(this);
    
    txt.setText("You have successfully Recieved the Alarm!");
    setContentView(txt);
  }
}
