package Tests;

import Base.BaseTest;
import com.sun.source.tree.WhileLoopTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AccountDetailsTest extends BaseTest {
    @Test
    public void metodaAccountDetails() {

        WebElement dismissElement = Driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']"));
        dismissElement.click();

        WebElement myAccountButElementr = Driver.findElement(By.xpath("//a[text()='My Account']"));
        myAccountButElementr.click();

        String expectedPage = "https://shop.demoqa.com/my-account/";
        String actualPage = Driver.getCurrentUrl();
        Assert.assertEquals("The correct page is not displayed", expectedPage, actualPage);

        WebElement usernameLoginElementr = Driver.findElement(By.id("username"));
        String usernameValue = "Bunea";
        usernameLoginElementr.sendKeys(usernameValue);

        WebElement passLoginElementr = Driver.findElement(By.id("password"));
        String passwordValue = "patron69";
        passLoginElementr.sendKeys(passwordValue);

        WebElement rememberMeElement = Driver.findElement(By.id("rememberme"));
        rememberMeElement.click();

        WebElement loginElement = Driver.findElement(By.cssSelector("button[name='login']"));
        loginElement.click();

        WebElement loginValidarionElement = Driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        String helloValue = loginValidarionElement.getText();
        Assert.assertTrue("ERROR: The username or password you entered is incorrect. Lost your password?", helloValue.contains(helloValue));

        WebElement accountDetailsElement=Driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[5]/a"));
        accountDetailsElement.click();

        String firstNameValue="Bunea";
        String lastNameValue="Nicu";
        String emailAddresValue="patron1@yahoo.com";

        WebElement firstNameElement= Driver.findElement(By.id("account_first_name"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement= Driver.findElement(By.id("account_last_name"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastNameValue);

        /*WebElement clearElement= Driver.findElement(By.id("account_email"));
        clearElement.clear();*/

        WebElement emailElement= Driver.findElement(By.id("account_email"));
        emailElement.clear();
        emailElement.sendKeys(emailAddresValue);

        JavascriptExecutor js = (JavascriptExecutor) Driver;
        js.executeScript("window.scrollBy(0,500)", "");

        WebElement saveElement=Driver.findElement(By.cssSelector("button[name='save_account_details']"));
        saveElement.click();

        WebElement messageVerifyElement= Driver.findElement(By.cssSelector("div[role='alert']"));
        String expectedValue="Account details changed successfully.";
        String actualValue=messageVerifyElement.getText();
        Assert.assertEquals("The expected error is displayed",expectedValue,actualValue);









    }
}