package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManager {

    public static ChromeDriver getChromedriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
