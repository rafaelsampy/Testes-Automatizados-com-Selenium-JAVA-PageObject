package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class LogoutPage extends BasePage {
    public LogoutPage (WebDriver driver){
        super (driver);
    }
    
    @FindBy(xpath = "//*[@id=\"btn-logout\"]/a/span")
    WebElement btnOk;
    public LoginPage btnLogoutOk() {
        if(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated( By.id("preloader")))){
            btnOk.click();
        }
        return new LoginPage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
