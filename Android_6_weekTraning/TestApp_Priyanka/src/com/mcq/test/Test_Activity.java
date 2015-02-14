package com.mcq.test;

import java.util.ArrayList;
import android.os.*;

public class Test_Activity implements Parcelable{
	String id=null;
	String name=null;
	String type=null;
	String subject=null;
	String total_questions=null;
	ArrayList<Question> ques_list =new ArrayList<Question>();
	Test_Activity(String id, String name, String type, String subject, String total_questions, ArrayList<Question> ques_list){
		this.id=id;
		this.name=name;
		this.type=type;
		this.subject=subject;
		this.total_questions=total_questions;
		this.ques_list = ques_list;
		
	}
	
	
	public Test_Activity(Parcel source) {
		readFromParcel(source);
	}

	
	String getId(){
		return id;
	}
	
	ArrayList<Question> getQues_list(){
		return ques_list;
	}
	
	void setQues_list(ArrayList<Question> ques_list){
		this.ques_list=ques_list;
	}
	void setId(String id){
		this.id=id;
	}
	String getName(){
		return name;
	}
	void setName(String name){
		this.name=name;
	}
	String getType(){
		return type;
	}
	
	void setType(String type){
		this.type=type;
		
	}
	String getSubject(){
		return subject;
	}
	void setSubject(String subject){
		this.subject=subject;
	}
	
	String getTotal_questions(){
		return total_questions;
	}
	
	void setTotal_questions(String total_questions){
		this.total_questions=total_questions;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(name);
		dest.writeString(subject);
		dest.writeString(total_questions);
		dest.writeString(type);
		dest.writeTypedList(ques_list);
		
	}
	
	
	public void readFromParcel(Parcel in){
		this.id=in.readString();
		this.name=in.readString();
		this.subject=in.readString();
		this.total_questions=in.readString();
		this.type=in.readString();
		in.readTypedList(ques_list,Question.CREATOR);
	}
	public static final Parcelable.Creator<Test_Activity> CREATOR = new Parcelable.Creator<Test_Activity>() {
	    public Test_Activity[] newArray(int size) {
	    return new Test_Activity[size];
	    }

	    public Test_Activity createFromParcel(Parcel source) {
			return new Test_Activity(source);
	    }
	};
	
	

}
