package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public WebDriver Driver;

    @Test
    public void metodaLogin(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        Driver=new ChromeDriver();
        Driver.get("https://shop.demoqa.com/");
        Driver.manage().window().maximize();

        WebElement dismissElement = Driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']"));
        dismissElement.click();

        WebElement myAccountButElementr= Driver.findElement(By.xpath("//a[text()='My Account']"));
        myAccountButElementr.click();

        String expectedPage="https://shop.demoqa.com/my-account/";
        String actualPage=Driver.getCurrentUrl();
        Assert.assertEquals("The correct page is not displayed",expectedPage,actualPage);

        WebElement usernameLoginElementr= Driver.findElement(By.id("username"));
        String usernameValue="Bnea";
        usernameLoginElementr.sendKeys(usernameValue);

        WebElement passLoginElementr= Driver.findElement(By.id("password"));
        String passwordValue="patron69";
        passLoginElementr.sendKeys(passwordValue);

        WebElement rememberMeElement= Driver.findElement(By.id("rememberme"));
        rememberMeElement.click();

        WebElement loginElement=Driver.findElement(By.cssSelector("button[name='login']"));
        loginElement.click();

        WebElement loginValidarionElementr=Driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        String helloValue=loginValidarionElementr.getText();
        Assert.assertTrue("ERROR: The username or password you entered is incorrect. Lost your password?",helloValue.contains(helloValue));






    }





}