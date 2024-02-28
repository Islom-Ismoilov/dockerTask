package TestCases;

import PageObjects.FacebookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookLoginTest extends BaseTest {


    FacebookPage facebookPage;

    @BeforeMethod
    public void initFaceBookPage(){
        facebookPage = new FacebookPage(getDriver());
    }

    @Test
    public void fbPage(){
        getDriver().get("https://facebook.com/");
        //handleCookiesFacebook();
        facebookPage.assertFacebookPageTitle(getDriver());
    }

    public void handleCookiesFacebook(){
        WebElement cookiesAcceptButton = getDriver().findElement(By.xpath("//button[@data-testid='cookie-policy-manage-dialog-accept-button']"));
        if(cookiesAcceptButton.isDisplayed()){
            cookiesAcceptButton.click();
        }
    }
}
