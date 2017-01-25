package selenium.mtg.gatherer;

import org.junit.Test;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.gatherer.pages.MtgGathererSearchPage;

public class MtgGathererTest extends WebDriverTest {

    @Test
    public void searchByCardName() {
        goToMtgGatherer()
            .enterSearchTerm("elf")
            .submitSearch()
            .assertPageTitle("Card Search - Search: +elf - Gatherer - Magic: The Gathering")
            .assertResultCard(1,"Angelfire Crusader") // Ang-elf-ire
            .assertResultCard(2,"Arbor Elf");
    }

    @Test
    public void searchByType() {
        goToMtgGatherer()
                .enterSearchTerm("elf")
                .toggleTypeSearch()
                .toggleNameSearch()
                .submitSearch()
                .assertResultCard(1,"Advocate of the Beast")
                .assertResultCard(6,"Arbor Elf");
    }

    @Test
    public void searchInSetCommander2014() {
        goToMtgGatherer()
                .enterSearchTerm("elf")
                .selectSet("Commander 2014")
                .submitSearch()
                .assertResultCard(1,"Farhaven Elf");
    }

    private MtgGathererSearchPage goToMtgGatherer() {
        return Browser.goTo(MtgGathererSearchPage.class, new Browser.BrowsingToPageAction(NavigationConstant.MTG_GATHERER_SEARCH_PAGE))
                .assertPageTitle("Gatherer - Magic: The Gathering");
    }
}
