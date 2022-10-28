package pages;

import implementation.WebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class RedirectPage extends LoginPage {

    public RedirectPage(WebDriver driver) {
        super(driver);
    }
    public String redirectUrl = "https://testpages.herokuapp.com/styled/javascript-redirect-test.html";

    @FindBy(css = ".page-body button#delaygotobasic")
    private WebElement fiveSecondsButton;
    @FindBy(xpath = "//p[normalize-space()='You have been successfully redirected.']")
    private WebElement newPageMessage;
    @FindBy(id = "goback")
    private WebElement goBackButton;

    public void triggerA5SecRedirect() {
        driver.get(redirectUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-body button#delaygotobasic")));
        fiveSecondsButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String mainWindow = driver.getWindowHandle();
        Set<String> otherWindow = driver.getWindowHandles();
        for (String window : otherWindow) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='You have been successfully redirected.']")));
        System.out.println(newPageMessage.getText());
        goBackButton.click();
        driver.switchTo().window(mainWindow);
    }

    public void triggerA2SecRedirect() {
        driver.get(redirectUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-body button#delaygotobounce")));
        WebElement twoSecondsButton = driver.findElement(By.cssSelector(".page-body button#delaygotobounce"));
        twoSecondsButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String mainWindow = driver.getWindowHandle();
        Set<String> otherWindow = driver.getWindowHandles();
        for (String window : otherWindow) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        WebElement goBackButton = driver.findElement(By.id("goback"));
        goBackButton.click();
        driver.switchTo().window(mainWindow);
        driver.quit();
    }
}
