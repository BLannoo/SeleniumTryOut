package selenium.pageAccessAction;

import org.openqa.selenium.WebElement;

public class ClickToAccessPageAction implements PageAccessAction {
    private WebElement button;

    public ClickToAccessPageAction(WebElement button) {
        this.button = button;
    }

    public void execute() {
        button.click();
    }
}
