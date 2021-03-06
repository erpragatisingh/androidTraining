package com.example.attendancemaster;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class UpdateTimeTable extends TabActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updmenu);
		TabHost tabhost=getTabHost();
		TabSpec mon = tabhost.newTabSpec("M");
		mon.setIndicator("M",getResources().getDrawable(android.R.drawable.ic_dialog_alert));
		Intent monIntent=new  Intent(this,UpdateMon.class);
		mon.setContent(monIntent);
		
		//tab for songs
		TabSpec tues=tabhost.newTabSpec("T");
		//setting title and icon for tab
		tues.setIndicator("T",getResources().getDrawable(android.R.drawable.ic_dialog_dialer));
		Intent tuesIntent=new Intent(this,UpdateTues.class);
		tues.setContent(tuesIntent);
		
		//tab for videos
		TabSpec wed=tabhost.newTabSpec("W");
		wed.setIndicator("W", getResources().getDrawable(android.R.drawable.ic_dialog_email));
		Intent wedIntent=new Intent(this,UpdateWed.class);
		wed.setContent(wedIntent);
		
		TabSpec thur = tabhost.newTabSpec("T");
		thur.setIndicator("T",getResources().getDrawable(android.R.drawable.ic_dialog_alert));
		Intent thurIntent=new  Intent(this,UpdateThur.class);
		thur.setContent(thurIntent);
		
		//tab for songs
		TabSpec fri=tabhost.newTabSpec("F");
		//setting title and icon for tab
		fri.setIndicator("F",getResources().getDrawable(android.R.drawable.ic_dialog_dialer));
		Intent friIntent=new Intent(this,UpdateFri.class);
		fri.setContent(friIntent);
		
		//tab for videos
		TabSpec sat=tabhost.newTabSpec("S");
		sat.setIndicator("S", getResources().getDrawable(android.R.drawable.ic_dialog_email));
		Intent satIntent=new Intent(this,UpdateSat.class);
		sat.setContent(satIntent);
		
		//adding all tabspec to tabhost
		tabhost.addTab(mon);
		tabhost.addTab(tues);
		tabhost.addTab(wed);
		tabhost.addTab(thur);
		tabhost.addTab(fri);
		tabhost.addTab(sat);
	}
}
