package android.mypack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class FirstAct extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView dDate=(TextView)findViewById(R.id.textView1);
        DatePicker dp=(DatePicker)findViewById(R.id.datePicker1);
        TimePicker a=(TimePicker) findViewById(R.id.timePicker1);
        dDate.setText("Date Default: "+dp.getMonth()+" - "+dp.getDayOfMonth()+" - "+dp.getYear());
     
        
        
        // dp.init(1987, 12, 04, null);
   
}
    }