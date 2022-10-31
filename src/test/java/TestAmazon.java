import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAmazon {
    static WebDriver driver = null;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setUp() {
        htmlReporter = new ExtentHtmlReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void TestAssignment() {
        ExtentTest test = extent.createTest("Navigate to Amazon.in", "Navigate to Amazon.in");
        driver.get("https://www.amazon.in/");
        test.pass("Navigated to amazon.in");
    }

    @AfterTest
    public void tearDownTest() {
        ExtentTest test = extent.createTest("Close Browser", "Close Browser");
        driver.close();
        driver.quit();
        test.pass("Close Browser");
    }

    @AfterSuite
    public void tearDown() {
        // calling flush writes everything to the log file
        extent.flush();
    }

}
