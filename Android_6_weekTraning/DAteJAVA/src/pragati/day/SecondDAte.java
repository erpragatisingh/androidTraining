package pragati.day;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondDAte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEEE");
		String text = formatter.format(cal.getTime());
System.out.println(text);


//Calendar cal=Calendar.getInstance();
//System.out.println(new SimpleDateFormat("EEE").format(cal.getTime()));



	}

}
