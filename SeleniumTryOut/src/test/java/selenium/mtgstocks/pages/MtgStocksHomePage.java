package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.AbstractPage;
import selenium.NavigationConstant;

public class MtgStocksHomePage extends AbstractPage<MtgStocksHomePage> {

    public static final String GREETING_TEXT
            = "Your favorite resource for daily price updates on Magic: the Gathering cards. " +
            "We track prices of all cards and report the ones that " +
            "have recently fluctuated the most for your Magic finance convenience!";

    private MtgStocksHomePage(WebDriver driver) {
        super(driver, NavigationConstant.MTG_STOCKS_HOME_PAGE, "MTGStocks.com");
    }

    public MtgStocksHomePage assertGreetingText(String greetingText) {
        Assertions.assertThat(driver.findElement(By.xpath("//div[@class='jumbotron']/p")).getText())
                .isEqualTo(greetingText);
        return self();
    }

    public MtgStocksHomePage assertHasMenuTowards(String menuName) {
        WebElement navbar = findNavigationBar();
        Assertions.assertThat(navbar.findElements(By.xpath("//a[contains(text(),'" + menuName +"')]"))).isNotEmpty();
        return self();
    }

    private WebElement findNavigationBar() {
        return driver.findElement(By.id("navbar"));
    }

    public MtgStocksSetsPage goToSetsPage() {
        findNavigationBar().findElement(By.linkText("Sets")).click();
        return new MtgStocksSetsPage(driver)
                .waitTillOnPage();
    }

    public static MtgStocksHomePage createByBrowsing(WebDriver driver) {
        return new MtgStocksHomePage(driver).browseTo();
    }
}
