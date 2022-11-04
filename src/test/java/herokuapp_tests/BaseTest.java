package herokuapp_tests;

import implementation.Screenshot;
import implementation.WebdriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.net.MalformedURLException;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    HomeButtonPage homeButtonPage;
    RedirectPage redirectPage;
    String configPath;
    RefreshPage refreshPage;
    BasicAjaxPage basicAjaxPage;
    Screenshot screenshot;
    ButtonsPage buttonsPage;
    String urlDemoQA = "https://demoqa.com/";
    String urlHerokuApp = "https://katalon-demo-cura.herokuapp.com/";
    String baseURLHeroku = "https://katalon-demo-cura.herokuapp.com/";

    @BeforeMethod
    public void loginSteps() throws MalformedURLException {
        driver = WebdriverManager.getRemoteWebDriver();
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        homeButtonPage = new HomeButtonPage(driver);
        basicAjaxPage = new BasicAjaxPage(driver);
        redirectPage = new RedirectPage(driver);
        refreshPage = new RefreshPage(driver);
        buttonsPage = new ButtonsPage(driver);
        screenshot = new Screenshot(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitThePage() {
        if (driver != null) {
            driver.quit();
        }
    }
}

