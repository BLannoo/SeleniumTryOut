package selenium.mtgstocks;

import org.junit.Test;

import selenium.SeleniumWebDriverTest;
import selenium.mtgstocks.pages.HomePage;

public class MtgStocksTest extends SeleniumWebDriverTest {

	@Test
	public void testApp() {
		new HomePage(driver)
			.assertOnPage()
			.searchForCard(MtgCards.BLACK_LOTUS)
			.assertOnPage();
	}
}
