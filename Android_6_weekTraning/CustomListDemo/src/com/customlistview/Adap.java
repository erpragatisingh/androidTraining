package com.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adap extends BaseAdapter{
	Context c11;
	String[] s11;
	String[] s22;
	LayoutInflater l1;
	
	public Adap(Context c1, String[] s1, String[] s2) {
		// TODO Auto-generated constructor stub
		c11=c1;
		s11=s1;
		s22=s2;
		l1= ((Activity)c11).getLayoutInflater();
		
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return s11.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView= l1.inflate(R.layout.list_row, null);
		ImageView i1= (ImageView)convertView.findViewById(R.id.image);
		TextView textView = (TextView)convertView.findViewById(R.id.text1);
		TextView textView2 = (TextView)convertView.findViewById(R.id.text2);
		textView.setText(s11[position]);
		textView2.setText(s22[position]);
		i1.setBackgroundResource(R.drawable.icon);
	//	convertView.setTag();
		return convertView;
	}

}
