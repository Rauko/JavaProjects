package clocktask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {
	public static void main(String[] args){
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("TestBundle", defaultLocale);
		displayValues(bundle);

    }
	
	public static void displayValues(ResourceBundle bundle){
        if (Locale.getDefault() != Locale.ENGLISH){
        	DateFormat dateFormat = new SimpleDateFormat("HH");
            Date date = new Date();
            int currentHour = Integer.parseInt(dateFormat.format(date));
            if(currentHour >= 6 && currentHour < 9){
            	System.out.println(bundle.getString("my.morning"));
            } else if (currentHour >= 9 && currentHour < 19){
            	System.out.println(bundle.getString("my.day"));
            } else if (currentHour >= 19 && currentHour < 23){
            	System.out.println(bundle.getString("my.evening"));
            } else System.out.println(bundle.getString("my.night"));
        }
	}
}