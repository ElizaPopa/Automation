package herokuapp_tests;

import implementation.WebdriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class GridTests {

    @Test
    public void gridTest() throws MalformedURLException {
        RemoteWebDriver driver = WebdriverManager.getRemoteWebDriver();
        driver.get("https://demoqa.com/");
        driver.quit();
    }
}
