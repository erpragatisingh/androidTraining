package com.example.parcel;

import android.os.Parcelable;



	
	public class abc implements Parcelable{
      	 private int mData;
      	 

  		

		@Override
  		public int describeContents() {
  			// TODO Auto-generated method stub
  			return 0;
  		}
		@Override
		public void writeToParcel(android.os.Parcel dest, int flags) {
			// TODO Auto-generated method stub
			dest.writeInt(mData);
			
		}
  		
		public abc(){}
  	public static final Parcelable.Creator<abc> creator = new Parcelable.Creator<abc>() {

  		
		


		@Override
		public abc createFromParcel(android.os.Parcel source) {
			// TODO Auto-generated method stub
			return new abc(source);
		}

		@Override
		public abc[] newArray(int size) {
			// TODO Auto-generated method stub
			return new abc[size];
		}
  	};	
  	private abc(android.os.Parcel source) {
		// TODO Auto-generated constructor stub
		 mData = source.readInt();
		 System.out.println(888);
	}

	}

       
	


