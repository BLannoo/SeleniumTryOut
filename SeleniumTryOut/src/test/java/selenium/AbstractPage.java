package selenium;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage<T extends AbstractPage> {
    private final NavigationConstant navigationConstant;

    public AbstractPage(NavigationConstant navigationConstant) {
        this.navigationConstant = navigationConstant;
    }

    public T browseTo(WebDriver driver) {
        driver.get(navigationConstant.getUrl());
        return (T) this;
    }
}
