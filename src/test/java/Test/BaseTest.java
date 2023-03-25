package Test;

import Report.Reportio;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITest;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

@Listeners(value= Reportio.class)
public class BaseTest {
   public static WebDriver driver;
   public static Properties prop;


//    public static WebDriver getDriver() {
//        return driver;
//    }

    public static Properties getProp() {
        return prop;
    }

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        //HashMap key object
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        //by dafult of chrome ,chrome doesn't appeare options
        chromePrefs.put("profile.default.content_settings.popups", 0);
        //path of folder
        // chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        //accept ssl files and all files
        //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }
    @BeforeSuite
    @Parameters({"browser"})
    public void open(String browser) throws IOException {
        prop=new Properties();
        prop.load(new FileInputStream("src/main/java/Properties/prop.properties"));
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
        }else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.navigate().to(prop.getProperty("baseurl"));
    }
    @AfterSuite
    public void close(){
      driver.quit();
    }

    public static void take_screenShoot(String name) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String png = (".\\Screenshoot\\" + name + ".png");
        FileUtils.copyFile(scrFile, new File(png));
    }
    public static void printpage(String name){
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.id("save")).click();
    }
    protected static String random_email(){
        String pattern="ABCDEFGHIJKLMNOPQRSTDNEpUTHQoQUJMHLrErGJyHg89uy71MyuH234567890";
        Random random=new Random();
        StringBuilder rand_email=new StringBuilder();
        while (rand_email.length()<10){
            int index=(int)(random.nextFloat()*pattern.length());
            rand_email.append(pattern.charAt(index));
        }
        String email=rand_email.toString();
        return email+"@gmail.com";
    }
}
