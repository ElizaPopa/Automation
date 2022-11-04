package herokuapp_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentTests extends BaseTest {

    @Test
    public void makeAnAppointmentFunctionality() throws InterruptedException {
        driver.get(urlHerokuApp);
        appointmentPage.completeTheDetailsForAppointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "The user is not redirected to appointment page");
        appointmentPage.makeAnAppointment();
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"),
                "Appointment confirmation failed");
    }

    @Test
    public void NegativeScenario() throws InterruptedException {
        driver.get(urlHerokuApp);
        appointmentPage.insertingLetersInDateField();
    }
}

