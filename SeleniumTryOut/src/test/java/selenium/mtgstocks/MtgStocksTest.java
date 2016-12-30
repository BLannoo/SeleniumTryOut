package selenium.mtgstocks;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MtgStocksTest {

	protected WebDriver driver;

	@BeforeClass
	public static void setUpClass() {
		FirefoxDriverManager.getInstance().setup();
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void testApp() {
		driver.get("http://www.mtgstocks.com");
		Assertions.assertThat(driver.getTitle()).isEqualTo("MTGStocks.com");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
