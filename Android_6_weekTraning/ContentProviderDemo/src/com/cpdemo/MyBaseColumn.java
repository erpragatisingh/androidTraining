package com.cpdemo;

import android.net.Uri;
import android.provider.BaseColumns;

public class MyBaseColumn {

	public static class Users implements BaseColumns {


		public static Uri contentUri = Uri.parse("content://def");
		public static String uName = "name";
		public static String uPassword = "password"; // public means accesible to every class and static means don't have to create object of that class when using in some another class
	}

}
