package herokuapp_tests;

import org.testng.annotations.Test;

public class HomeButtonTests extends BaseTest {

    @Test
    public void HomeButtonFunctionalityBeingLogged() throws InterruptedException {
        driver.get(baseURLHeroku);
        loginPage.loginWithValidCredentials();
        Thread.sleep(2000);
        homeButtonPage.homePage();
        Thread.sleep(2000);
    }

    @Test
    public void HomeButtonFunctionalityWithoutBeingLogged() throws InterruptedException {
        driver.get(baseURLHeroku);
        loginPage.loginWithValidCredentials();
        Thread.sleep(2000);
        homeButtonPage.logOutButton();
        Thread.sleep(2000);
    }
}
