package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class LoginPage extends BasePage {
    public LoginPage (WebDriver driver){
        super (driver);
    }

    @FindBy(xpath = "//*[@id=\"top_bar\"]/div/div[2]/ul/li[2]/a/span")
    WebElement btnLogin;
    public LoginPage btnLogin() {
        btnLogin.click();
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement username;
    public LoginPage setName(String name) {
        username.clear();
        username.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;
    public LoginPage setPassword(String senha) {
        password.clear();
        password.sendKeys(senha);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"login-form\"]/button")
    WebElement btnOk;
    public HomePage btnOk() {
        btnOk.click();
        return new HomePage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}