package saucedemo.cucumber.stepDef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;


public class LoginTest {

    private WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @When("User enters valid username and password")
    public void userEntersValidCredentials() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User should be redirected to the home page")
    public void userIsRedirectedToHomePage() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "inventory.html"));
    }

    @And("User should see the products")
    public void userShouldSeeProducts() {
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
        driver.quit();
    }

    @When("User enters invalid username or password")
    public void userEntersInvalidCredentials() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter invalid username and/or password
        usernameField.sendKeys("invalid_user");
        passwordField.sendKeys("invalid_password");
    }

    @Then("User should see an error message")
    public void userShouldSeeErrorMessage() {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(errorElement.isDisplayed());
        driver.quit();
    }
}
