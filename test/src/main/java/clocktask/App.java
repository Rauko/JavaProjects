package clocktask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {
	public static void main(String[] args){
		Locale defaultLocale = Locale.getDefault();
		ResourceBundle bundle = null;
		if (Locale.getDefault().getDisplayLanguage().equals("русский")) {
			bundle = ResourceBundle.getBundle("TestBundle_ru_RU", defaultLocale);
			displayValues(bundle);
		} else if (Locale.getDefault().getDisplayLanguage().equals("українська")) {
			bundle = ResourceBundle.getBundle("TestBundle_ru_UA", defaultLocale);
			displayValues(bundle);
		} else if (Locale.getDefault().getDisplayLanguage().equals("English")) {
			bundle = ResourceBundle.getBundle("TestBundle_en_US", defaultLocale);
			displayValues(bundle);
		}
    }
	
	public static void displayValues(ResourceBundle bundle){
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