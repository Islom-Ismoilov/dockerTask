package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class GoogleSearchPage {

    WebDriverWait webDriverWait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(className = "gNO89b")
    private WebElement btnSearch;

//    @FindBy(xpath = "//a//h3[text()='Facebook - log in or sign up']")
//    private WebElement facebookLink;
    @FindBy(css = "h3.LC20lb.MBeuO.DKV0Md")
    private WebElement facebookLink;

    public GoogleSearchPage(WebDriver driver) {
        this.webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void searchGoogle(String searchItem){
         try{
             searchBox.sendKeys(searchItem);
         } catch (Exception e){
             System.out.println("Exception caught " + e.getMessage());
         }
    }

    public void clickSearchBtn(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
    }

    public void clickFacebook(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(facebookLink)).click();
    }

    public void assertGooglePageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Google", "Page title is not Google");
    }

    public void assertSearchResultsPageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Facebook - Google Search", "Page title is not the expected search results page");
    }

    public void assertFacebookPageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "Page title is not the expected Facebook page");
    }



}
