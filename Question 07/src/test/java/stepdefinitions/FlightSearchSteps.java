package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class FlightSearchSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("user launches the MakeMyTrip website")
    public void launchWebsite() {
        driver.get("https://www.makemytrip.com/");
    }

    @When("user clicks on Flights")
    public void clickFlights() {
        driver.findElement(By.xpath("//span[text()='Flights']")).click();
    }

    @When("user selects Round Trip")
    public void selectRoundTrip() {
        driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
    }

    @When("user enters From location as {string}")
    public void enterFromLocation(String from) {
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
        driver.findElement(By.xpath("//p[contains(text(),'" + from + "')]")).click();
    }

    @When("user enters To location as {string}")
    public void enterToLocation(String to) {
        driver.findElement(By.id("toCity")).click();
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
        driver.findElement(By.xpath("//p[contains(text(),'" + to + "')]")).click();
    }

    @When("user selects departure and return dates")
    public void selectDates() {
        driver.findElement(By.xpath("//div[@aria-label='Mon Mar 25 2024']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']")).click();
    }

    @When("user clicks on Search button")
    public void clickSearch() {
        driver.findElement(By.xpath("//a[text()='Search']")).click();
    }

    @Then("search results page should be displayed")
    public void verifySearchResults() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("flight"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
