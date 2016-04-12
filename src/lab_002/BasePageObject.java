package lab_002;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
//import org.openqa.selenium.WebDriver;

/**
 * Created by Danilchenko on 3/26/16.
 */
public class BasePageObject extends Driver{

    public void openURL(String url){
        getDriver().get(url);
    }

    public void closePopUpWindow(String selector){
        getDriver().findElement(By.cssSelector(selector)).click();
    }

    public void inputText(String text, String selector){
        getDriver().findElement(By.id(selector)).sendKeys(text);
    }

    public void clickButton(String selector){
        getDriver().findElement(By.cssSelector(selector)).click();
    }

    public List<WebElement> getListOfElements(String selector){
        List<WebElement> linksList = getDriver().findElements(By.cssSelector(selector));
        return linksList;
    }

    public List<WebElement> getListOfElementsByClass(String selector) {
        List<WebElement> linksList = getDriver().findElements(By.cssSelector(selector));
        return linksList;
    }

    public void openLinkInNewBrowserTab(String linkURL){
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND + "t");
        getDriver().get(linkURL);
    }
    /*
    public boolean isPresent(){
        return false;
    }
    */
}