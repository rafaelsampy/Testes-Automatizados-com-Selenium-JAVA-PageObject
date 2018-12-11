package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static junit.framework.TestCase.assertEquals;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Setup;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class Ct01Test {
    private WebDriver driver;
    LoginPage login;
    HomePage home;

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
     * @method ct01
     * @description Efetuar Login do sistema.
     */
    @Test
    public void ct01() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
    }
}