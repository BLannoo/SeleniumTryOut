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
		browseTo(new MtgStocksHomePage())
			.assertTitle("MTGStocks.com")
			.assertGreetingText(MtgStocksHomePage.GREETING_TEXT)
			.assertMenuHasPage("Sets")
			.assertMenuHasPage("Interests")
			.assertMenuHasPage("Analytics")
			.assertMenuHasPage("Decks")
			.assertMenuHasPage("About")
			.assertMenuHasPage("Login")
			.assertMenuHasPage("Sign up");
	}

	@Test
	public void setsPage() {
		browseTo(new MtgStocksHomePage());
		goToSetsPage();
		assertNumberOfSets();
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
