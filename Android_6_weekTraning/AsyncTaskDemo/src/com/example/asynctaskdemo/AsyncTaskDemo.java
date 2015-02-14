package com.example.asynctaskdemo;

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

public class AsyncTaskDemo extends Activity {
TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_demo);
        textView = (TextView) findViewById(R.id.TextView01);
    }
    
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
    	 protected String doInBackground(String... urls) {
    	      String response = "";
    	      StringBuilder b=new StringBuilder();
    	      for (String url : urls) {
    	        DefaultHttpClient client = new DefaultHttpClient();
    	        HttpGet httpGet = new HttpGet(url);
    	        try {
    	          HttpResponse execute = client.execute(httpGet);
    	          InputStream content = execute.getEntity().getContent();

    	          BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
    	          String s = "";
    	          while ((s = buffer.readLine()) != null) {
    	        	  b.append(s);
    	        	 response= b.toString(); 
    	       //   response=  response + s;
    	          }

    	        } catch (Exception e) {
    	          e.printStackTrace();
    	        }
    	      }
    	      return response;
    	    }

    	    @Override
    	    protected void onPostExecute(String result) {
    	      textView.setText(result);
    	    }
    	  }

    	  public void onClick(View view) {
    	    DownloadWebPageTask task = new DownloadWebPageTask();
    	    task.execute(new String[] { "http://www.vogella.de" });

    	  }
    	 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_async_task_demo, menu);
        return true;
    }
}
