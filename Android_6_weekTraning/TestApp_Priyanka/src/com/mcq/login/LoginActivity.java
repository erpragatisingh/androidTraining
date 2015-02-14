package com.mcq.login;



import java.io.IOException;
import java.net.MalformedURLException;

import com.mcq.test.TestAppActivity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends FacebookActivity{
	Context context=this;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	        final EditText email_et=(EditText)findViewById(R.id.user_email);
	        final EditText password_et=(EditText)findViewById(R.id.user_password);
	        final Button login= (Button)findViewById(R.id.submit_button);
	        final Button register = (Button)findViewById(R.id.register_button);
	        final Button fb_login=(Button) findViewById(R.id.fb_login);
	       // final Button fb_logout=(Button) findViewById(R.id.fb_logout);
	        final ProgressBar pb = (ProgressBar) findViewById(R.id.pb_bar);
	        fb_login.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					 pb.setVisibility(ProgressBar.VISIBLE);
					 setConnection();
			         getID(pb);
			        // publishOnWall();
			         
					
				}
	        	
	        });
	        
	      /*  fb_logout.setOnClickListener(new OnClickListener(){

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
					
				}
	        	
	        });*/
	        login.setOnClickListener(new OnClickListener(){
	        	
				@Override
				public void onClick(View v) {
					String email=email_et.getText().toString();
				
					String password=password_et.getText().toString();
					 UsersDatabaseHandler dh= new UsersDatabaseHandler(context);
					   User u1 = dh.getContact(email,password);
					   if (u1 != null){
						   Intent i = new Intent(context,com.mcq.test.TestAppActivity.class);
							storeInSharedPreferences(u1);
							
							startActivity(i);
					   }
					   else{
						   StringBuilder s = new StringBuilder();
							s.append("Invalid email or password!"); 
							
							Toast.makeText(getBaseContext(), s, 1000).show();
					   }
				}
	        });
	        
	        register.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					 Intent i = new Intent(context,RegisterActivity.class);
					 startActivity(i);
					
				}
	        	
	        });
	        
	        
				
}
	 void  storeInSharedPreferences(User u){
		   SharedPreferences shp=getSharedPreferences("TEXT", 0);
		    final Editor et=shp.edit();
		    et.putString("name", u.name);
		    et.putString("email", u.email);
		    et.putString("phone", u.phone);
		    et.putString("password", u.password);
		    et.putString("address", u.address);
		    et.commit();
			
		}
	   
	 
}
