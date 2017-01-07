package selenium.framework;

import selenium.Browser;
import selenium.NavigationConstant;

public class BrowsingToPageAction implements PageAccessAction {
    private final NavigationConstant navigationConstant;

    public BrowsingToPageAction(NavigationConstant navigationConstant) {
        this.navigationConstant = navigationConstant;
    }

    public void execute() {
        Browser.browseTo(navigationConstant.getUrl());
    }
}
