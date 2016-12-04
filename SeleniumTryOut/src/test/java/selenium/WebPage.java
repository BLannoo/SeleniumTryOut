package selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public abstract class WebPage {

	private NavigationConstant navigationConstant;
	
	protected WebPage(NavigationConstant navigationConstant) {
		this.navigationConstant = navigationConstant;
	}
	
	public void sendDriver(WebDriver driver) {
		driver.get(navigationConstant.generateUrl());
	}

	public void assertOnPage(WebDriver driver) {
		Assertions.assertThat(driver.getTitle()).isEqualTo(navigationConstant.getTitle());
	}
}
