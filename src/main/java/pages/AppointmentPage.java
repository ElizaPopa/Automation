package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AppointmentPage extends BasePage {

    WebDriver driver;
    public AppointmentPage(WebDriver driver) {
        super(driver);
    }
    String baseURL = "https://katalon-demo-cura.herokuapp.com/";

    public void makeAnAppointment() {

        driver.get(baseURL);
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        //      Assert.assertTrue(driver.getCurrentUrl().contains("profile.php#login"),
        //             "The user is not redirected to login page");
//        try {
//            String baseUrl = "https://katalon-demo-cura.herokuapp.com/";
//            WebDriver web = new ChromeDriver();
//            web.get(baseUrl);
//
//            Select facility = new Select(web.findElement(By.id("combo_facility")));
//            facility.selectByIndex(1);
//
//        } catch (IllegalStateException e) {
//            System.out.println("Ramura catch");
//        } finally {
//            if (web != null) {
//                web.quit();
            }
        }
