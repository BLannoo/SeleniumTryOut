package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.AbstractPage;
import selenium.NavigationConstant;

public class MtgStocksSetsPage extends AbstractPage<MtgStocksSetsPage> {

    public MtgStocksSetsPage(WebDriver driver) {
        super(driver, NavigationConstant.MTG_STOCKS_SETS_PAGE, "Sets - MTGStocks.com");
    }

    public MtgStocksSetsPage assertNumberOfSets(int numberOfSets) {
        Assertions.assertThat(driver.findElements(By.className("list")).size()).isEqualTo(numberOfSets);
        return self();
    }
}
