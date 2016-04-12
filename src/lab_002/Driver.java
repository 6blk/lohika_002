package lab_002;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by Danilchenko on 3/26/16.
 */
public class Driver {
    protected static WebDriver webDriver;


    public void startWebDriver(){
        webDriver = new FirefoxDriver();
    }

    public void stopWebDriver(){
        if(webDriver != null){
            webDriver.quit();
        }
    }

    public WebDriver getDriver(){
        return webDriver;
    }
}