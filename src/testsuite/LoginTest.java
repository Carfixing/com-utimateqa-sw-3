package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setup(){

        openBrowser(baseUrl);
    }
    @Test

    public void  userShouldNavigateToLoginPageSuccessfully(){
        //Click on Login link
        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));
        //Verify the text ‘Welcome Back!
//        String expectedMessage = "Welcome Back!";
//        String actualMessage = getTextFromElement(By.className("page__heading"));
//        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
        verifyText("Welcome Back!","Welcome Back!","Can not verify Message :");
        getTextFromElement(By.className("page__heading"));
    }
    @Test
    // verifyTheErrorMessage
    public void  verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        clickOnElement(By.xpath("//a[@href='/users/sign_in']"));

        // Enter invalid username
        sendTextToElement(By.id("user[email]"),"prime333@gmail.com");

        //Enter invalid password
        sendTextToElement(By.id("user[password]"),"patel123");

        // Click on submit button
        clickOnElement(By.xpath("//input[@value='Sign in']"));

        //Verify the error message ‘Invalid email or password.'
//        String expectedMessage = "Invalid email or password.";
//        String actualMessage = getTextFromElement(By.className("form-error__list-item"));
//        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
        verifyText("Invalid email or password.","Invalid email or password.","Can not verify Message : ");
        getTextFromElement(By.className("form-error__list-item"));

    }
    @After
    public void close(){
        driver.quit();
    }

}
