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

public class Checkout {

    private WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @Given("User is on login page")
    public void InOnLoginPage() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @When("User enters registered account")
    public void EntersRegisteredAccount() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("User click button login")
    public void UserClickButtonLogin() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User will see inventory pages")
    public void WillSeeInventoryPages() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "inventory.html"));
    }

    @When("User click add to cart button")
    public void ClickAddToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCartButton.click();
    }

    @And("User click icon wishlist")
    public void ClickIconWishlist() {
        WebElement iconWishlist = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        iconWishlist.click();
    }

    @Then("User will see cart page")
    public void WillSeeCartPage() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "cart.html"));
    }

    @And("User clicks on button checkout")
    public void ClickButtonCheckout() {
        WebElement buttonCheckout = driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
        buttonCheckout.click();
    }

    @Then("User should be redirected to the checkout your information page")
    public void RedirectedToInformationPage() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "checkout-step-one.html"));
    }

    @When("User enters valid firstname,lastname and zip")
    public void EntersValidYourInformation() {
        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        WebElement zipField = driver.findElement(By.xpath("//*[@id=\"postal-code\"]"));

        firstNameField.sendKeys("Coba");
        lastNameField.sendKeys("Aja");
        zipField.sendKeys("911");
    }

    @And("User clicks on button continue")
    public void ClickButtonContinue() {
        WebElement buttonCheckout = driver.findElement(By.xpath("//*[@id=\"continue\"]"));
        buttonCheckout.click();
    }

    @Then("User should be redirected to the checkout your checkout overview page")
    public void RedirectedToCheckoutOverview() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "checkout-step-two.html"));
    }

    @And("User clicks on button finish")
    public void ClickButtonFinish() {
        WebElement buttonFinish = driver.findElement(By.xpath("//*[@id=\"finish\"]"));
        buttonFinish.click();
    }

    @And("User clicks on the back home button")
    public void ClickBackToHomeButton() {
        WebElement buttonBackHome = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
        buttonBackHome.click();
    }

    @Then("User should be redirected to the inventory page")
    public void UserRedirectedToInventoryPages() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "inventory.html"));
        driver.quit();
    }
}