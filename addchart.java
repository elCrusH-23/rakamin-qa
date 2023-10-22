package Addcart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addchart {
    WebDriver driver;
    @Given("open browser login")
    public void openBrowserLogin() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = "+dir);
        System.setProperty("webdriver.chrome.driver",dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Located saucedemo website at login page")
    public void locatedSaucedemoWebsiteAtLoginPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(10000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @And("Input username validate")
    public void inputUsernameValidate() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("Input password validate")
    public void inputPasswordValidate() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("click login button with click")
    public void clickLoginButtonWithClick() {
        driver.findElement(By.name("login-button")).click();
    }

    @When("click item and click add cart button")
    public void clickItemAndClickAddCartButton() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Go to the cart menu")
    public void goToTheCartMenu() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).isDisplayed());
        driver.close();
        driver.quit();
    }


}
