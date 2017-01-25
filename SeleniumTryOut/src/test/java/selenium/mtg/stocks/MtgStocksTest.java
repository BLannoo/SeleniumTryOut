package selenium.mtg.stocks;

import org.junit.Test;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.stocks.pages.MtgStocksHomePage;

public class MtgStocksTest extends WebDriverTest {

    @Test
    public void homePage() {
        Browser.browseTo(NavigationConstant.MTG_STOCKS_HOME_PAGE);
        new MtgStocksHomePage()
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
        Browser.browseTo(NavigationConstant.MTG_STOCKS_HOME_PAGE);
        new MtgStocksHomePage()
                .goToSetsPage()
                .assertPageTitle("Sets - MTGStocks.com")
                .assertNumberOfSets(170);
    }
}
