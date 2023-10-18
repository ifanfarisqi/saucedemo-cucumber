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

public class FilterTest {

    private WebDriver driver;
    private String baseUrl = "https://www.saucedemo.com/";

    @Given("User on login page")
    public void LoginPage() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
    }

    @When("User enter registered username and password")
    public void EnterRegisteredUsernameAndPassword() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
    }

    @And("User press button login")
    public void PressLoginButton() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("User should see inventory page")
    public void RedirectedToInventoryPage() {
        assertTrue(driver.getCurrentUrl().equals(baseUrl + "inventory.html"));
    }

    @And("User should see products")
    public void ShouldSeeProducts() {
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
    }

    @When("User clicks list product on the filter button")
    public void userClicksFilterButton() {
        WebElement filterButton = driver.findElement(By.className("product_sort_container"));
        filterButton.click();
    }

    @And("User select list product in the filters list bar")
    public void userSelectListProduct() {
        WebElement listProductOption = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
    }
    @Then("User should see a list of matching products")
    public void userShouldSeeMatchingProducts() {
        assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());
        driver.quit();
    }
}