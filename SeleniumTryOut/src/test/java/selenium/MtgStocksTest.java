package selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class MtgStocksTest {

	private static final String URL_MTGSTOCKS = "http://www.mtgstocks.com/";
	private static final String PAGE_TITLE = "MTGStocks.com";
	private WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		FirefoxDriverManager.getInstance().setup();
	}
	
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testApp() {
		driver.get(URL_MTGSTOCKS);
		assertThat(driver.getTitle()).isEqualTo(PAGE_TITLE);
	}
}
