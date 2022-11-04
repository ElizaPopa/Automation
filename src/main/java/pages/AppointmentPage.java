package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @FindBy(css = ".btn.btn-default")
    private WebElement goToHomePageButton;
    @FindBy(id = "txt_visit_date")
    private WebElement dateRequired;
    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    public void completeTheDetailsForAppointment() throws InterruptedException {
        makeAppointmentButton.click();
        getUsername().sendKeys("John Doe");
        getPassword().sendKeys("ThisIsNotAPassword");
        getLoginButton().click();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByIndex(1);
        applyForHospitalReadmissionCheckBox.isSelected();
        applyForHospitalReadmissionCheckBox.click();
        List<WebElement> healthcareProgram = driver.findElements(By.className("radio-inline"));
        healthcareProgram.get(2).click();
        selectDateButton.click();
        selectDateButton.sendKeys("10/09/2022");
        Thread.sleep(2000);
        commentField.click();
        commentField.clear();
        commentField.sendKeys("Programare - ora 07:00");
    }

    public void makeAnAppointment() throws InterruptedException {
        bookAppointmentButton.click();
        System.out.println(appointmentConfirmation.getText());
    }

    public void insertingLetersInDateField() throws InterruptedException {
        makeAppointmentButton.click();
        getUsername().sendKeys("John Doe");
        getPassword().sendKeys("ThisIsNotAPassword");
        getLoginButton().click();
        Select facility = new Select(driver.findElement(By.id("combo_facility")));
        facility.selectByIndex(2);
        List<WebElement> healthcareProgram = driver.findElements(By.className("radio-inline"));
        healthcareProgram.get(1).click();
        dateRequired.click();
        dateRequired.sendKeys("Litere in campul Data");
        commentField.click();
        commentField.sendKeys("Nu se pot introduce litere in campul Data");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
        if (dateRequired != dateFormat) {
            System.out.println("Nu se pot introduce litere in campul Visit Date");
        } else {
            System.out.println("Test negativ esuat");
        }
        Thread.sleep(2000);
        bookAppointmentButton.click();
        Thread.sleep(2000);
    }
}




