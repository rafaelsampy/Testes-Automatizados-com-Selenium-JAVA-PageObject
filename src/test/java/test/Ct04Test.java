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
public class Ct04Test {
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
     * @method ct04
     * @description Adicionar nova widget na aba “Test Tab” na tela de “desktop” do sistema.
     */
    @Test
    public void ct04() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
        
        widget = home
                .btnTab()
                .btnAddWidget();
        
        assertEquals("Desktop - Home", home.getTitle());
        
        home = widget
                .setName("Widget Teste")
                .setType("Text").setColor("#ff0000")
                .setColorText("#ffff00")
                .btnOk1();
        
        assertEquals("Desktop - Home", widget.getTitle());
    }
}