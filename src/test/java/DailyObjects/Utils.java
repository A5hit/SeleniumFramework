package DailyObjects;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {
    public static String[] getLinksFromWebElements(List<WebElement> elements) {
        String[] links = new String[elements.size()];    //Array of the size of carouselBannersLinks
        int j = 0;
        for (WebElement e : elements) {      //inserting links in String Array
            links[j] = e.getAttribute("href");
            j++;
        }
        return links;
    }

    public static String[] getTitleFromWebElement(List<WebElement> element) {
        String[] titles = new String[element.size()];
        int j = 0;
        for (WebElement e : element) {
            titles[j] = e.getText();
            j++;
        }
        return titles;
    }

}
