package DailyObjects.Cucumber;


import DailyObjects.pages.CollectionPage;
import DailyObjects.testComponents.BaseTest;
import DailyObjects.testcases.OssOnCollectionPageTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class stepDefinations extends BaseTest {
    WebDriver driver;
    CollectionPage collectionPage;
    String[] links;


    @Before
    public void setUp() throws IOException {
        this.driver=getDriver();
    }

    @Given("I navigate to Collection listing page")
    public void i_navigate_to_collection_listing_page(){
        collectionPage = new CollectionPage(driver);
        driver.get("https://www.dailyobjects.com/cp?f=cid~8889");
    }

    @When("^I retrieves all collection {pageLinks}$")
    public void I_retrives_all_collection(String string){



    }

}
