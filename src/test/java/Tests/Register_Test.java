package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Register_Test {

    public WebDriver Driver;

    @Test
    public void metodaRegister(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        Driver=new ChromeDriver();
        Driver.get("https://shop.demoqa.com/my-account/");
        Driver.manage().window().maximize();


        /*List<WebElement> headerButtons= Driver.findElements(By.xpath("//ul[@class='pull-right noo-topbar-right']"));
        Integer index=0;
        while (index< headerButtons.size()){
            if (headerButtons.get(index).getText().equals("https://shop.demoqa.com/my-account/")){
                headerButtons.get(index).click();
                break;
            }
            index++;
        }*/

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

        WebElement usernameLoginElementr= Driver.findElement(By.id("username"));
        String usernameValue="Bunea";
        usernameLoginElementr.sendKeys(usernameValue);

        WebElement passLoginElementr= Driver.findElement(By.id("password"));
        String passwordValue="patron69";
        passLoginElementr.sendKeys(passwordValue);

        WebElement rememberMeElement= Driver.findElement(By.id("rememberme"));
        rememberMeElement.click();

        WebElement loginElement=Driver.findElement(By.cssSelector("button[name='login']"));
        loginElement.click();


        Boolean actualRegPage=Driver.getPageSource().contains("Hello");
        Assert.assertTrue("The expected page was not displayed",actualRegPage);

    }

}
