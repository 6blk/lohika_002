package lab_002;

/**
 * Created by Danilchenko on 3/26/16.
 */
public class WikipediaPageObject extends BasePageObject {
    private String wiki = "wikipedia.org";
    public void printURL(){
        System.out.println("Current ULR is: " + getDriver().getCurrentUrl());
    }

    public boolean isWikipedia(){
        return getDriver().getCurrentUrl().toString().contains(wiki);
    }
}