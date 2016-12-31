package selenium;

public enum NavigationConstant {
    MTG_STOCKS_HOME_PAGE("http://www.mtgstocks.com");

    private final String url;

    NavigationConstant(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
