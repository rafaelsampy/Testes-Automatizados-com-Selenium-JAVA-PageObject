package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class TabPage extends BasePage {
    public TabPage (WebDriver driver){
        super (driver);
    }
    
    @FindBy(xpath = "//*[@id=\"home_tab_form_name\"]")
    WebElement nameTab;
    public TabPage setName(String name) {
        nameTab.clear();
        nameTab.sendKeys(name);
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"home_tab_form_color\"]")
    WebElement colorTab;
    public TabPage setColor(String color) {
        colorTab.clear();
        colorTab.sendKeys(color);
        return this;
    }
    
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/button")
    WebElement btnOk;
    public HomePage btnOk() {
        btnOk.click();
        return new HomePage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}