package DailyObjects.testcases;

import DailyObjects.pages.CollectionPage;
import DailyObjects.testComponents.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OssOnCollectionPageTest extends BaseTest {
    WebDriver driver;
    CollectionPage collectionPage;
    SoftAssert softAssert=new SoftAssert();

    @BeforeClass
    public void setUp() throws Exception {
        this.driver = getDriver();
        collectionPage = new CollectionPage(driver);
        driver.navigate().to("https://www.dailyobjects.com/cp?f=cid~8889");
    }

    @Test
    @Description("Test Case Description : Verify that Studio Collection Pages contains any 'Out of Stock' product ")
    public void testOSS() {
        for (String link : collectionPage.getStudioCollectionPages()) {
            driver.get(link);
            collectionPage.scrollToProductContainer();
            softAssert.assertFalse(collectionPage.isProductOutOfStock(),"Product is Out of Stock"+link);
        }
        softAssert.assertAll();
    }
}


