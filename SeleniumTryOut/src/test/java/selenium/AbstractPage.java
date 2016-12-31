package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.mtgstocks.pages.MtgStocksSetsPage;

public abstract class AbstractPage<T extends AbstractPage> {
    private final NavigationConstant navigationConstant;
    private String title;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver, NavigationConstant navigationConstant, String title) {
        this.driver = driver;
        this.navigationConstant = navigationConstant;
        this.title = title;
    }

    public T browseTo() {
        driver.get(navigationConstant.getUrl());
        return self();
    }

    public T waitTillOnPage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.titleIs(title));
        return self();
    }

    protected T self() {
        assertOnPage();
        return (T) this;
    }

    private void assertOnPage() {
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(navigationConstant.getUrl());
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
    }
}
