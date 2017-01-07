package selenium.mtgstocks;

import org.junit.Test;
import selenium.Browser;
import selenium.NavigationConstant;
import selenium.WebDriverTest;
import selenium.framework.ClickToAccessPageAction;
import selenium.mtgstocks.pages.MtgStocksHomePage;
import selenium.mtgstocks.pages.MtgStocksSetsPage;

public class MtgStocksTest extends WebDriverTest {

    @Test
    public void homePage() {
        Browser.goTo(MtgStocksHomePage.class, Browser.byBrowsingTo(NavigationConstant.MTG_STOCKS_HOME_PAGE))
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
        Browser.goTo(MtgStocksHomePage.class, Browser.byBrowsingTo(NavigationConstant.MTG_STOCKS_HOME_PAGE))
                .goToSetsPage()
                .assertTitle("Sets - MTGStocks.com")
                .assertNumberOfSets(169);
    }
}
