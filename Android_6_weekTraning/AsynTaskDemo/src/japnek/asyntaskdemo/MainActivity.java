package japnek.asyntaskdemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView1);
        
    }
    private class DownloadWebPageTask extends AsyncTask<String,Void,String>{
    	
    	protected String doInBackground(String...urls){
    		String response="";
    		for(String url : urls){
    			DefaultHttpClient client=new DefaultHttpClient();
    			HttpGet httpget=new HttpGet(url);
    			try{
    				HttpResponse execute=client.execute(httpget);
    				InputStream content=execute.getEntity().getContent();
    				BufferedReader buffer=new BufferedReader(new InputStreamReader(content));
    				String s="";
    				while((s=buffer.readLine())!=null){
    					response+=s;
    				}
    				}catch (Exception e) {
						// TODO: handle exception
    					e.printStackTrace();
					}
    			}
    			return response;
    		}
    	protected void onPostExecute(String result){
    		textView.setText(result);
    	}
    }
    
    public void readWebpage(View view){
    	DownloadWebPageTask task=new DownloadWebPageTask();
    	task.execute(new String[]{"http://www.erpragatisingh.webs.com"});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
