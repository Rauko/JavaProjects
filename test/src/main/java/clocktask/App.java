package clocktask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class App {
	
	private static final Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args){
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("TestBundle", defaultLocale);
		log.info("Default locale is " + defaultLocale);
		display(bundle, getMyDayPeriod(getCurrentTime(bundle)));
    }

	public static void display(ResourceBundle bundle, String message){
		System.out.println(bundle.getString(message));
		log.info("Program replied : " + bundle.getString(message));
	}
	
	public static int getCurrentTime(ResourceBundle bundle){
		DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        Integer currentHour = Integer.parseInt(dateFormat.format(date));
        return currentHour;
	}
	
	public static String getMyDayPeriod(int currentHour) {
	        String dayPeriod;
	        if(currentHour >= 6 && currentHour < 9){
	        	dayPeriod = "my.morning";
	        } else if (currentHour >= 9 && currentHour < 19){
	        	dayPeriod = "my.day";
	        } else if (currentHour >= 19 && currentHour < 23){
	        	dayPeriod = "my.evening";
	        } else {
	        	dayPeriod = "my.night";
	        }
	        return dayPeriod;
	}
}