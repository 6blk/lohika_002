package lab_002;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilchenko on 3/26/16.
 */
public class GooglePageObject extends BasePageObject {
    private String navigateURL = "https://www.google.com.ua/";
    private String popUpSelector = ".//*[@id='gbw']/div/div/div[2]/div[4]/div/a";
    //private String popUpSelector = ".gb_Td.gb_xc";
    private String inputTextSelector = "lst-ib";
    private String searchButtonSelector = ".lsb";
    private String searchResultLinks = ".r>a";
    private String searchResultDescriptions = ".st>em";

    public void openGoogle(){
        openURL(navigateURL);
    }

    public void closeGooglePrompt(){
        closePopUpWindow(popUpSelector);

        //the same as just click Button
        //clickButton(popUpSelector);
    }

    public void inputSearchText(String searchForText){
        inputText(searchForText, inputTextSelector);
    }

    public void clickSearchButton(){
        clickButton(searchButtonSelector);
    }

    private List<WebElement> getListOfWebElements(String selector){
        return getListOfElements(selector);
    }

    public void openSpecificSite(String siteURL){
        List<WebElement> linksList = getListOfWebElements(searchResultLinks);
        List<String> links;
        boolean linkFound = false;
        links = new ArrayList<String>();
        for (int i = 0; i< linksList.size(); i++){
            if (linksList.get(i).getAttribute("href").contains(siteURL)){
                links.add(linksList.get(i).getAttribute("href"));
            }
        }

        if(links.isEmpty()){
            System.out.println("There is no any link.");
            linkFound = false;
        }
        else{
            for(int i = 0; i < links.size(); i++){
                openLinkInNewBrowserTab(links.get(i));
                System.out.println(siteURL + " link has been opened: " + links.get(i).toString());
                linkFound = true;
            }
        }

        if (!linkFound){
            System.out.println( siteURL + " was not found");
        }
    }

    public boolean isPresentDescription(String searchForText){
        List<WebElement> descriptionList = getListOfElementsByClass(searchResultDescriptions);
        System.out.println("Number of Descr = " + descriptionList.size());
        boolean isPresent = false;
        int count = 0;
        for(int i = 0; i < descriptionList.size(); i++){
            if(descriptionList.isEmpty()){
                return false;
            }else if (descriptionList.get(i).getText().contains(searchForText)){
                isPresent = true;
                count++;
            }
        }
        System.out.println("Number of Presence = " + count);
        return isPresent;
    }

}
