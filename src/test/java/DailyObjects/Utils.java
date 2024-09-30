package DailyObjects;

import org.openqa.selenium.WebElement;
import java.util.List;


public class Utils {


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
