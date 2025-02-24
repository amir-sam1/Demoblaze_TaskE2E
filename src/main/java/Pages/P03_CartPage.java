package Pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_CartPage {
    SHAFT.GUI.WebDriver driver;

    public P03_CartPage(SHAFT.GUI.WebDriver driver){this.driver = driver;}

    //Locators
    By placeHolderBtn = By.xpath("//button[@class=\"btn btn-success\" and contains(.,'Place Order')]");
    By nameInput = By.id("name");
    By countryInput = By.id("country");
    By cityInput = By.id("city");
    By cardInput = By.id("card");
    By monthInput = By.id("month");
    By yearInput = By.id("year");
    By purchaseBtn = By.xpath("//button[@onclick=\"purchaseOrder()\" and contains(.,'Purchase')]");
    By verifyPurchaseText = By.xpath("//h2[contains(.,'Thank you for your purchase!')]");
    By verifyPurchaseInfo = By.xpath("//p[@class=\"lead text-muted \"]");

    //Methods

    public P03_CartPage checkOut(String name, String country, String city, String card, String month, String year){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(placeHolderBtn));
        driver.element().click(placeHolderBtn).
                and().type(nameInput,name).
                and().type(countryInput,country).
                and().type(cityInput,city).
                and().type(cardInput,card).
                and().type(monthInput,month).
                and().type(yearInput,year).
                and().click(purchaseBtn);
        return this;
    }

    public void verifyPurchase(){

        String purchaseData = driver.getDriver().findElement(verifyPurchaseInfo).getText();
        System.out.println(purchaseData);
        SHAFT.Validations.verifyThat().object(verifyPurchaseText).contains("Thank you for your purchase!").perform();
    }



}
