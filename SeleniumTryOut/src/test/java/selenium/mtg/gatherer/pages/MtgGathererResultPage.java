package selenium.mtg.gatherer.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.AbstractPage;
import selenium.framework.NavigationConstant;

import java.util.List;

public class MtgGathererResultPage extends AbstractPage<MtgGathererResultPage> {

    @FindBy(className = "cardItemTable")
    private WebElement resultTable;

    public MtgGathererResultPage() {
        super(NavigationConstant.MTG_GATHERER_RESULT_PAGE);
    }

    public MtgGathererResultPage assertResultCard(int resultIndex, String cardName) {
        List<WebElement> results = resultTable.findElements(By.xpath("//table"));
        WebElement result = results.get(resultIndex);
        WebElement cardTitle = result.findElement(By.className("cardTitle"));
        Assertions.assertThat(cardTitle.getText()).isEqualTo(cardName);
        return self();
    }
}
