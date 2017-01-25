package selenium.framework;

public enum NavigationConstant {
    MTG_STOCKS_HOME_PAGE("http://www.mtgstocks.com/"),
    MTG_STOCKS_SETS_PAGE("http://www.mtgstocks.com/sets"),
    MTG_GATHERER_SEARCH_PAGE("http://gatherer.wizards.com/Pages/Default.aspx"),
    MTG_GATHERER_RESULT_PAGE("http://gatherer.wizards.com/Pages/Search/Default.aspx?.*"),
    MTG_PUCATRADE_SEARCH_PAGE("https://pucatrade.com/search");

    private final String urlRegex;

    NavigationConstant(String urlRegex) {
        this.urlRegex = urlRegex;
    }

    public String getUrlRegex() {
        return urlRegex;
    }
}
