package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register_Test {

    public WebDriver Driver;

    @Test
    public void metodaRegister(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        Driver=new ChromeDriver();
        Driver.get("https://shop.demoqa.com/my-account/");

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

        WebElement showPassElement= Driver.findElement(By.xpath("//span[@class='show-password-input']"));
        showPassElement.click();

    }

}
