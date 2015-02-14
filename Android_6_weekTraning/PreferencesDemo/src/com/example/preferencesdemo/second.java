package com.example.preferencesdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class second extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref2);
    }
    
}


