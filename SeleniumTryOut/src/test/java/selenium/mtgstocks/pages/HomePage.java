package selenium.mtgstocks.pages;

import static selenium.NavigationConstant.HOME_PAGE;

import org.openqa.selenium.WebDriver;

import selenium.WebPage;

public class HomePage extends WebPage {

	public HomePage(WebDriver driver) {
		super("MTGStocks.com", driver);
		browseToWith(driver);
	}

	private void browseToWith(WebDriver driver) {
		driver.get(HOME_PAGE.generateUrl());
	}
}
