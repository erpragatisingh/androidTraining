package com.test.ui;

public class Weather {
	int icon;
	String text;
	Weather(int icon,String text){
		this.icon=icon;
		this.text=text;
	}
	
	int getIcon()
	{
		return icon;
	}
	void setIcon(int icon){
		this.icon=icon;
	}
	
	String getText(){
		return text;
		
	}
	
	void setText(String text){
		this.text=text;
	}


}
