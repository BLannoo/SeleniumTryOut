package selenium.mtgstocks;

import org.junit.Test;
import selenium.NavigationConstant;
import selenium.WebDriverTest;
import selenium.framework.ClickToAccessPageAction;
import selenium.mtgstocks.pages.MtgStocksHomePage;
import selenium.mtgstocks.pages.MtgStocksSetsPage;

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
		ClickToAccessPageAction goToSetsPageAction = goTo(MtgStocksHomePage.class, byBrowsingTo(NavigationConstant.MTG_STOCKS_HOME_PAGE))
				.createGoToSetsPageAction();

		goTo(MtgStocksSetsPage.class, goToSetsPageAction)
			.assertTitle("Sets - MTGStocks.com")
			.assertNumberOfSets(169);
	}
}
