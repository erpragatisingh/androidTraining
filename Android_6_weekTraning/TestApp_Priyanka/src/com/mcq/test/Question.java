package com.mcq.test;

import android.graphics.Bitmap;
import android.os.*;

public class Question implements Parcelable {
	String ques_imageURL=null;
	Bitmap ques_image=null;
	String solution_imageURL=null;
	String solution=null;
	Bitmap solution_image=null;
	String saved=null;
	String selected_option=null;
	String current=null;	
	String id=null;
	String type=null;
	String marks=null;
	public Question(Parcel in){
		readFromParcel(in);
	}
	Question(String id , String marks, String type ,String ques_imageURL,String solution_imageURL,String solution){
		this.id=id;
		this.marks=marks;
		this.type=type;
		this.ques_imageURL=ques_imageURL;
		this.solution_imageURL=solution_imageURL;
		this.solution=solution;
	}
	
	String getId(){
		return id;
	}
	void setId(String id){
		this.id=id;
	}
	
	String getMarks(){
		return marks;
	}
	void setMarks(String marks){
		this.marks=marks;
	}
	
	String getType(){
		return type;
	}
	void setType(String type){
		this.type=type;
	}
	
	String getQues_imageURL(){
		return ques_imageURL;
	}
	
	void setQues_imageURL(String ques_imageURL){
		this.ques_imageURL=ques_imageURL;
	}
	
	String getSolution_imageURL(){
		return solution_imageURL;
	}
	
	void setSolution_imageURL(String solution_imageURL){
		this.solution_imageURL = solution_imageURL;
	}
	
	String getSolution(){
		return solution;
	}
	
	void setSolution(String solution){
		this.solution=solution;
	}
	
	Bitmap getQues_image(){
		return ques_image;
	}
	
	void setQues_image(Bitmap ques_image){
		this.ques_image = ques_image;
	}
	
	Bitmap getSolution_image(){
		return solution_image;
	}
	
	void setSolution_image(Bitmap solution_image){
		this.solution_image = solution_image;
	}
	
	String getSaved(){
		return saved;
	}
	
	void setSaved(String saved){
		this.saved=saved;
	}
	
	String getSelected_option(){
		return selected_option;
	}
	
	void setSelected_option(String selected_option){
		this.selected_option=selected_option;
	}
	
	String getCurrent(){
		return current;
	}
	
	void setCurrent(String current){
		this.current=current;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(id);
		parcel.writeString(marks);
		parcel.writeString(current);
		parcel.writeString(selected_option);
		parcel.writeString(ques_imageURL);
		parcel.writeString(saved);
		parcel.writeString(solution_imageURL);
		parcel.writeString(type);
		parcel.writeString(solution);
		
		
		
	}
	private void readFromParcel(Parcel in) {
	      this.id = in.readString();
	      this.marks=in.readString();
	      this.current=in.readString();
	      this.selected_option=in.readString();
	      this.ques_imageURL=in.readString();
	      this.saved=in.readString();
	      this.solution_imageURL=in.readString();
	      this.type=in.readString();
	      this.solution=in.readString();
	    
	   }
	public static final Creator<Question> CREATOR = new Creator<Question>() {

	      public Question createFromParcel(Parcel source) {
	         return new Question(source);
	      }

	      public Question[] newArray(int size) {
	         return new Question[size];
	      }
	 };

}
