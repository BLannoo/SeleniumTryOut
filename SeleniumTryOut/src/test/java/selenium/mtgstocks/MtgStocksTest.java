package selenium.mtgstocks;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverTest;
import selenium.mtgstocks.pages.MtgStocksHomePage;

public class MtgStocksTest extends WebDriverTest {

	@Test
	public void homePage() {
		browseTo(new MtgStocksHomePage());
		assertTitle();
		assertGreetingText();
		assertNavigationBar();
	}

	@Test
	public void setsPage() {
		browseTo(new MtgStocksHomePage());
		goToSetsPage();
		assertNumberOfSets();
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

	private void assertNumberOfSets() {
		Assertions.assertThat(driver.findElements(By.className("list")).size()).isEqualTo(169);
	}

}
