package selenium.mtg.stocks;

import org.junit.Test;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.stocks.pages.MtgStocksHomePage;

public class MtgStocksTest extends WebDriverTest {

    @Test
    public void homePage() {
        Browser.goTo(MtgStocksHomePage.class, new Browser.BrowsingToPageAction(NavigationConstant.MTG_STOCKS_HOME_PAGE))
                .assertPageTitle("MTGStocks.com")
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
        Browser.goTo(MtgStocksHomePage.class, new Browser.BrowsingToPageAction(NavigationConstant.MTG_STOCKS_HOME_PAGE))
                .goToSetsPage()
                .assertPageTitle("Sets - MTGStocks.com")
                .assertNumberOfSets(169);
    }
}
