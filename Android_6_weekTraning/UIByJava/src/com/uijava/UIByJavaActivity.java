package com.uijava;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UIByJavaActivity extends Activity {
	
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        textView.setText("Hello");
        textView.setTextColor(Color.GREEN);
        textView.setTextSize(20);
        
        Button button = new Button(this);
        button.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        button.setText("Click!!!");
        button.setTextColor(Color.BLUE);
        
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(UIByJavaActivity.this, "hiiiiiii", 3000).show();
			}
		});
        
        linearLayout.addView(textView);
        linearLayout.addView(button);
        setContentView(linearLayout);
    }
}