package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage<T extends AbstractPage> {
    private final NavigationConstant navigationConstant;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver, NavigationConstant navigationConstant) {
        this.driver = driver;
        this.navigationConstant = navigationConstant;
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
        assertOnPage();
        return (T) this;
    }

    private void assertOnPage() {
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(navigationConstant.getUrl());
    }

    public T assertTitle(String title) {
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
        return self();
    }
}
