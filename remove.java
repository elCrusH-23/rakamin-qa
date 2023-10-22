package Removeitem;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class remove {
    WebDriver driver;
    @Given("open browser to login")
    public void openBrowserToLogin() {
        final String dir =System.getProperty("user.dir");
        System.out.println("current dir =" +dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("Located saucedemo website")
    public void locatedSaucedemoWebsite() throws InterruptedException{
        driver.get("https://saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();

    }

    @And("Input username valid")
    public void inputUsernameValid() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("Input password valid")
    public void inputPasswordValid() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("Click the login button")
    public void clickTheLoginButton() {
        driver.findElement(By.name("login-button")).click();
    }

    @And("clik add cart button")
    public void clikAddCartButton() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @And("Go to  cart menu")
    public void goToCartMenu() throws InterruptedException{
        driver.get("https://www.saucedemo.com/cart.html");
        Thread.sleep(1000);
        driver.findElement(By.name("continue-shopping")).isDisplayed();
    }

    @When("deleted item in cart")
    public void deletedItemInCart() {
        driver.findElement(By.name("remove-sauce-labs-backpack")).sendKeys(Keys.ENTER);

    }

    @Then("Go back to product menu")
    public void goBackToProductMenu() {
        driver.findElement(By.name("continue-shopping")).sendKeys(Keys.ENTER);
        driver.close();
        driver.quit();
    }
}

