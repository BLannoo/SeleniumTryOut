package selenium.mtgstocks.pages;

import org.openqa.selenium.WebDriver;

import selenium.WebPage;
import selenium.mtgstocks.MtgCards;

public class CardPage extends WebPage {

	private static final String PAGE_TITLE_POSTFIX = " - MTGStocks.com";

	public CardPage(MtgCards cardName, WebDriver driver) {
		super(cardName.getName() + PAGE_TITLE_POSTFIX, driver);
	}
}
