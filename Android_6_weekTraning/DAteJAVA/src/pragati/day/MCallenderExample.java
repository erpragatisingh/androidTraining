package pragati.day;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MCallenderExample {
	
	
	  public static void main(String args[]) {
	        //getting local time, date, day of week and other details in local timezone
	        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
	      
	        Date currentTime = localCalendar.getTime();
	        int currentDay = localCalendar.get(Calendar.DATE);
	        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
	        int currentYear = localCalendar.get(Calendar.YEAR);
	        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
	        int currentDayOfMonth = localCalendar.get(Calendar.DAY_OF_MONTH);
	        int CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);

	        System.out.println("Current Date and time details in local timezone");
	        System.out.println("Current Date: " + currentTime);
	        System.out.println("Current Day: " + currentDay);
	        System.out.println("Current Month: " + currentMonth);
	        System.out.println("Current Year: " + currentYear);
	        System.out.println("Current Day of Week: " + currentDayOfWeek);
	        System.out.println("Current Day of Month: " + currentDayOfMonth);
	        System.out.println("Current Day of Year: " + CurrentDayOfYear);

	      
	      
	        //getting time, date, day of week and other details in GMT timezone
	        Calendar gmtCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	        //rest of stuff are same
	    }


}
