package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","E:\\QA Proj\\Selenium Webdriver With Java Course\\SeleniumProj1\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        driver.manage().window().maximize();
        //System.out.println(driver.getTitle());
        homePage = new HomePage(driver);
/*
        WebElement inputLink = driver.findElement(By.linkText("Shifting Content"));
        inputLink.click();

        WebElement inputLink2 = driver.findElement(By.linkText("Example 1: Menu Element"));
        inputLink2.click();
        List<WebElement> lists = driver.findElements(By.tagName("li"));
        System.out.println(lists.size());*/

/*        List<WebElement> lists = driver.findElements(By.tagName("a"));
        System.out.println(lists.size());*/

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /*    @AfterClass
        public void takeScreenshot(){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/test.png").toPath());
            }catch (IOException e){
                e.printStackTrace();
            }

            //System.out.println("Screenshot taken:" + screenshot.getAbsolutePath());
        }*/
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/test.png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }



/*    public static void main (String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }*/
}
