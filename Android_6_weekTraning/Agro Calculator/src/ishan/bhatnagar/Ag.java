package ishan.bhatnagar;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class Ag extends Activity {

	Helpere hlp=new Helpere(this, "agro.db", null, 1);
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ag);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ag, menu);
		return true;
	}

}
