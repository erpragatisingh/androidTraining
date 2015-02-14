package com.example.fragmentsdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi")
public class MyFragment extends Fragment{
	MyListner listner;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View inflate = inflater.inflate(R.layout.over_layout, container, false);
		Button button = (Button)inflate.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateData();
			}
		});
		return inflate;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof MyListner) {
			listner = (MyListner)activity;
		}
	}
	
	interface MyListner {
		void onSelected(String link);
	}
	
	public void updateData(){
		listner.onSelected(System.currentTimeMillis()+"");
	}
	
}
