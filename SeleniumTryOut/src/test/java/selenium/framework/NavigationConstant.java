package selenium.framework;

public enum NavigationConstant {
    MTG_STOCKS_HOME_PAGE("http://www.mtgstocks.com/"),
    MTG_STOCKS_SETS_PAGE("http://www.mtgstocks.com/sets"),
    MTG_GATHERER_SEARCH_PAGE("http://gatherer.wizards.com/Pages/Default.aspx");

    private final String url;

    NavigationConstant(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
