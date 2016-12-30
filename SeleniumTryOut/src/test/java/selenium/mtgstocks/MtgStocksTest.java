package selenium.mtgstocks;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.assertj.core.api.AbstractCharSequenceAssert;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void homePage() {
		driver.get("http://www.mtgstocks.com");
		assertTitle();
		assertGreetingText();
		assertNavigationBar();
		goToSetsPage();
	}

	private void assertTitle() {
		Assertions.assertThat(driver.getTitle()).isEqualTo("MTGStocks.com");
	}

	private void assertGreetingText() {
		Assertions.assertThat(driver.findElement(By.xpath("//div[@class='jumbotron']/p")).getText())
				.isEqualTo("Your favorite resource for daily price updates on Magic: the Gathering cards. We track prices of all cards and report the ones that have recently fluctuated the most for your Magic finance convenience!");
	}

	private void assertNavigationBar() {
		Assertions.assertThat(findNavigationBar().getText())
				.isEqualTo("Sets\nInterests\nAnalytics\nDecks\nAbout\nLogin\nSign up");
	}

	private WebElement findNavigationBar() {
		return driver.findElement(By.id("navbar"));
	}

	private void goToSetsPage() {
		findNavigationBar().findElement(By.linkText("Sets")).click();
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.titleIs("Sets - MTGStocks.com"));
		Assertions.assertThat(driver.getTitle())
				.isEqualTo("Sets - MTGStocks.com");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
