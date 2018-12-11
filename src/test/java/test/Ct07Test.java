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
public class Ct07Test {
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
     * @method ct07
     * @description Adicionar uma segunda widget na aba “Test Tab” na tela de “desktop” do sistema;
     *              Adicionar conteúdo na segunda widget com conteúdo na aba “Test Tab” na tela de “desktop” do sistema; 
     *              Excluir a segunda widget na aba “Test Tab” na tela de “desktop” do sistema.
     */
    @Test
    public void ct07() {
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
                .setName("Widget Teste 2")
                .setType("Text")
                .setColor("#00CED1")
                .setColorText("#FFD700")
                .btnOk1();
        
        assertEquals("Desktop - Home", widget.getTitle());
        
        home
            .btnDeleteWidget2()
            .btnOkDelete();
        
        assertEquals("Desktop - Home", home.getTitle());
    }
}