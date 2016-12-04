package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public abstract class SeleniumWebDriverTest {

	protected WebDriver driver;

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

	protected void goTo(NavigationConstant navigationConstant) {
		driver.get(navigationConstant.generateUrl());
	}

	protected WebPage browseTo(WebPage webPage) {
		webPage.sendDriver(driver);
		webPage.assertOnPage(driver);
		return webPage;
	}
}