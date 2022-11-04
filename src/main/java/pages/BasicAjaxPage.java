package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasicAjaxPage extends LoginPage {

    @FindBy(className = ("styled-click-button"))
    private WebElement codeButton;
    public BasicAjaxPage(WebDriver driver) {
        super(driver);
    }

    String urlHerokuAppBasicAjax = "https://testpages.herokuapp.com/styled/basic-ajax-test.html";

    public void getDroplist() {
        driver.get(urlHerokuAppBasicAjax);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Select firstDropList = new Select(driver.findElement(By.cssSelector("#combo1")));
        firstDropList.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select secondDropList = new Select(driver.findElement(By.cssSelector("#combo2")));
        secondDropList.selectByValue("11");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styled-click-button")));
        codeButton.click();
    }

    public void dropListOptions() {
        driver.get(urlHerokuAppBasicAjax);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Select firstDropList = new Select(driver.findElement(By.cssSelector("#combo1")));
        firstDropList.selectByValue("3");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select secondDropList = new Select(driver.findElement(By.cssSelector("#combo2")));
        secondDropList.selectByValue("23");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("styled-click-button")));
        codeButton.click();
    }
}
