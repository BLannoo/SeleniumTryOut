package selenium;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;

public class MtgStocksTest extends TestCase {

	private static final String URL_MTGSTOCKS = "http://www.mtgstocks.com/";
	private static final String PAGE_TITLE = "MTGStocks.com";

	public void testApp() {
		WebDriver driver = new FirefoxDriver();
		driver.get(URL_MTGSTOCKS);
		assertThat(driver.getTitle()).isEqualTo(PAGE_TITLE);
	}
}
