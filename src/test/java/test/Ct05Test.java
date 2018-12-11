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
import pageObject.WidgetPage;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class Ct05Test {
    private WebDriver driver;
    LoginPage login;
    HomePage home;
    WidgetPage widget;

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
     * @method ct05
     * @description Editar nome do widget “Teste” na aba “Test Tab” na tela de “desktop” do sistema.
     */
    @Test
    public void ct05() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
        
        widget = home
                .btnEditWidget();
        
        assertEquals("Desktop - Home", home.getTitle());
        
        home = widget
                .setName("Test Widget")
                .setColor("#4B0082")
                .setColorText("#708090")
                .btnOk2();
        
        assertEquals("Desktop - Home", widget.getTitle());
    }
}