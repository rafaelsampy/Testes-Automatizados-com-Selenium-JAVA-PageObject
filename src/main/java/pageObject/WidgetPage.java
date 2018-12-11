package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Rafael Sampy 1634089
 */
public class WidgetPage extends BasePage {
    public WidgetPage (WebDriver driver){
        super (driver);
    }
    
    @FindBy(xpath = "//*[@id=\"widget_instance_config_form_name\"]")
    WebElement nameWidget;
    public WidgetPage setName(String name) {
        nameWidget.clear();
        nameWidget.sendKeys(name);
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"widget_instance_config_form_widget\"]")
    WebElement typeWidget;
    public WidgetPage setType(String type) {
        new Select(typeWidget).selectByVisibleText(type); 
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"widget_instance_config_form_color\"]")
    WebElement colorWidget;
    public WidgetPage setColor(String color) {
        colorWidget.clear();
        colorWidget.sendKeys(color);
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"widget_instance_config_form_textTitleColor\"]")
    WebElement colorTextWidget;
    public WidgetPage setColorText(String colorText) {
        colorTextWidget.clear();
        colorTextWidget.sendKeys(colorText);
        return this;
    }
    
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[2]/button")
    WebElement btnOk1;
    public HomePage btnOk1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(btnOk1)).click();
        return new HomePage(driver);
    }
    
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/button")
    WebElement btnOk2;
    public HomePage btnOk2() {
        btnOk2.click();
        return new HomePage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}