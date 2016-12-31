package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.AbstractPage;
import selenium.NavigationConstant;

public class MtgStocksHomePage extends AbstractPage<MtgStocksHomePage> {

    public static final String GREETING_TEXT
            = "Your favorite resource for daily price updates on Magic: the Gathering cards. " +
            "We track prices of all cards and report the ones that " +
            "have recently fluctuated the most for your Magic finance convenience!";

    public MtgStocksHomePage() {
        super(NavigationConstant.MTG_STOCKS_HOME_PAGE);
    }

    public MtgStocksHomePage assertGreetingText(String greetingText) {
        Assertions.assertThat(driver.findElement(By.xpath("//div[@class='jumbotron']/p")).getText())
                .isEqualTo(greetingText);
        return self();
    }

    public MtgStocksHomePage assertMenuHasPage(String menuName) {
        WebElement navbar = driver.findElement(By.id("navbar"));
        Assertions.assertThat(navbar.findElements(By.xpath("//a[contains(text(),'" + menuName +"')]"))).isNotEmpty();
        return self();
    }
}
