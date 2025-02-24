package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;

    public P02_HomePage(SHAFT.GUI.WebDriver driver){this.driver=driver;}

    //Locators
    By itemBtn = By.xpath("//a[contains(.,'Samsung galaxy s6')]");
    By addToCartBtn = By.xpath("//a[@class=\"btn btn-success btn-lg\" and contains(.,'Add to cart')]");
    By cartLink = By.xpath("//a[@href=\"cart.html\" and contains(.,'Cart')]");



    //Methods
    public P03_CartPage addItemToCart() throws InterruptedException {
        driver.element().click(itemBtn).
                and().click(addToCartBtn);

        Thread.sleep(3000);
        Alert alert = driver.getDriver().switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        SHAFT.Validations.assertThat().object(alertText).contains("Product added.").perform();
        alert.accept();
        driver.element().click(cartLink);
        return new P03_CartPage(driver);
    }




}
