package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class WebDriverTest {

    @BeforeClass
    public static void setUpClass() {
        Browser.setUp();
    }

    @Before
    public void setUp() {
        Browser.open();
    }

    @After
    public void tearDown() {
        Browser.close();
    }
}
