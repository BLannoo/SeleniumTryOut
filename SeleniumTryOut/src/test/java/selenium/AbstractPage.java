package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractPage<T extends AbstractPage> {
    private final NavigationConstant navigationConstant;
    protected WebDriver driver;

    public AbstractPage(NavigationConstant navigationConstant) {
        this.navigationConstant = navigationConstant;
    }

    public T browseTo(WebDriver driver) {
        this.driver = driver;
        driver.get(navigationConstant.getUrl());
        return self();
    }

    public T assertTitle(String title) {
        Assertions.assertThat(driver.getTitle()).isEqualTo(title);
        return self();
    }

    protected T self() {
        return (T) this;
    }
}
