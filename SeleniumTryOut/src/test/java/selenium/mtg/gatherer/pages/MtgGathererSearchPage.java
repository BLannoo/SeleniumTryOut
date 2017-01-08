package selenium.mtg.gatherer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.AbstractPage;
import selenium.framework.Browser;
import selenium.framework.NavigationConstant;
import selenium.framework.pageAccessAction.ClickToAccessPageAction;

public class MtgGathererSearchPage extends AbstractPage<MtgGathererSearchPage> {

    @FindBy(id = "ctl00_ctl00_MainContent_Content_SearchControls_CardSearchBoxParent_CardSearchBox")
    private WebElement searchBox;

    @FindBy(id = "ctl00_ctl00_MainContent_Content_SearchControls_searchSubmitButton")
    private WebElement submitButton;

    public MtgGathererSearchPage() {
        super(NavigationConstant.MTG_GATHERER_SEARCH_PAGE);
    }

    public MtgGathererSearchPage enterSearchTerm(String searchTerm) {
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        return self();
    }

    public MtgGathererResultPage submitSearch() {
        ClickToAccessPageAction submitSearchAction = new ClickToAccessPageAction(submitButton);
        return Browser.goTo(MtgGathererResultPage.class, submitSearchAction);
    }
}
