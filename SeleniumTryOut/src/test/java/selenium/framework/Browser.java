package selenium.framework;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

class Browser {

    private static final int TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER = 10;

    private static WebDriver driver;

    static void setUp() {
        FirefoxDriverManager.getInstance().setup();
    }

    static void open() {
        driver = new FirefoxDriver();
    }

    static void close() {
        driver.quit();
    }

    static void waitUntill(ExpectedCondition<Boolean> condition) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER)
                .until(condition);
    }

    static void browseTo(NavigationConstant navigationConstant) {
        driver.get(navigationConstant.getUrlRegex());
    }

    static <PAGE extends AbstractPage> void initWebElements(PAGE page) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER);
        PageFactory.initElements(finder, page);
    }
}
