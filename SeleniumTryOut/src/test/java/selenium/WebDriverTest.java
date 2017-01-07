package selenium;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import selenium.framework.BrowsingToPageAction;
import selenium.framework.PageAccessAction;

public class WebDriverTest {

    protected WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        FirefoxDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected PageAccessAction byBrowsingTo(NavigationConstant navigationConstant) {
        return new BrowsingToPageAction(driver, navigationConstant);
    }

    protected <PAGE extends AbstractPage<PAGE>> PAGE goTo(Class<PAGE> pageClass, PageAccessAction pageAccessAction) {
        pageAccessAction.execute();
        PAGE page = createInstanceOfPage(pageClass);

        page.waitTillOnPage(driver);
        initWebElements(page);
        return page;
    }

    private <PAGE extends AbstractPage<PAGE>> void initWebElements(PAGE page) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(finder, page);
    }

    private <PAGE> PAGE createInstanceOfPage(Class<PAGE> pageClass) {
        try {
            return pageClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
