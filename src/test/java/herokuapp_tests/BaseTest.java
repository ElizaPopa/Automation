package herokuapp_tests;

import implementation.WebdriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AppointmentPage;
import pages.HomeButtonPage;
import pages.LoginPage;


public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    HomeButtonPage homeButtonPage;

    @BeforeMethod
    public void loginSteps() {
        driver = WebdriverManager.getChromedriver();
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        homeButtonPage = new HomeButtonPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitThePage() {
        driver.quit();
        System.out.println("Test passed successfully");
    }
}

