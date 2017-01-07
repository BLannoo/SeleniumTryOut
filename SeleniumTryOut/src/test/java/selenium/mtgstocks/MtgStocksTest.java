package selenium.mtgstocks;

import org.junit.Test;
import selenium.NavigationConstant;
import selenium.WebDriverTest;
import selenium.mtgstocks.pages.MtgStocksHomePage;

public class MtgStocksTest extends WebDriverTest {

	@Test
	public void homePage() {
		goTo(MtgStocksHomePage.class, byBrowsingTo(NavigationConstant.MTG_STOCKS_HOME_PAGE))
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
