package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.AbstractPage;
import selenium.NavigationConstant;
import selenium.framework.ClickToAccessPageAction;

public class MtgStocksHomePage extends AbstractPage<MtgStocksHomePage> {

    public static final String GREETING_TEXT
            = "Your favorite resource for daily price updates on Magic: the Gathering cards. " +
            "We track prices of all cards and report the ones that " +
            "have recently fluctuated the most for your Magic finance convenience!";

    @FindBy(id = "navbar")
    private WebElement navBar;

    @FindBy(xpath = "//div[@class='jumbotron']/p")
    private WebElement greeting;

    public MtgStocksHomePage() {
        super(NavigationConstant.MTG_STOCKS_HOME_PAGE);
    }

    public MtgStocksHomePage assertGreetingText(String greetingText) {
        Assertions.assertThat(greeting.getText()).isEqualTo(greetingText);
        return self();
    }

    public MtgStocksHomePage assertHasMenuTowards(String menuName) {
        Assertions.assertThat(navBar.findElements(By.xpath("//a[contains(text(),'" + menuName +"')]"))).isNotEmpty();
        return self();
    }

    public ClickToAccessPageAction createGoToSetsPageAction() {
        WebElement SetsMenuButton = navBar.findElement(By.linkText("Sets"));
        return new ClickToAccessPageAction(SetsMenuButton);
    }
}
