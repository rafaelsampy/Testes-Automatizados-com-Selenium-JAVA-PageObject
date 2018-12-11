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
public class HomePage extends BasePage{
    public HomePage (WebDriver driver){
        super (driver);
    }
    
    @FindBy(xpath = "//*[@id=\"desktop-home-tabs-list\"]/li[1]/a/span[2]/span[1]")
    WebElement btnTab;
    public HomePage btnTab() {
        if(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated( By.className("modal fade ng-isolate-scope")))){
            btnTab.click();
        }
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"desktop-home-tabs-list\"]/li/a/span/span")
    WebElement btnCreateTab;
    public TabPage btnCreateTab() {
        btnCreateTab.click();
        return new TabPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"desktop-home-tabs-list\"]/li[1]/a/span[2]/span[2]/i[1]")
    WebElement btnEditTab;
    public TabPage btnEditTab() {
        if(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated( By.className("modal fade ng-isolate-scope")))){
            btnEditTab.click();
        }
        return new TabPage(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"desktop-home-panel\"]/div/div[3]/button")
    WebElement btnAddWidget;
    public WidgetPage btnAddWidget() {
        btnAddWidget.click();
        return new WidgetPage(driver);
    }     
    
    @FindBy(xpath = "//*[@id=\"desktop-home-panel\"]/div/div[2]/ul/li/div[1]/div/button[1]")
    WebElement btnEditWidget;
    public WidgetPage btnEditWidget() {
        btnEditWidget.click();
        return new WidgetPage(driver);
    }
    
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/button")
    WebElement btnOkDelete;
    public HomePage btnOkDelete() {
        btnOkDelete.click();
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"desktop-home-tabs-list\"]/li[1]/a/span[2]/span[2]/i[2]")
    WebElement btnDeleteTab;
    public HomePage btnDeleteTab() {
        btnDeleteTab.click();
        return this;
    }    
    
    @FindBy(xpath = "//*[@id=\"desktop-home-panel\"]/div/div[2]/ul/li/div[1]/div/button[2]")
    WebElement btnDeleteWidget1;
    public HomePage btnDeleteWidget1() {
        btnDeleteWidget1.click();
        return this;
    }     
    
    @FindBy(xpath = "//*[@id=\"desktop-home-panel\"]/div/div[2]/ul/li[2]/div[1]/div/button[2]")
    WebElement btnDeleteWidget2;
    public HomePage btnDeleteWidget2() {
        btnDeleteWidget2.click();
        return this;
    }
    
    @FindBy(xpath = "//*[@id=\"top_bar\"]/div/div[2]/ul[2]/li[3]/a")
    WebElement btnLogout;
    public LogoutPage btnLogout() {
        if(new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated( By.id("preloader")))){
            btnLogout.click();
        }
        return new LogoutPage(driver);
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}