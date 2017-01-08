package selenium.framework;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbstractPage<T extends AbstractPage> {

    private final NavigationConstant navigationConstant;

    @FindBy(xpath = "/html/head/title")
    private WebElement titleElement;

    public AbstractPage(NavigationConstant navigationConstant) {
        this.navigationConstant = navigationConstant;
    }

    protected T self() {
        return (T) this;
    }

    public T assertTitle(String title) {
        Assertions.assertThat(titleElement.getText()).isEqualTo(title);
        return self();
    }

    public void waitTillOnPage() {
        Browser.waitUntill(ExpectedConditions.urlMatches(navigationConstant.getUrlRegex()));
    }
}
