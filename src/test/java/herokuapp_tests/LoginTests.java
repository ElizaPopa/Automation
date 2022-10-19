package herokuapp_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin() {
        driver.get(urlHerokuApp);
        loginPage.loginWithValidCredentials();
        Assert.assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "The user was not redirected to the appointment page");
    }

    @Test
    public void invalidLogin() {
        driver.get(urlHerokuApp);
        loginPage.loginWithInvalidCredentials();
        Assert.assertEquals(driver.findElement(By.cssSelector(".lead.text-danger")).getText(),
                "Login failed! Please ensure the username and password are valid.");
    }
}


