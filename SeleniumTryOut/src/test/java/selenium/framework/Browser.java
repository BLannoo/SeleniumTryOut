package selenium.framework;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.framework.pageAccessAction.PageAccessAction;

public class Browser {

    public static final int TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER = 10;

    private static WebDriver driver;

    public static void setUp() {
        FirefoxDriverManager.getInstance().setup();
    }

    public static void open() {
        driver = new FirefoxDriver();
    }

    public static void close() {
        driver.quit();
    }

    public static void waitUntill(ExpectedCondition<Boolean> condition) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER)
                .until(condition);
    }

    public static <PAGE extends AbstractPage<PAGE>> PAGE goTo(Class<PAGE> pageClass, PageAccessAction pageAccessAction) {
        pageAccessAction.execute();
        PAGE page = createInstanceOfPage(pageClass);
        page.waitTillOnPage();
        initWebElements(page);
        return page;
    }

    private static <PAGE extends AbstractPage<PAGE>> void initWebElements(PAGE page) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, TIME_OUT_IN_SECONDS_WHEN_WAITING_FOR_DRIVER);
        PageFactory.initElements(finder, page);
    }

    private static <PAGE extends AbstractPage<PAGE>> PAGE createInstanceOfPage(Class<PAGE> pageClass) {
        try {
            return pageClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static class BrowsingToPageAction implements PageAccessAction {
        private final NavigationConstant navigationConstant;

        public BrowsingToPageAction(NavigationConstant navigationConstant) {
            this.navigationConstant = navigationConstant;
        }

        public void execute() {
            Browser.browseTo(navigationConstant);
        }
    }

    private static void browseTo(NavigationConstant navigationConstant) {
        driver.get(navigationConstant.getUrlRegex());
    }
}
