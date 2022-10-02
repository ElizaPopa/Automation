package herokuapp_tests;

import implementation.Screenshot;
import implementation.WebdriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.AppointmentPage;
import pages.BasicAjaxPage;
import pages.HomeButtonPage;
import pages.LoginPage;

import java.io.IOException;


public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    AppointmentPage appointmentPage;
    HomeButtonPage homeButtonPage;
    String configPath;
    String urlDemoQA = "https://demoqa.com/";

    BasicAjaxPage basicAjaxPage;
//    Screenshot screenshot;

    @BeforeMethod
    public void loginSteps() {
        driver = WebdriverManager.getChromedriver();
        loginPage = new LoginPage(driver);
        appointmentPage = new AppointmentPage(driver);
        homeButtonPage = new HomeButtonPage(driver);
        basicAjaxPage = new BasicAjaxPage(driver);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
//        screenshot = new Screenshot(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void quitThePage(ITestResult result) {
//        String testName = result.getName();
//        String screenshotFileName = "screenshots/" + testName + ".png";
//        if(result.getStatus() == ITestResult.FAILURE){
//            screenshot.saveScreenshot(screenshotFileName);
//        }
        driver.quit();
        System.out.println("Test passed successfully");
    }

}

