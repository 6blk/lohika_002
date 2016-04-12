package lab_002;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Danilchenko on 3/26/16.
 */
public class Test extends Driver{
    //private Driver driver = new Driver();
    private GooglePageObject googlePageObject = new  GooglePageObject();
    private WikipediaPageObject wikipediaPageObject = new  WikipediaPageObject();

    @org.junit.Test
    public void testGoogleSearch() throws InterruptedException{
        //String searchStr = "Бонд";
        String searchStr = "sdfndfkglvdslkvsk";
        //String searchStr = "Samsung";
        String siteURL = "wikipedia.org";

        startWebDriver();
        googlePageObject.openGoogle();
        googlePageObject.closeGooglePrompt();
        googlePageObject.inputSearchText(searchStr);
        googlePageObject.clickSearchButton();

        Thread.sleep(2000); // Write waiter in the future (Chapter #7 of our Training)

        assertTrue("There is no search String in results !!!", googlePageObject.isPresentDescription(searchStr));

        googlePageObject.openSpecificSite(siteURL);
        // Checking only the last browser tab, handling other tabs will be added in Chapter # 9 of our training.
        assertTrue("This page is not a WikiPage", wikipediaPageObject.isWikipedia());
        //driver.stopWebDriver();
    }
}