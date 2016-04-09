package clocktask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
    public AppTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
    	//assertEquals("my.day", App.getMyDayPeriod(12));
        return new TestSuite( AppTest.class );
    }
    
    public void testGetMyDayPeriod() {
    	assertEquals("my.day", App.getMyDayPeriod(12));
    }
    
    
    public void testGetCurrentTime() {
    	DateFormat dateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
    	ResourceBundle bundle = ResourceBundle.getBundle("TestBundle", Locale.getDefault());
    	assertEquals(Integer.parseInt(dateFormat.format(date)), App.getCurrentTime(bundle));
    }
    
    public void testApp() {
        assertTrue(true);
    }
}
