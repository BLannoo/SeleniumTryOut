package selenium.framework;

import org.openqa.selenium.WebDriver;
import selenium.NavigationConstant;

public class BrowsingToPageAction implements PageAccessAction {
    private final WebDriver driver;
    private final NavigationConstant navigationConstant;

    public BrowsingToPageAction(WebDriver driver, NavigationConstant navigationConstant) {
        this.driver = driver;
        this.navigationConstant = navigationConstant;
    }

    public void execute() {
        driver.get(navigationConstant.getUrl());
    }
}
