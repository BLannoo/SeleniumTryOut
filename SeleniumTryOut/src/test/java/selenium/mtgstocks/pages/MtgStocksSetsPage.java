package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.AbstractPage;
import selenium.NavigationConstant;

public class MtgStocksSetsPage extends AbstractPage<MtgStocksSetsPage> {

    private MtgStocksSetsPage(WebDriver driver) {
        super(NavigationConstant.MTG_STOCKS_SETS_PAGE);
    }

    public MtgStocksSetsPage assertNumberOfSets(int numberOfSets) {
        Assertions.assertThat(driver.findElements(By.className("list")).size()).isEqualTo(numberOfSets);
        return self();
    }

    public static MtgStocksSetsPage createByClickingWebElement(WebDriver driver, WebElement elementToClick) {
        elementToClick.click();
        MtgStocksSetsPage mtgStocksSetsPage = new MtgStocksSetsPage(driver)
                .waitTillOnPage();
        initWebElements(driver, mtgStocksSetsPage);
        return mtgStocksSetsPage;
    }
}
