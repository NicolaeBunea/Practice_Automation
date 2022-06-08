package Tests.Asserts;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asserts_Info {

    public WebDriver Driver;

    @Test

    public void registerFunction(){
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        Driver=new ChromeDriver();
        Driver.get("https://shop.demoqa.com/my-account/");


    }



}
