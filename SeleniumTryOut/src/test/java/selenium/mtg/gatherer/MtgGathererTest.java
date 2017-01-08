package selenium.mtg.gatherer;

import org.junit.Test;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.gatherer.pages.MtgGathererSearchPage;

public class MtgGathererTest extends WebDriverTest {

    @Test
    public void simpleSearch() {
        Browser.goTo(MtgGathererSearchPage.class, new Browser.BrowsingToPageAction(NavigationConstant.MTG_GATHERER_SEARCH_PAGE))
            .assertPageTitle("Gatherer - Magic: The Gathering")
            .enterSearchTerm("elf")
            .submitSearch()
            .assertPageTitle("Card Search - Search: +elf - Gatherer - Magic: The Gathering")
            .assertResultCard(1,"Angelfire Crusader")
            .assertResultCard(2,"Arbor Elf");
    }
}
