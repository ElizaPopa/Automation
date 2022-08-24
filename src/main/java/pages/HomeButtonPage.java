package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;

public class HomeButtonPage extends LoginPage {

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeButtonFromAppointmentPage;

    public HomeButtonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='authenticate.php?logout']")
    private WebElement logoutButton;
    public void homePage() {
        menuButton.click();
        homeButtonFromAppointmentPage.click();
    }

    public void logoutButton() throws InterruptedException {
        menuButton.click();
        Thread.sleep(2000);
        logoutButton.click();
        Thread.sleep(2000);
        menuButton.click();
        Thread.sleep(2000);
        homeButtonFromAppointmentPage.click();
        Thread.sleep(2000);


    }
}
