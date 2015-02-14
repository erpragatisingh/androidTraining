package com.example.androiddbconnection;

public class ModelClass {

	public String gettourname() {
		return tourname;
		}
		public void settourname(String tourname) {
		this.tourname = tourname;
		}
		
		public int getImageNumber() {
		return imageNumber;
		}
		public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
		}
		public String getPrice(){
			return price;
		}
		public void setPrice(String tourPrice) {
			this.price = tourPrice;
		}
		
		private String tourname ;
		private int imageNumber;
		private String price;

}
