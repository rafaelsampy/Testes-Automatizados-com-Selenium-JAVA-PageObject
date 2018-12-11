package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import pageObject.Setup;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class Ct10Test {
    private WebDriver driver;
    LoginPage login;
    HomePage home;
    LogoutPage logout;

    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void before() {
        driver = Setup.setup();
        login = new LoginPage(driver);
    }

    @After
    public void after() {
        driver.close();
    }

    /**
     * @method ct10
     * @description Efetuar Logout do sistema.
     */
    @Test
    public void ct10() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
        
        logout = home
                .btnLogout();
        
        login = logout
                .btnLogoutOk();
        
        assertEquals("claroline", logout.getTitle());
    }
}
