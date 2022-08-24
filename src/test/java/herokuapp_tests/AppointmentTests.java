package herokuapp_tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AppointmentTests extends BaseTest {
    String baseURL = "https://katalon-demo-cura.herokuapp.com/";

    @Test
    public void makeAnAppointmentFunctionality() throws InterruptedException, IOException {
        driver.get(baseURL);
        appointmentPage.completeTheDetailsForAppointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "The user is not redirected to appointment page");
        appointmentPage.makeAnAppointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"),
                "Appointment confirmation failed");
    }

    @Test
    public void AppointmentFailed() throws InterruptedException {
        driver.get(baseURL);
        appointmentPage.failedAppointment();
    }
}

