package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "menu-toggle")
    private WebElement menuButton;

    @FindBy(css = "a[href='profile.php#login")
    private WebElement loginButtonFromMenu;
    @FindBy(id = "txt-username")
    private WebElement username;

    @FindBy(id = "txt-password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(css = ".lead.text-danger")
    private WebElement loginMessage;

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