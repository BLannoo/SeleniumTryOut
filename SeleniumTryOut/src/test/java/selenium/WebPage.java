package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.mtgstocks.MtgCards;
import selenium.mtgstocks.pages.CardPage;

public abstract class WebPage {

	private static final String SEARCH_BOX_ID = "print_card";
	private String pageTitle;
	private WebDriver driver;
	
	protected WebPage(String pageTitle, WebDriver driver) {
		this.pageTitle = pageTitle;
		this.driver = driver;
	}
	
	public WebPage assertOnPage() {
		Assertions.assertThat(driver.getTitle()).isEqualTo(pageTitle);
		return this;
	}

	public WebPage searchForCard(MtgCards card) {
		
		WebElement searchBox = findWebElement(SEARCH_BOX_ID);
		searchBox.sendKeys(card.getName());
		searchBox.submit();
		
		return new CardPage(card, driver);
	}

	private WebElement findWebElement(String id) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		return driver.findElement(By.id(id));
	}
}
