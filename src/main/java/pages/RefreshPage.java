package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RefreshPage extends BasePage {
    public static final String URL_REFRESH = "https://testpages.herokuapp.com/styled/refresh";
    public static final String REFRESH_DATE_VALUE_ID = "embeddedrefreshdatevalue";
    public static final String REFRESH_DATE = "refreshdate";
    @FindBy(id = REFRESH_DATE_VALUE_ID)
    private WebElement refreshDateValue;
    @FindBy(id = REFRESH_DATE)
    private WebElement refreshDate;

    public WebElement getRefreshDateValue() {
        return refreshDateValue;
    }

    public WebElement getRefreshDate() {
        return refreshDate;
    }

    public RefreshPage(WebDriver driver) {
        super(driver);
    }

    public void changeableIDAfterRefresh() throws InterruptedException {
        driver.get(URL_REFRESH);
        System.out.println(refreshDate.getText());
        System.out.println(refreshDateValue.getText());
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println(refreshDate.getText());
        System.out.println(refreshDateValue.getText());
    }
}
