package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Chrome {
    private Chrome(){}
    private static  WebDriver driver;
    //private static Chrome chrome=new Chrome();
    public static void initialize() {
        ChromeOptions options=new ChromeOptions();
        String path="C:\\Users\\DM39K\\IdeaProjects\\lab7\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        options.addArguments("make-default-browser","disable-login-screen-apps","start-maximized");
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(150000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void setDriver(WebDriver d){
        driver=d;
    }
}
