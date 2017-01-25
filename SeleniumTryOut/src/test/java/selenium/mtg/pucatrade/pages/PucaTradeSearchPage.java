package selenium.mtg.pucatrade.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.AbstractPage;
import selenium.framework.NavigationConstant;

import java.util.List;

public class PucaTradeSearchPage extends AbstractPage<PucaTradeSearchPage> {

    @FindBy(xpath = "//form[@action='/search/']")
    private WebElement searchByNameField;

    @FindBy(xpath = "//div[@class='items has-filters  mode-paper  card-results']")
    private WebElement searchResults;

    public PucaTradeSearchPage() {
        super(NavigationConstant.MTG_PUCATRADE_SEARCH_PAGE);
    }

    public PucaTradeSearchPage enterSearchTerm(String searchTerm) {
        searchByNameField.sendKeys(searchTerm);
        return this;
    }

    public PucaTradeSearchPage assertResult(int resultIndex, String expectedCardName) {
        List<WebElement> results = searchResults.findElements(By.className("item"));
        Assertions.assertThat(results.get(resultIndex).findElement(By.className("name")).getText()).isEqualTo(expectedCardName);
        return this;
    }
}
