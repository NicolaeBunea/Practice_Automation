package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingAddressesTest {

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

        WebElement billingElement=Driver.findElement(By.className("edit"));
        billingElement.click();

        String firstNameValue="Bunea";
        String lastNameValue="Nicu";
        String companyValue="N/A";
        String countryValue="Romania";
        String streetValue="Soimului nr.12";
        String apValue="6";
        String cityValue="Baciu";
        String pinValue="456776";
        String phoneValue="0744 555 666";
        String emailValue="patron@yahoo.com";

        WebElement firstNameElement= Driver.findElement(By.id("billing_first_name"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement= Driver.findElement(By.id("billing_last_name"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastNameValue);

        WebElement companyElement= Driver.findElement(By.id("billing_company"));
        companyElement.clear();
        companyElement.sendKeys(companyValue);

        JavascriptExecutor js = (JavascriptExecutor) Driver;
        js.executeScript("window.scrollBy(0,500)", "");

        /*WebElement countryArrowElement=Driver.findElement(By.xpath("//span[@class='select2-selection__arrow']"));
        countryArrowElement.click();

        WebElement countryElement= Driver.findElement(By.cssSelector("span[aria-activedescendant='select2-billing_country-result-myq6-AF']"));
        countryElement.click();

        Select drpCountry= new Select(Driver.findElement(By.id("select2-billing_country-container")));
        drpCountry.selectByVisibleText("Romania");*/

        WebElement streetElement=Driver.findElement(By.id("billing_address_1"));
        streetElement.clear();
        streetElement.sendKeys(streetValue);

        WebElement apElement=Driver.findElement(By.id("billing_address_2"));
        apElement.clear();
        apElement.sendKeys(apValue);

        WebElement cityElement=Driver.findElement(By.id("billing_city"));
        cityElement.clear();
        cityElement.sendKeys(cityValue);

        WebElement pinElement=Driver.findElement(By.id("billing_postcode"));
        pinElement.clear();
        pinElement.sendKeys(pinValue);

        WebElement phoneElement=Driver.findElement(By.id("billing_phone"));
        phoneElement.clear();
        phoneElement.sendKeys(phoneValue);

        WebElement emailElement=Driver.findElement(By.id("billing_email"));
        emailElement.clear();
        emailElement.sendKeys(emailValue);

        /*WebElement saveButElemenet= Driver.findElement(By.name("save_address"));
        saveButElemenet.click();*/

























    }
}
