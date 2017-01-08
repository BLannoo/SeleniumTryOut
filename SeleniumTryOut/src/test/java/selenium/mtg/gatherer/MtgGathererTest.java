package selenium.mtg.gatherer;

import org.junit.Test;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.gatherer.pages.MtgGathererSearchPage;

public class MtgGathererTest extends WebDriverTest {

    @Test
    public void goToMtgGathererPage() {
        Browser.goTo(MtgGathererSearchPage.class, new Browser.BrowsingToPageAction(NavigationConstant.MTG_GATHERER_SEARCH_PAGE))
            .assertTitle("Gatherer - Magic: The Gathering");
    }
}
