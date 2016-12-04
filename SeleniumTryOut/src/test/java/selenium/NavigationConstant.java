package selenium;

public enum NavigationConstant {

	MTG_STOCKS("www.mtgstocks.com", "MTGStocks.com");
	
	private static final String URL_PREFIX = "http://";
	
	private String adress;
	private String pageTitle;

	private NavigationConstant(String adress, String pageTitle) {
		this.adress = adress;
		this.pageTitle = pageTitle;
	}

	public String generateUrl() {
		return URL_PREFIX + adress;
	}

	public String getTitle() {
		return pageTitle;
	}
}
