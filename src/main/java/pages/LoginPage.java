package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "menu-toggle")
    public WebElement menuButton;
    @FindBy(css = "a[href='profile.php#login")
    private WebElement loginButtonFromMenu;
    @FindBy(id = "txt-username")
    public WebElement username;
    @FindBy(id = "txt-password")
    public WebElement password;
    @FindBy(id = "btn-login")
    public WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginWithValidCredentials() {
        menuButton.click();
        loginButtonFromMenu.click();
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        loginButton.click();
    }

    public void loginWithInvalidCredentials() {

        menuButton.click();
        loginButtonFromMenu.click();
        username.sendKeys("Eliza Popa");
        password.sendKeys("WrongPassword");
        loginButton.click();
    }
}