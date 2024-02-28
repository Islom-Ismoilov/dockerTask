package TestCases;

import PageObjects.GoogleSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleSearchTest extends BaseTest{

    private  GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void initPage(){
        googleSearchPage = new GoogleSearchPage(getDriver());
    }


    @Test
    public void searchOperation(){
        getDriver().get("https://google.com/");
        //handleCookiesGoogle();
        googleSearchPage.assertGooglePageTitle(getDriver());
        googleSearchPage.searchGoogle("Facebook");
    }

    @Test(dependsOnMethods = "searchOperation")
    public void clickSearchButton(){
        googleSearchPage.clickSearchBtn();
        googleSearchPage.assertSearchResultsPageTitle(getDriver());
    }


    public void handleCookiesGoogle(){
        WebElement cookiesAcceptButton = getDriver().findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        if(cookiesAcceptButton.isDisplayed()){
            cookiesAcceptButton.click();
        }
    }
}
