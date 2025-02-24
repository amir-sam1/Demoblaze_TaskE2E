package Tests;
import Pages.P01_LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class E2ETest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON data;

    @BeforeMethod
    public void Setup(){
        driver = new SHAFT.GUI.WebDriver();
        data = new SHAFT.TestData.JSON("data.json");
        driver.browser().navigateToURL("https://www.demoblaze.com/");

    }


    @Test(description = "E2E scenario from login to checkout")
    public void E2eTest() throws InterruptedException {
        new P01_LoginPage(driver).signUp(data.getTestData("userName"), data.getTestData("password")).
                login(data.getTestData("userName"), data.getTestData("password") ).
                addItemToCart().
                checkOut(data.getTestData("name"), data.getTestData("country"), data.getTestData("city"), data.getTestData("creditCard"), data.getTestData("month"), data.getTestData("year") ).
                verifyPurchase();


    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }



}
