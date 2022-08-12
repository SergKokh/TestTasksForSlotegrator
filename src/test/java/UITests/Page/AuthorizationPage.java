package UITests.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BasePage{

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public void openAuthorization(){
        driver.get(URL);
    }

    public WebElement getLoginField(){
        return driver.findElement(By.id("UserLogin_username"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("UserLogin_password"));
    }
    public WebElement signInBtn(){
        return driver.findElement(By.xpath("//input[@value= 'Sign in']"));
    }

    public WebElement headerIsVisibility() {
        return driver.findElement(By.cssSelector("#header"));
    }

    public WebElement userLoganVisibility() {
        return driver.findElement(By.xpath("//span[contains(text(),  'admin1')]"));
    }

    public WebElement getPlayersListBtn() {
        return driver.findElement(By.xpath("//p[contains(text(), 'Players online / total')]"));
    }
}
