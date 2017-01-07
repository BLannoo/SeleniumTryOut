package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import selenium.AbstractPage;
import selenium.NavigationConstant;

public class MtgStocksHomePage extends AbstractPage<MtgStocksHomePage> {

    public static final String GREETING_TEXT
            = "Your favorite resource for daily price updates on Magic: the Gathering cards. " +
            "We track prices of all cards and report the ones that " +
            "have recently fluctuated the most for your Magic finance convenience!";

    @FindBy(id = "navbar")
    private WebElement navBar;

    @FindBy(xpath = "//div[@class='jumbotron']/p")
    private WebElement greeting;

    private MtgStocksHomePage(WebDriver driver) {
        super(driver, NavigationConstant.MTG_STOCKS_HOME_PAGE);
    }

    public MtgStocksHomePage assertGreetingText(String greetingText) {
        Assertions.assertThat(greeting.getText()).isEqualTo(greetingText);
        return self();
    }

    public MtgStocksHomePage assertHasMenuTowards(String menuName) {
        Assertions.assertThat(navBar.findElements(By.xpath("//a[contains(text(),'" + menuName +"')]"))).isNotEmpty();
        return self();
    }

    public MtgStocksSetsPage goToSetsPage() {
        WebElement SetsMenuButton = navBar.findElement(By.linkText("Sets"));
        return MtgStocksSetsPage.createByClickingWebElement(driver, SetsMenuButton);
    }

    public static MtgStocksHomePage createByBrowsing(WebDriver driver) {
        MtgStocksHomePage mtgStocksHomePage = new MtgStocksHomePage(driver).browseTo();
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(finder, mtgStocksHomePage);
        return mtgStocksHomePage;
    }
}
