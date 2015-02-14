package com.example.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
public class JSON extends Activity {
	static InputStream content= null;
	static String result = "";
	static JSONObject jArray= null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		new Thread(){
			public void run() {
				JSONObject obj= readTwitterFeed();
				System.out.println(obj);
				writeJSON();
			};
		}.start();
	}

	// the first part makes the HTTP call
	//  the second part converts the stream into a String
	//  the third part converts the string to a JSONObject
	public void writeJSON() {
		JSONObject object = new JSONObject();
		try {
			object.put("name", "Jack Hack");
			object.put("score", new Integer(200));
			object.put("current", new Double(152.32));
			object.put("nickname", "Hacker");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println(object);
	} 
	public static JSONObject readTwitterFeed() {
		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet("http://api.geonames.org/postalCodeSearchJSON?formatted=true&postalcode=9791&maxRows=10&username=demo&style=full");

			HttpResponse response = client.execute(httpGet);


			HttpEntity entity = response.getEntity();// to convert special char in to readable form like %
			content = entity.getContent();
			System.out.println(entity);
			System.out.println(response);
			System.out.println(client);
			System.out.println(httpGet);
			System.out.println(content);
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
			StringBuilder builder = new StringBuilder(); // to manupulate string like if want to extract particular string from a string then use string builder
			String line= null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			content.close();
			result=builder.toString();
			System.out.println(result);

		} catch (Exception e) {

			Log.e("log_tag", "Error converting result "+e.toString());

		}
		try{
			JSONObject jArray = new JSONObject(result);
			System.out.println(jArray);
		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());

		}
		return jArray;

	}}


