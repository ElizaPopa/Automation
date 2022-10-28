package herokuapp_tests;

import implementation.WebdriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ChromeOptionsTests extends BaseTest {
    String urlBasicAjax = "https://testpages.herokuapp.com/styled/the_form_processor.php?ajax=1";

    @Test
    public void mobileTest() {
        ChromeDriver driver = WebdriverManager.getChromeDriverWithOptions();
        driver.get(urlDemoQA);
        driver.quit();
    }

    @Test
    public void waitBasicAjaxTest() {
        basicAjaxPage.getDroplist();
        Assert.assertTrue(driver.getCurrentUrl().contains("the_form_processor.php?ajax=1"),
                "The link is not the correct one");
    }

    @Test
    public void explicitWaitForDropList() {
        basicAjaxPage.dropListOptions();
        Assert.assertTrue(driver.getCurrentUrl().contains("the_form_processor.php?ajax=1"),
                "Wrong link redirection");
    }

    @Test
    public void fiveSecondsRedirectTest() {
        redirectPage.triggerA5SecRedirect();
    }

    @Test
    public void twoSecondsRedirectTest() {
        redirectPage.triggerA2SecRedirect();
    }

    @Test
    public void isTheSameIDAfterRefresh() throws InterruptedException {
        refreshPage.changeableIDAfterRefresh();
        int valueFirstID = Integer.parseInt(refreshPage.getRefreshDate().getText());
        int valueSecondID= Integer.parseInt(refreshPage.getRefreshDateValue().getText());
        Assert.assertEquals(valueFirstID, valueSecondID, "The IDs are not equals");
    }

    @Test
    public void messageAfterFourButtonsClicked() {
        buttonsPage.fourButtons();
        Assert.assertEquals("All Buttons Clicked", buttonsPage.getButtonMessage().getText(),
                "The message is not the intended one");
    }
}