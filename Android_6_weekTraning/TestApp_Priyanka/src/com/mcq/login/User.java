package com.mcq.login;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class User {
	
	
		String name;
		String email;
		String phone;
		String password;
		String address;
		User(){
			name=null;
			email=null;
			phone=null;
			password=null;
			address=null;
		}
		
		public User(String name,String email,String phone,String password,String address)
		{
			this.name=name;
			this.email=email;
			this.phone=phone;
			this.password=password;
			this.address=address;
		}
		public	String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name=name;
		}
		public String getEmail()
		{
			return email;
		}
		public void setEmail(String email)
		{
			this.email=email;
		}
		public String getPhone()
		{
			return phone;
		}
		public void setPhone(String phone)
		{
			this.phone=phone;
		}
		public String getPassword()
		{
			return password;
		}
		public void setPassword(String password)
		{
			this.password=password;
		}
		public String getAddress()
		{
			return address;
		}
		public void setAddress(String address)
		{
			this.address=address;
		}
		
		 
	}


