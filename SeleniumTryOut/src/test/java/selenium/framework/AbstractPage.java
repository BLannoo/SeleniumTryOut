package selenium.framework;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage<T extends AbstractPage> {

    private final NavigationConstant navigationConstant;

    @FindBy(xpath = "//title")
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

    public void waitTillOnPage(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Browser.TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER);
        webDriverWait.until(ExpectedConditions.urlToBe(navigationConstant.getUrl()));
    }
}
