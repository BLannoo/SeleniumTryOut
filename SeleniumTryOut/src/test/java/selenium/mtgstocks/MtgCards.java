package selenium.mtgstocks;

public enum MtgCards {
	BLACK_LOTUS("Black Lotus");

	private String name;

	MtgCards(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
