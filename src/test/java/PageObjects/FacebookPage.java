package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FacebookPage {

    public FacebookPage(WebDriver driver){
        this.webDriverWait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
    WebDriverWait webDriverWait;

    @FindBy(id = "email")
    private WebElement emailTxt;
    @FindBy(id = "pass")
    private WebElement passwordTxt;
    @FindBy(name = "login")
    private WebElement loginBtn;

    public void facebookLogin(String username, String password) {
        tryLogin(username, password);
    }

    public void tryLogin(String username, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailTxt)).clear();
        emailTxt.sendKeys(username);

        webDriverWait.until(ExpectedConditions.visibilityOf(passwordTxt)).clear();
        passwordTxt.sendKeys(password);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void assertFacebookPageTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "Page title is incorrect");
    }

    public void assertLoginFacebookTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Log in to Facebook", "Incorrect assertion");
    }

}
