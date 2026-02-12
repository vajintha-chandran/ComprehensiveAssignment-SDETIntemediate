import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MakeMyTripTestNG {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver manually
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vajintha C\\Desktop\\Comprehensive Assignment\\Question 02 and 03\\src\\test\\Resources\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 15);


        driver.get("https://www.makemytrip.com/");


        driver.findElement(By.tagName("body")).click();
    }

    @Test(priority = 1)
    public void testRoundTripFlightSearch() {
        // Click Flights button
        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        // Select ROUND TRIP option
        driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();

        // Enter the value to FROM location
        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Hyderabad')]"))).click();

        // Enter the value to TO location
        WebElement to = driver.findElement(By.id("toCity"));
        to.click();
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MAA");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Chennai')]"))).click();

        // Select Departure Date
        driver.findElement(By.xpath("//div[@aria-label='Wed Mar 20 2024']")).click();

        // Select Return Date
        driver.findElement(By.xpath("//div[@aria-label='Wed Mar 27 2024']")).click();

        // Click Search button
        driver.findElement(By.xpath("//a[text()='Search']")).click();

        // Validate search results are displayed correctly
        wait.until(ExpectedConditions.titleContains("Flights"));
        System.out.println("All the available flight details are displayed");
    }

    @Test(priority = 2)
    public void testOneWayFlightSearch() {
        // Click Flights button
        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        // Select ONE WAY option
        driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();

        // Enter the value to  FROM location
        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("DEL");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Delhi')]"))).click();

        // Enter the value to TO location
        WebElement to = driver.findElement(By.id("toCity"));
        to.click();
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("BOM");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Mumbai')]"))).click();

        // Select a value from Departure Date
        driver.findElement(By.xpath("//div[@aria-label='Wed Mar 20 2024']")).click();

        // Click Search button
        driver.findElement(By.xpath("//a[text()='Search']")).click();

        // Validate search results are displayed correctly
        wait.until(ExpectedConditions.titleContains("Flights"));
        System.out.println("All the available flight details are displayed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
