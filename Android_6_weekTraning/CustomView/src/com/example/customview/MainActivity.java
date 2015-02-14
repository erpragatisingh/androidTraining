package com.example.customview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	HeroInfoControl heroLuna;
    HeroInfoControl heroTiny;
    HeroInfoControl heroKael;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroLuna = (HeroInfoControl)findViewById(R.id.heroLuna);
        heroLuna.setHeroIcon(getResources().getDrawable(R.drawable.mir));
        heroLuna.setHeroTitle(getResources().getDrawable(R.drawable.mir));
        heroLuna.setHeroName("Luna Moonfang");
 
        heroTiny = (HeroInfoControl)findViewById(R.id.heroTiny);
        heroTiny.setHeroIcon(getResources().getDrawable(R.drawable.ic_launcher));
        heroTiny.setHeroTitle(getResources().getDrawable(R.drawable.ic_launcher));
        heroTiny.setHeroName("Tiny");
 
        heroKael = (HeroInfoControl)findViewById(R.id.heroKael);
        heroKael.setHeroIcon(getResources().getDrawable(R.drawable.ic_launcher));
        heroKael.setHeroTitle(getResources().getDrawable(R.drawable.ic_launcher));
        heroKael.setHeroName("Kael");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
