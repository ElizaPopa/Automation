package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AppointmentTests {
    ChromeDriver web = null;
    @Test
    public void makeAnAppointment() {
        try {
            String baseUrl = "https://katalon-demo-cura.herokuapp.com/";
            WebDriver web = new ChromeDriver();
            web.get(baseUrl);

            Select facility = new Select(web.findElement(By.id("combo_facility")));
            facility.selectByIndex(1);

        } catch (IllegalStateException e) {
            System.out.println("Ramura catch");
        } finally {
            if (web != null) {
                web.quit();
            }
        }
    }
}
