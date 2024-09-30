package DailyObjects.pages;

import DailyObjects.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath = "(//p[@class='new'][normalize-space()='SOLD OUT'])")
    WebElement OutofStockTag;
    @FindBy(xpath = "//a[@class='ccp-anchor']")
    List<WebElement> CollectionPageLinks;
    @FindBy(xpath = "//app-content-item")
    WebElement ProductContainer;

    public CollectionPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @Step("Listing collection pages for test coverage")
    public Set<String> getStudioCollectionPages() {
        Set<String> uniqueLinks = new HashSet<>();  // Use HashSet to ensure unique links
        for (WebElement e : CollectionPageLinks) {
            String link = e.getAttribute("href");
            uniqueLinks.add(link);  // HashSet automatically handles duplicates
        }
        // Convert the Set to an array
        return uniqueLinks;
    }

    @Step("Scroll to the Product Container")
    public void scrollToProductContainer() {
        actions.scrollToElement(ProductContainer).keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).build().perform();
    }

    @Step("Verify for 'Out of Stock' tag ")
    public boolean isProductOutOfStock() {
        try{
            OutofStockTag.isDisplayed();
        }
        catch (NoSuchElementException ignore){
            return false;
        }
        return false;
    }

}
