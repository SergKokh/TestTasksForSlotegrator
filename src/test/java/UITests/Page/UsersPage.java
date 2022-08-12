package UITests.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersPage extends BasePage{
    public UsersPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement playerManagerVisibile() {
        return driver.findElement(By.xpath("//i[@class= 'fa fa-th']"));
    }

    public List<WebElement> getListOfPlayersIds() {
        List<WebElement> playerIDs = waitVisibilityOfAllElementsLocatedBy("//table//td[contains(@class, 'hide-mobile')][2]");
        return playerIDs.subList(1, playerIDs.size());
    }

    public WebElement getPlayersIdColumnHeader() {
        return waitElementToBeClickable("//a[normalize-space()='External ID']");
    }

    public List<WebElement> getUnsortedIDPlayerList() {
        return driver.findElements(By.xpath("//table//td[contains(@class, 'hide-mobile')][2]"));
    }


}
