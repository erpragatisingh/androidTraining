package com.mcq.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.mcq.login.FacebookActivity;
import com.mcq.login.LoginActivity;
import com.mcq.login.R;
import com.mcq.login.User;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ActivityTest  extends FacebookActivity{
	ArrayList<Question> ques_list = new ArrayList<Question>();
	TextView ques_type=null;
	TextView ques_marks=null;
	ImageView ques_image=null;
	RadioGroup ans_grp=null;
	Button save_btn=null;
	Button prev_btn=null;
	Button next_btn=null;
	Button submit_btn=null;
	Button logout_btn=null;
	int current_position=0;
	Test_Activity activity=null;
	Context context=this;
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 ArrayList<String> imgToDownload=new ArrayList<String>();
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.ques_item);
	     setLoginHeader();
	     ques_type=(TextView)findViewById(R.id.ques_type);
	     ques_marks=(TextView)findViewById(R.id.ques_marks);
	     ques_image=(ImageView)findViewById(R.id.ques_img);
	     ans_grp=(RadioGroup)findViewById(R.id.radio_ans);
	     prev_btn=(Button)findViewById(R.id.btn_prev);
	     next_btn=(Button)findViewById(R.id.btn_next);
	     submit_btn=(Button)findViewById(R.id.submit_btn);
	     logout_btn=(Button)findViewById(R.id.logout_btn);
	     reset_current_position();
	     setPrevBtnHandler(prev_btn);
	     setNextBtnHandler(next_btn);
	     setAns_grpHandler(ans_grp);
	     setSubmit_BtnHandler(submit_btn);	
	     setLogout_BtnHandler(logout_btn);
	     setLoginHeader();
	     activity=  getIntent().getExtras().getParcelable("activity");
	     ques_list=activity.ques_list;
	     for(int i =0;i< ques_list.size();i++){
	       if(i==0)
	    	   ques_list.get(i).setCurrent("true");
	       else
	    	   ques_list.get(i).setCurrent("false");
	       imgToDownload.add(ques_list.get(i).ques_imageURL);
	       imgToDownload.add(ques_list.get(i).solution_imageURL);
	     }
	     DownloadImage d= new DownloadImage();	           
	     d.execute( imgToDownload.toArray(new String[imgToDownload.size()]));
	 }
	 
	/* @Override
	 public void onPause(){
			NotificationManager notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.cloudy,
				"A new notification", System.currentTimeMillis());
		// Hide the notification after its selected
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		Intent intent = new Intent(this, ActivityTest.class);
		intent.putExtra("activity", activity);
		intent.putExtra("current_position", current_position);
		PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "Your test activity is pending!",
				"Resume activity",activity);
		notification.number += 1;
		notificationManager.notify(0, notification);
		super.onPause();
		 
	 }*/
	 
	/* @Override
	 public void onRestart(){
		
			if(getIntent().getExtras().get("current_position") != null)
			current_position=(Integer)getIntent().getExtras().get("current_position");
			super.onRestart();
		 
	 }*/
	 
	/*@Override
	 public void onResume(){
		NotificationManager notificationManager = (NotificationManager) 
				getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(0);
		super.onResume();
		//if(getIntent().getExtras().get("current_position") != null)
		//current_position=(Integer)getIntent().getExtras().get("current_position");
		activity=(Test_Activity)getIntent().getExtras().get("activity");
		
				setQuestion();
				setPrevBtn();
				setNextBtn();
			
		 
	}*/
	 
	 void setLoginHeader(){
	   	User u=getFromSharedPreferences();
	   	TextView tv_name= (TextView)findViewById(R.id.user_name_header);
	    tv_name.setText("Hi " + u.getName() +"!"+"\n"+ "You are logged in as "+ u.getEmail() +".");
	 }
	    
	 User getFromSharedPreferences(){
		SharedPreferences shp=getSharedPreferences("TEXT", 0);
		String name=shp.getString("name", "");
		String email=shp.getString("email","");
		String phone=shp.getString("phone","");
		String password=shp.getString("password", "");
		String address=shp.getString("address", "");
		User u = new User(name,email,phone,password,address);
		return u;
	}

	 void reset_current_position(){
		 current_position=0;
	 }
	 
	 void setLogout_BtnHandler(Button logout){
		 logout.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					try {
						setConnection();
						logout();
						
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					SharedPreferences sharedPrefs =	getSharedPreferences("TEXT", 0);
			    	 sharedPrefs.edit().putString("name", null)
			                 .commit();
			    	 sharedPrefs.edit().putString("email", null).commit();
			    	 sharedPrefs.edit().putString("phone", null).commit();
			    	 sharedPrefs.edit().putString("password", null).commit();
			    	 sharedPrefs.edit().putString("address", null).commit();
			    	 Intent i=new Intent(context,LoginActivity.class);
					 startActivity(i);
					
				}
	        	
	        });
	
		 }

	 void setSubmit_BtnHandler(Button submit){
		submit_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i=new Intent(context,SubmitTest.class);
				i.putExtra("activity",activity);				
				startActivity(i);
			}
			
		});
		 
	 }
	 void setAns_grpHandler(RadioGroup ans_grp){
		 ans_grp.setOnCheckedChangeListener(new OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(RadioGroup arg0, int arg1) {
					Log.i("inside handler,current_position:",String.valueOf(current_position));
					Log.i("argument passed:",String.valueOf(arg1));
					switch(arg1){
						case R.id.choice_a: ques_list.get(current_position).setSelected_option("A");break;										 
						case R.id.choice_b: ques_list.get(current_position).setSelected_option("B"); break;
						case R.id.choice_c: ques_list.get(current_position).setSelected_option("C"); break;
						case R.id.choice_d: ques_list.get(current_position).setSelected_option("D"); break;
					}
				
				}				
		});
	 }
	 
	
	 void setPrevBtnHandler(Button prev){
		prev.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Button prev=(Button) arg0;
				current_position-- ;
				setPrevBtn();
				setNextBtn();
				setQuestion();
				setAns_grp();	
				Log.i("prev:", String.valueOf(current_position));
			}
		});
		 
	 }
	 void setNextBtnHandler(Button next){
		next.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Button next=(Button)v;
					++current_position ;
					setPrevBtn();
					setNextBtn();	
					setQuestion();
					setAns_grp();
					Log.i("next:", String.valueOf(current_position));
				}
				
		});
	 }
	 void setNextBtn(){
		 if(current_position < ques_list.size()-1)
			next_btn.setEnabled(true);							
		else							
			next_btn.setEnabled(false);	
	 }
	 void setPrevBtn(){
		 if(current_position > 0)
			prev_btn.setEnabled(true);
		 else							
			prev_btn.setEnabled(false);
	 }
	 void setQuestion(){
		 ques_type.setText("Type: "+ques_list.get(current_position).getType());
		 ques_marks.setText("Marks: "+ques_list.get(current_position).getMarks());
		 ques_image.setImageBitmap(ques_list.get(current_position).getQues_image());
	 }
	
	 void setAns_grp(){
		 String option=ques_list.get(current_position).getSelected_option();
		 Log.i("current_position:",String.valueOf(current_position));
		 if(option!=null)
		 Log.i("option:",option);
		 ans_grp.setOnCheckedChangeListener(null);
		 ans_grp.clearCheck();
		 setAns_grpHandler(ans_grp);
		if(option!=null && option.equalsIgnoreCase("A"))
			ans_grp.check(R.id.choice_a);
		else
			if(option != null && option.equalsIgnoreCase("B"))
				ans_grp.check(R.id.choice_b);
			else
				if(option != null && option.equalsIgnoreCase("C"))
					ans_grp.check(R.id.choice_c);
				else
					if(option != null && option.equalsIgnoreCase("D"))
						ans_grp.check(R.id.choice_d);		
	 }
	 public class DownloadImage extends AsyncTask<String, Void, HashMap<String,Bitmap>> {
			ProgressDialog  a;
			HashMap<String,Bitmap> img_map = new HashMap<String,Bitmap>();
			@Override
			protected HashMap<String,Bitmap> doInBackground(String... arg0) {
				Bitmap bmImg=null;
			    URL myFileUrl =null;  
				for(int i=0;i<arg0.length;i++){
				  System.out.println(arg0[i].toString());
				  bmImg=null;
				  myFileUrl =null;          
				  try {
				        myFileUrl= new URL(arg0[i]);
				  }
				  catch (MalformedURLException e) {
					  	e.printStackTrace();
				  }
				  try {
				        HttpURLConnection conn= (HttpURLConnection)myFileUrl.openConnection();
				        conn.setDoInput(true);
				        conn.connect();
				        InputStream is = conn.getInputStream();
				        bmImg = BitmapFactory.decodeStream(is);
			
				  }
				  catch (IOException e) {
				      e.printStackTrace();
				  }
				  img_map.put(arg0[i], bmImg);
				 }
				return img_map;
			}
			@Override
			protected void onPostExecute(HashMap<String,Bitmap> bmp){
				System.out.println("Inside onPostExecute");
				Bitmap ques_img=null;
				Bitmap solution_img=null;
				for(int i=0;i<ques_list.size();i++){
					ques_img=null;
					solution_img=null;
					String ques_url=(String)ques_list.get(i).ques_imageURL;
					String solution_url=(String)ques_list.get(i).solution_imageURL;
					ques_img=bmp.get(ques_url);
					solution_img=bmp.get(solution_url);
					if(ques_img!=null){
						System.out.println("Ques image not null");
						ques_list.get(i).ques_image=ques_img;
					}
					if(solution_img!=null)
						ques_list.get(i).solution_image=solution_img;
				}		
				setQuestion();
				setPrevBtn();
				setNextBtn();	
				a.dismiss();		
				super.onPostExecute(bmp);
			}
			@Override
			protected void onPreExecute(){
				a= new ProgressDialog(context);
				a.setMessage("Downloading Image");
				a.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				a.show();
				super.onPreExecute();
			}
			

		}


}


