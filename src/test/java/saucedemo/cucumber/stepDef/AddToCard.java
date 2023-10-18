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

public class AddToCard {
    private WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @Given("User is on login pages")
    public void UserInOnLoginPages() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @When("User enter registered account")
    public void EnterRegisteredAccount() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("User push button login")
    public void UserPushButtonLogin() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User should see inventory pages")
    public void ShouldSeeInventoryPages() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "inventory.html"));
    }

    @When("User clicks on the add to cart button")
    public void userClicksAddToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        addToCartButton.click();
    }

    @And("User clicks on icon wishlist")
    public void userClicksOnIconWishlist() {
        WebElement iconWishlist = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        iconWishlist.click();
    }

    @Then("User should see cart page")
    public void ShouldSeeCartPage() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "cart.html"));
        driver.quit();
    }
}
