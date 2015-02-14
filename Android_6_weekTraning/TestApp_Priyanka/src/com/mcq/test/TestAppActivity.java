package com.mcq.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.lang.*;
import java.net.MalformedURLException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.mcq.login.LoginActivity;
import com.mcq.login.R;
import com.mcq.login.User;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TestAppActivity extends ListActivity{	
	public static final String ACTIVITY_URL = "http://173.45.228.151/Octal/activities.xml";
	public static final String ACTIVITY_TAG="activity";
	public static final String QUESTION_TAG="question";
	public static final String ACTIVITY_ID="id";
	public static final String ACTIVITY_NAME="name";
	public static final String ACTIVITY_TYPE="type";
	public static final String ACTIVITY_SUBJECT="subject";
	public static final String ACTIVITY_TOTAL_QUESTIONS="questions";
	public static final String QUESTION_ID="id";
	public static final String QUESTION_MARKS="marks";
	public static final String QUESTION_TYPE="type";
	public static final String QUESTION_IMAGE="question_image";
	public static final String QUESTION_SOLUTION="solution";
	public static final String QUESTION_OPTION="option";
	public static final String USER_NAME="name";
	public static final String USER_EMAIL="email";
	public static final String USER_PHONE="phone";
	public static final String USER_PASSWORD="password";
	public static final String USER_ADDRESS="address";	
	ArrayList<Test_Activity> activity_list = new ArrayList<Test_Activity>();
	Context context=this;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setLoginHeader();
		Button logout=(Button) findViewById(R.id.logout_btn);
		setLogout_BtnHandler(logout);
		Xml_Reader reader =new Xml_Reader();
		String xml=Xml_Reader.getXML(ACTIVITY_URL);
		Document doc=reader.XMLfromString(xml);
		NodeList activity_nodes = doc.getElementsByTagName(ACTIVITY_TAG);
		//fill in the list items from the XML document
		for (int i = 0; i < activity_nodes.getLength(); i++) {
			Element activity_element = (Element)activity_nodes.item(i);
			Test_Activity activity=getActivityFromXml(reader, activity_element);
			ArrayList<Question> ques_list = new ArrayList<Question>();
			NodeList ques_nodes = activity_element.getElementsByTagName(QUESTION_TAG);
			for(int j=0;j<ques_nodes.getLength();j++){
				Element ques_element = (Element)ques_nodes.item(j);
				Question question = getQuestionFromXml(reader, ques_element);
				ques_list.add(question);
			}
			    
			activity.ques_list=ques_list;
			activity_list.add(activity);
		}      
		Activity_ListAdapter adapter = new Activity_ListAdapter(this,R.layout.list_item,activity_list);
		setListAdapter(adapter);
	}
	

	static Test_Activity getActivityFromXml(Xml_Reader reader,Element activity_element ){
		
		String id=  activity_element.getAttribute(ACTIVITY_ID);
        String name=activity_element.getAttribute(ACTIVITY_NAME);
        String type=   activity_element.getAttribute(ACTIVITY_TYPE);
        String subject=    activity_element.getAttribute(ACTIVITY_SUBJECT);
        String total_questions=    reader.getValue(activity_element, ACTIVITY_TOTAL_QUESTIONS);
        Test_Activity activity= new Test_Activity(id,name,type,subject,total_questions,null);
		return activity;
		
	}
	
	
	static Question getQuestionFromXml(Xml_Reader reader,Element ques_element ){
		String id = ques_element.getAttribute(QUESTION_ID);
		String marks = ques_element.getAttribute(QUESTION_MARKS);
   		String type =  ques_element.getAttribute(QUESTION_TYPE);
   		String ques_imageURL = reader.getValue(ques_element,  QUESTION_IMAGE);
   		String solution_imageURL = reader.getValue(ques_element, QUESTION_SOLUTION);
   		NodeList sol_nodes = ques_element.getElementsByTagName(QUESTION_SOLUTION);
   		String solution = ((Element)sol_nodes.item(0)).getAttribute(QUESTION_OPTION);
   		Question question = new Question(id,marks,type,ques_imageURL,solution_imageURL,solution);
   		return question;  	
	}
	
	 void setLogout_BtnHandler(Button logout){
		 logout.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					SharedPreferences sharedPrefs = PreferenceManager
			                 .getDefaultSharedPreferences(context);
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

	void setLoginHeader(){
		User u=getFromSharedPreferences();
		TextView tv_name= (TextView)findViewById(R.id.user_name_header);
		TextView tv_email= (TextView)findViewById(R.id.user_email_header);
		tv_name.setText("Hi " + u.getName() +"!");
		tv_email.setText( "You are logged in as "+ u.getEmail() +".");
	}
	User getFromSharedPreferences(){
		SharedPreferences shp=getSharedPreferences("TEXT", 0);
		String name=shp.getString(USER_NAME, "");
		String email=shp.getString( USER_EMAIL,"");
		String phone=shp.getString(USER_PHONE,"");
		String password=shp.getString(USER_PASSWORD, "");
		String address=shp.getString(USER_ADDRESS, "");
		User u = new User(name,email,phone,password,address);
		return u;
	}
	
	@Override
	protected void onListItemClick (ListView l, View v, int pos, long id){
		Intent i=new Intent(context,ActivityTest.class);
		i.putExtra("activity", activity_list.get(pos));
		startActivity(i);
	}
	
public class Activity_ListAdapter extends ArrayAdapter{
	private int resource;
	@SuppressWarnings("unchecked")
	public Activity_ListAdapter(Context context, int resource,ArrayList<Test_Activity>list_activity) {
		super(context, resource, list_activity);
		this.resource=resource;
	}
	@Override
	public View getView(int position,View v,ViewGroup parent){
		ActivityHolder h;
		View row=v;
		if(row==null){
			row=((Activity)context).getLayoutInflater().inflate(resource, parent,false);
			h=new ActivityHolder();
			h.activity_id=(TextView)row.findViewById(R.id.row_id);
			h.activity_name=(TextView)row.findViewById(R.id.row_name);
			h.activity_sub=(TextView)row.findViewById(R.id.row_sub);
			h.activity_type=(TextView)row.findViewById(R.id.row_type);
			row.setTag(h);
			}
			else {
			h=	(ActivityHolder) row.getTag();
			}

		h.activity_id.setText(activity_list.get(position).id);
		h.activity_name.setText(activity_list.get(position).name);
		h.activity_sub.setText(activity_list.get(position).subject);
		h.activity_type.setText(activity_list.get(position).type);
		return row;
		}
		 class ActivityHolder
		{
			TextView activity_id;
			TextView activity_name;
			TextView activity_sub;
			TextView activity_type;
		}


	}

	
	
}
