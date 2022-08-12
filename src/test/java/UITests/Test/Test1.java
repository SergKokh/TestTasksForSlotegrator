package UITests.Test;

import UITests.Page.AuthorizationPage;
import UITests.Page.UsersPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 extends BaseTest{


    private void userAuthorization(){
        AuthorizationPage authorization = new AuthorizationPage(driver);
        authorization.openAuthorization();
        authorization.getLoginField().sendKeys("admin1");
        authorization.getPasswordField().sendKeys("[9k<k8^z!+$$GkuP");
        authorization.signInBtn().click();
    }
    private boolean isSorted(List<WebElement> listOfPlayersIds) {
        String startId = "";
        for (WebElement idPlayer : listOfPlayersIds){
            if (startId.compareTo(idPlayer.getText()) > 0){
                return false;
            }else {
                startId = idPlayer.getText();
            }
        }
        return true;
    }

    @Test
    public void checkAuthorization(){
        AuthorizationPage authorization = new AuthorizationPage(driver);
        userAuthorization();
        Assert.assertTrue(authorization.headerIsVisibility().isDisplayed());
        Assert.assertTrue(authorization.userLoganVisibility().isDisplayed());

    }

    @Test
    public void checkUsersTable(){
        AuthorizationPage authorization = new AuthorizationPage(driver);
        UsersPage users= new UsersPage(driver);
        userAuthorization();
        authorization.getPlayersListBtn().click();

        Assert.assertTrue(users.playerManagerVisibile().isDisplayed());
    }
    @Test
    public void checkSortedIDPlayers() {
        AuthorizationPage authorization = new AuthorizationPage(driver);
        UsersPage users = new UsersPage(driver);
        userAuthorization();
        authorization.getPlayersListBtn().click();
        users.getPlayersIdColumnHeader().click();
        sleep(2);

        Assert.assertTrue(isSorted(users.getListOfPlayersIds()));

    }
}
