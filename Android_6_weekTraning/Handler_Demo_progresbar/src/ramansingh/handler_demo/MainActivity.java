package ramansingh.handler_demo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
private Handler h;
private ProgressBar pb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pb= (ProgressBar) findViewById(R.id.progressBar1);
		h=new Handler();
		
		
	}
	
	public void startProgres(View v){
		Runnable r =new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				
					for(int i=0; i<=10;i++){
						final int value=i;
						try{
							Thread.sleep(3000);
							
						}catch(InterruptedException e){
							e.printStackTrace();
							
						}
						
						h.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								pb.setProgress(value);
								
							}
						});
					}
				}
		
		};

		new Thread(r).start();
	}}