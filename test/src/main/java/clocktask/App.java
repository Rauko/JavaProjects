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
		ResourceBundle bundle = null;
		if (Locale.getDefault().getDisplayLanguage().equals("русский") || Locale.getDefault().getDisplayLanguage().equals("українська")) {
			bundle = ResourceBundle.getBundle("TestBundle_ru_RU", defaultLocale);
			log.info("Default locale is " + defaultLocale);
			displayValues(bundle);
	/*	} else if (Locale.getDefault().getDisplayLanguage().equals("українська")) {
			bundle = ResourceBundle.getBundle("TestBundle_ru_UA", defaultLocale);
			log.info("Default locale is " + defaultLocale);
			displayValues(bundle);	*/
		} else /* if (Locale.getDefault().getDisplayLanguage().equals("English"))*/ {
			bundle = ResourceBundle.getBundle("TestBundle_en_US", defaultLocale);
			log.info("Default locale is " + defaultLocale);
			log.error("This locale is not supported. Communication with user will be in English");
			displayValues(bundle);
		}
    }
	
	public static void displayValues(ResourceBundle bundle){
		DateFormat dateFormat = new SimpleDateFormat("HH");
		Date date = new Date();
		int currentHour = Integer.parseInt(dateFormat.format(date));
		if(currentHour >= 6 && currentHour < 9){
			System.out.println(bundle.getString("my.morning"));
			log.info("Program replied : " + bundle.getString("my.morning"));
		} else if (currentHour >= 9 && currentHour < 19){
			System.out.println(bundle.getString("my.day"));
			log.info("Program replied : " + bundle.getString("my.day"));
		} else if (currentHour >= 19 && currentHour < 23){
			System.out.println(bundle.getString("my.evening"));
			log.info("Program replied : " + bundle.getString("my.evening"));
		} else {
			System.out.println(bundle.getString("my.night"));
			log.info("Program replied : " + bundle.getString("my.night"));
		}
	}
}