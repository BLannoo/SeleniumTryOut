package selenium.mtgstocks;

import org.junit.Test;

import selenium.SeleniumWebDriverTest;

public class MtgStocksTest extends SeleniumWebDriverTest {

	@Test
	public void testApp() {
		browseTo(new MtgStocksHomePage());
	}
}
