package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        driver.findElement((By.id("txt-username"))).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "The user was not redirected to the appointment page");
    }

    @Test
    public void loginWithInvalidCredentials() {

        driver.findElement((By.id("txt-username"))).sendKeys("Eliza Popa");
        driver.findElement(By.id("txt-password")).sendKeys("Wrongpassword");
        driver.findElement(By.id("btn-login")).click();
        WebElement loginMessage = driver.findElement(By.cssSelector(".lead.text-danger"));

        assertEquals(loginMessage.getText(), "Login failed! Please ensure the username and password are valid.",
                "Login was successful");
    }
    //Make Appointment button va redirecta userul la pasul de login,
    // dacă el nu este logat în momentul in care apasă pe buton

    @Test
    public void setMakeAppointmentButton() {

        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();
        assertTrue(driver.getCurrentUrl().contains("profile.php#login"),
                "The user is not redirected to login page");
    }
}