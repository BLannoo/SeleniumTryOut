package selenium.mtgstocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import selenium.AbstractPage;
import selenium.NavigationConstant;

import java.util.List;

public class MtgStocksSetsPage extends AbstractPage<MtgStocksSetsPage> {

    @FindBy(xpath = "//li[@class='list']")
    private List<WebElement> allLists;

    public MtgStocksSetsPage() {
        super(NavigationConstant.MTG_STOCKS_SETS_PAGE);
    }

    public MtgStocksSetsPage assertNumberOfSets(int numberOfSets) {
        Assertions.assertThat(allLists.size()).isEqualTo(numberOfSets);
        return self();
    }
}
