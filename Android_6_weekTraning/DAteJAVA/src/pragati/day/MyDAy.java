/**
 * 
 */
package pragati.day;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wahiguru
 *
 */
public class MyDAy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date1 = df.parse("10/08/2013");
		    Date date2 = df.parse("21/08/2013");
		    Calendar cal1 = Calendar.getInstance();
		    Calendar cal2 = Calendar.getInstance();
		    cal1.setTime(date1);
		    cal2.setTime(date2);
		    int numberOfDays = 0;
		    while (cal1.before(cal2)) {
		        if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK))
		           &&(Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
		            numberOfDays++;
		            cal1.add(Calendar.DATE,1);
		        }else {
		            cal1.add(Calendar.DATE,1);
		        }
		    }
		    System.out.println(numberOfDays);
		} catch (Exception e) {
			// TODO: handle exception
		}
	    

	   
		

	}

	
	 
	
}
