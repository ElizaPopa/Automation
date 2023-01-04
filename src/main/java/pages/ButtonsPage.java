package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ButtonsPage extends BasePage {

    @FindBy(id = "button00")
    private WebElement firstButton;
    @FindBy(id = "button01")
    private WebElement secondButton;
    @FindBy(id = "button02")
    private WebElement thirdButton;
    @FindBy(id = "button03")
    private WebElement fourthButton;
    @FindBy(id = "buttonmessage")
    private WebElement buttonMessage;

    public WebElement getButtonMessage() {
        return buttonMessage;
    }

    public String urlButtons = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";

    public ButtonsPage(WebDriver driver) { super(driver); }

    public void fourButtons() {
        driver.get(urlButtons);
        firstButton.click();
        secondButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("button02")));
        thirdButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("button03")));
        fourthButton.click();
    }
}
