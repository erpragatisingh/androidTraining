package ramansingh.readwebpageasynctask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.Protectable;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.R.string;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
setContentView(R.layout.activity_main);
tv= (TextView) findViewById(R.id.textView1);

	}
	
	private class Downloadwebpagetask extends AsyncTask<string, Void, String>{
		@Override
		protected String doInBackground(string...urls){
			String response="";
			for(String url : urls){
				DefaultHttpClient client= new DefaultHttpClient();
				HttpGet httpGet=new HttpGet(url);
				try{
					HttpResponse execute=client.execute(httpGet);
					InputStream content = execute.getEntity().getContent();
					
					BufferedReader buffer=new BufferedReader(new InputStreamReader(content));
					String s="";
					while((s=buffer.readLine())!=null);
					response +=s;
					
				}
				catch(Exception e){
					e.printStackTrace();
					
				}
			}
			return response;
			
		}
		protected void onPostExecute(string result){
			tv.setText(result);
			
			
		}
		public void execute(String[] strings) {
			// TODO Auto-generated method stub
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

public void readwebpage(View v){
	Downloadwebpagetask task = new Downloadwebpagetask();
	task.execute(new String[]{"htp://www.gogle.com"});
	
}}
