package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.Setup;
import pageObject.TabPage;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class Ct03Test {
    private WebDriver driver;
    LoginPage login;
    HomePage home;
    TabPage tab;

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
     * @method ct03
     * @description Editar nome da aba “Aba Teste” na tela de “desktop” do sistema.
     */
    @Test
    public void ct03() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
        
        tab = home
                .btnEditTab();
        
        assertEquals("Desktop - Home", home.getTitle());
        
        home = tab
                .setName("Test Tab")
                .setColor("#000080")
                .btnOk();
        
        assertEquals("Desktop - Home", tab.getTitle());
    }
}