package selenium.mtg.stocks.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.AbstractPage;
import selenium.framework.NavigationConstant;

import java.util.List;

public class MtgStocksSetsPage extends AbstractPage<MtgStocksSetsPage> {

    @FindBy(className = "list")
    private List<WebElement> allLists;

    public MtgStocksSetsPage() {
        super(NavigationConstant.MTG_STOCKS_SETS_PAGE);
    }

    public MtgStocksSetsPage assertNumberOfSets(int numberOfSets) {
        Assertions.assertThat(allLists.size()).isEqualTo(numberOfSets);
        return self();
    }
}
