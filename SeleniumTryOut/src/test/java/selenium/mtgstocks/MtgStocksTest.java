package selenium.mtgstocks;

import org.junit.Test;
import selenium.WebDriverTest;
import selenium.mtgstocks.pages.MtgStocksHomePage;

public class MtgStocksTest extends WebDriverTest {

	@Test
	public void homePage() {
		MtgStocksHomePage.createByBrowsing(driver)
			.assertTitle("MTGStocks.com")
			.assertGreetingText(MtgStocksHomePage.GREETING_TEXT)
			.assertHasMenuTowards("Sets")
			.assertHasMenuTowards("Interests")
			.assertHasMenuTowards("Analytics")
			.assertHasMenuTowards("Decks")
			.assertHasMenuTowards("About")
			.assertHasMenuTowards("Login")
			.assertHasMenuTowards("Sign up");
	}

	@Test
	public void setsPage() {
		MtgStocksHomePage.createByBrowsing(driver)
			.goToSetsPage()
			.assertTitle("Sets - MTGStocks.com")
			.assertNumberOfSets(169);
	}
}
