package selenium;

public enum NavigationConstant {

	HOME_PAGE("www.mtgstocks.com");
	
	private static final String URL_PREFIX = "http://";
	
	private String adress;

	private NavigationConstant(String adress) {
		this.adress = adress;
	}

	public String generateUrl() {
		return URL_PREFIX + adress;
	}
}
