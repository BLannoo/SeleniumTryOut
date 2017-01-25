package selenium.mtg.pucatrade;

import org.junit.Test;
import selenium.framework.NavigationConstant;
import selenium.framework.WebDriverTest;
import selenium.mtg.pucatrade.pages.PucaTradeSearchPage;

public class PucaTradeTest extends WebDriverTest {

    @Test
    public void searchByCardName() {
        browseTo(NavigationConstant.MTG_PUCATRADE_SEARCH_PAGE);
        new PucaTradeSearchPage()
            .assertPageTitle("MTG Card Search | PucaTrade - Trade Magic: The Gathering Cards Online")
            .enterSearchTerm("elf")
            .assertResult(1, "Segovian Leviathan")
            ;
    }
}
