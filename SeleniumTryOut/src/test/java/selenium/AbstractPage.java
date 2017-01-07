package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage<T extends AbstractPage> {
    private final NavigationConstant navigationConstant;
    protected WebDriver driver;

    @FindBy(xpath = "//title")
    private WebElement titleElement;

    public AbstractPage(NavigationConstant navigationConstant) {
        this.navigationConstant = navigationConstant;
    }

    protected static void initWebElements(WebDriver driver, AbstractPage mtgStocksHomePage) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(finder, mtgStocksHomePage);
    }

    public T browseTo() {
        driver.get(navigationConstant.getUrl());
        return self();
    }

    public T waitTillOnPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.urlToBe(navigationConstant.getUrl()));
        return self();
    }

    protected T self() {
        return (T) this;
    }

    public T assertTitle(String title) {
        Assertions.assertThat(titleElement.getText()).isEqualTo(title);
        return self();
    }

    public void waitTillOnPage(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.urlToBe(navigationConstant.getUrl()));
    }
}
