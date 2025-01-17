package selenium.mtg.gatherer.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import selenium.framework.AbstractPage;
import selenium.framework.NavigationConstant;

public class MtgGathererSearchPage extends AbstractPage<MtgGathererSearchPage> {

    @FindBy(id = "ctl00_ctl00_MainContent_Content_SearchControls_CardSearchBoxParent_CardSearchBox")
    private WebElement searchBox;

    @FindBy(id = "ctl00_ctl00_MainContent_Content_SearchControls_searchSubmitButton")
    private WebElement submitButton;

    @FindBy(xpath = "//label[@for='ctl00_ctl00_MainContent_Content_SearchControls_SearchCardTypes']")
    private WebElement typeSearchCheckBox;

    @FindBy(xpath = "//label[@for='ctl00_ctl00_MainContent_Content_SearchControls_SearchCardName']")
    private WebElement nameSearchCheckBox;

    @FindBy(id = "ctl00_ctl00_MainContent_Content_SearchControls_setAddText")
    private WebElement setsDropDownFilter;

    public MtgGathererSearchPage() {
        super(NavigationConstant.MTG_GATHERER_SEARCH_PAGE);
    }

    public MtgGathererSearchPage enterSearchTerm(String searchTerm) {
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        return self();
    }

    public MtgGathererResultPage submitSearch() {
        submitButton.click();
        return new MtgGathererResultPage();
    }

    public MtgGathererSearchPage toggleTypeSearch() {
        typeSearchCheckBox.click();
        return self();
    }

    public MtgGathererSearchPage toggleNameSearch() {
        nameSearchCheckBox.click();
        return self();
    }

    public MtgGathererSearchPage selectSet(String set) {
        new Select(setsDropDownFilter).selectByValue(set);
        return self();
    }
}
