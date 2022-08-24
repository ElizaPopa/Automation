package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class AppointmentPage extends LoginPage {

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentButton;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement applyForHospitalReadmissionCheckBox;

    @FindBy(id = "txt_visit_date")
    private WebElement selectDateButton;

    @FindBy(id = "txt_comment")
    private WebElement commentField;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;

    @FindBy(className = "lead")
    private WebElement appointmentConfirmation;

    @FindBy(css = "btn.btn-default")
    private WebElement goToHomePageButton;

    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    public void completeTheDetailsForAppointment() throws InterruptedException {
        makeAppointmentButton.click();
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        loginButton.click();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByIndex(1);
        applyForHospitalReadmissionCheckBox.isSelected();
        Thread.sleep(2000);
        applyForHospitalReadmissionCheckBox.click();
        List<WebElement> healthcareProgram = driver.findElements(By.className("radio-inline"));
        Thread.sleep(2000);
        healthcareProgram.get(2).click();
        selectDateButton.click();
        Thread.sleep(2000);
        selectDateButton.sendKeys("10/09/2022");
        Thread.sleep(2000);
        commentField.click();
        commentField.clear();
        commentField.sendKeys("Programare - ora 07:00");
    }
    public void makeAnAppointment() throws InterruptedException {
        bookAppointmentButton.click();
        Thread.sleep(2000);
        System.out.println(appointmentConfirmation.getText());
        goToHomePageButton.click();
    }

    public void failedAppointment() throws InterruptedException {

        makeAppointmentButton.click();
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        loginButton.click();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByIndex(2);
        List<WebElement> healthcareProgram = driver.findElements(By.className("radio-inline"));
        Thread.sleep(2000);
        healthcareProgram.get(1).click();
        bookAppointmentButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(2000);
    }
}




