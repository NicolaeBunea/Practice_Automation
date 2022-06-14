package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShippingAddresTest {

    public WebDriver Driver;

    @Test
    public void metodaAccountDetails() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        Driver = new ChromeDriver();
        Driver.get("https://shop.demoqa.com/");
        Driver.manage().window().maximize();

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

        WebElement addresesElement=Driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[4]/a"));
        addresesElement.click();

        WebElement billingElement=Driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/div[2]/div[2]/header/a"));
        billingElement.click();

        String firstNameValue="Bunea";
        String lastNameValue="Nicu";
        String companyValue="N/A";
        String countryValue="Romania";
        String streetValue="Soimului nr.12";
        String apValue="6";
        String cityValue="Baciu";
        String pinValue="456776";

        WebElement firstNameElement= Driver.findElement(By.id("shipping_first_name"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement= Driver.findElement(By.id("shipping_last_name"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastNameValue);

        WebElement companyElement= Driver.findElement(By.id("shipping_company"));
        companyElement.clear();
        companyElement.sendKeys(companyValue);

        //contry

        WebElement streetElement= Driver.findElement(By.id("shipping_address_1"));
        streetElement.clear();
        streetElement.sendKeys(streetValue);

        WebElement apElement= Driver.findElement(By.id("shipping_address_2"));
        apElement.clear();
        apElement.sendKeys(apValue);

        WebElement cityElement= Driver.findElement(By.id("shipping_city"));
        cityElement.clear();
        cityElement.sendKeys(cityValue);

        //state

        WebElement pinElement= Driver.findElement(By.id("shipping_postcode"));
        pinElement.clear();
        pinElement.sendKeys(pinValue);

        WebElement saveButElement=Driver.findElement(By.name("save_address"));
        saveButElement.click();

    }
}
