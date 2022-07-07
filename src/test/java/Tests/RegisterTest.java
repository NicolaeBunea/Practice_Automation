package Tests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest extends BaseTest {

    public WebDriver Driver;

    @Test
    public void metodaRegister(){

        WebElement dismissElement = Driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']"));
        dismissElement.click();

        WebElement myAccountButElementr= Driver.findElement(By.xpath("//a[text()='My Account']"));
        myAccountButElementr.click();

        String expectedPage="https://shop.demoqa.com/my-account/";
        String actualPage=Driver.getCurrentUrl();
        Assert.assertEquals("The correct page is not displayed",expectedPage,actualPage);

        WebElement userNameElement= Driver.findElement(By.xpath("//input[@id='reg_username']"));
        String userNameValue="Bunea";
        userNameElement.sendKeys(userNameValue);

        WebElement emailElement= Driver.findElement(By.xpath("//input[@id='reg_email']"));
        String emailValue="patron@yahoo.com";
        emailElement.sendKeys(emailValue);

        WebElement passElement= Driver.findElement(By.xpath("//input[@id='reg_password']"));
        String passValue="patron69";
        passElement.sendKeys(passValue);

        WebElement registerElement= Driver.findElement(By.xpath("//button[@name='register']"));
        registerElement.click();



    }

}
