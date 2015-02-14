package com.mcq.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class RegisterActivity extends Activity {
	Context context=this;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.register);
	        final EditText name_et=(EditText)findViewById(R.id.user_name);
	        final EditText email_et=(EditText)findViewById(R.id.user_email);
	        final EditText phone_et=(EditText)findViewById(R.id.user_phone);
	        final EditText password_et=(EditText)findViewById(R.id.user_password);
	        final EditText address_et=(EditText)findViewById(R.id.user_address);
	       final Button b= (Button)findViewById(R.id.submit_button);
	        b.setOnClickListener(new OnClickListener(){
	        	
				@Override
				public void onClick(View v) {
					String email=email_et.getText().toString();
					String name=name_et.getText().toString();
					String phone=phone_et.getText().toString();
					String password=password_et.getText().toString();
					String address=address_et.getText().toString();
					 if (email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") &&
					 name.matches("[a-zA-Z ]+")   && phone.matches("[0-9]+") )
			            {
						
						 storeViaSQLDB(name,email,phone,password,address);
						 System.out.println("Process over");
					
					Intent i = new Intent(context,LoginActivity.class);
					
					startActivity(i);
			            }
					 else
					 {
						 StringBuilder s = new StringBuilder();
						 
						 if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) 
							s.append("Please Enter a Valid Email Id.\n");
						if(! name.matches("[a-zA-Z ]+")) 
							s.append("Please Enter a Valid Name.\n");
						if(!phone.matches("[0-9]+"))
							s.append("Please Enter a valid phone number.\n");
						Toast.makeText(getBaseContext(), s, 1000).show();
					}
					
					
				}
	        });

	        
	        
	 }
	 void storeViaSQLDB(String name,String email,String phone,String password,String address){
		 User u= new User(name,email,phone,password,address);
		 System.out.println("email:"+u.getEmail());
		 UsersDatabaseHandler dh= new UsersDatabaseHandler(this);
		 dh.addContact(u);
		
		 
	 }
   
   User retrieveViaSQLDB(){
	   UsersDatabaseHandler dh= new UsersDatabaseHandler(this);
	   User u1 = dh.getContact(1);
	   return u1;
   }

}
