import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class MakeMyTripFlightTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vajintha C\\Desktop\\Comprehensive Assignment\\Question 02 and 03\\src\\test\\Resources\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Open the make my trip application in the browser
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, 15); // Selenium 3.x style


        // Click outside of the login pop up
        driver.findElement(By.tagName("body")).click();


        // click on flights button
        driver.findElement(By.xpath("//span[text()='Flights']")).click();


        // Select ROUND TRIP
        driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();

        // Enter HYB in FROM location dropdown
        WebElement from = driver.findElement(By.id("fromCity"));
        from.click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Hyderabad')]"))).click();

        // Enter MAA in TO location dropdown
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

        // Validate search results
        wait.until(ExpectedConditions.titleContains("Flights"));
        System.out.println("All the available flight details are displayed");

        // Close the browser
        // driver.quit();
    }
}
