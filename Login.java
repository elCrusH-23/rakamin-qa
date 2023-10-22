package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
    @Given("I open browser")
    public void iOpenBrowser() {
        final String dir =System.getProperty("user.dir");
        System.out.println("current dir = "+dir);
        System.setProperty("webdriver.chrome.driver",dir +"/driver/chromedriver.exe");
        driver =new ChromeDriver();

    }

    @And("Open website saucedemo")
    public void openWebsiteSaucedemo() throws InterruptedException {
        driver.get("https://saucedemo.com");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("Input valid username")
    public void inputValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("Input valid password")
    public void inputValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("Click button login")
    public void clickButtonLogin() {
        driver.findElement(By.name("login-button")).click();
    }

    @Then("Should Succes login and redirected to homepage")
    public void shouldSuccesLoginAndRedirectedToHomepage() {
        driver.findElement(By.name("add-to-chart-secret-labs-backpack")).isDisplayed();
        driver.close();
        driver.quit();
    }
}
