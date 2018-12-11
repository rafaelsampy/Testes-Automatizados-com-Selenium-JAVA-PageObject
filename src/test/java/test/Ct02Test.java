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
import pageObject.Setup;
import pageObject.TabPage;

/**
 *
 * @author Rafael Sampy 1634089l
 */
public class Ct02Test {
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
     * @method ct02
     * @description Criar nova aba na tela de “desktop” do sistema.
     */
    @Test
    public void ct02() {
        home = login
                .btnLogin()
                .setName("teste")
                .setPassword("utfpr")
                .btnOk();
        
        assertEquals("Desktop - Home", login.getTitle());
        
        tab = home
                .btnCreateTab();
        
        assertEquals("Desktop - Home", home.getTitle());
        
        home = tab
                .setName("Aba Teste")
                .setColor("#99CC32")
                .btnOk();
        
        assertEquals("Desktop - Home", tab.getTitle());
    }
}