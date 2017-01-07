package selenium;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import selenium.framework.BrowsingToPageAction;
import selenium.framework.PageAccessAction;

public class Browser {

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

    public static void browseTo(NavigationConstant navigationConstant) {
        driver.get(navigationConstant.getUrl());
    }

    public static <PAGE extends AbstractPage<PAGE>> PAGE goTo(Class<PAGE> pageClass, PageAccessAction pageAccessAction) {
        pageAccessAction.execute();
        PAGE page = createInstanceOfPage(pageClass);
        page.waitTillOnPage(driver);
        initWebElements(page);
        return page;
    }

    private static <PAGE extends AbstractPage<PAGE>> void initWebElements(PAGE page) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
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
}
