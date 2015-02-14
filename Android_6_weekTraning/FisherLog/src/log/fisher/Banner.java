package log.fisher;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.format.Time;
import android.widget.TextView;

public class Banner extends Activity {

	TextView srk;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banner);
		srk=(TextView) findViewById(R.id.textView2);
		String s = "<p style='font-family:Broadway'><b><i>WHITE SHARK</i></b></p>";
		srk.setText(Html.fromHtml(s));
		TimerTask ta=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent it=new Intent(Banner.this,Gridfisher.class);
				startActivity(it);
			}
		};
		Timer t=new Timer();
		t.schedule(ta, 5000);
	}

}
