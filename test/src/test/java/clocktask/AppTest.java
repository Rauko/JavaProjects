package clocktask;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
    public AppTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
    	App app = new App();
    	assertEquals(expected, actual);
        return new TestSuite( AppTest.class );
    }

    public void testApp() {
        assertTrue( true );
    }
}
