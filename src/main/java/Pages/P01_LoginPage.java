package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LoginPage {
    SHAFT.GUI.WebDriver driver;

    public P01_LoginPage(SHAFT.GUI.WebDriver driver){this.driver = driver;}


    //Locators
    By signUpLink = By.id("signin2");
    By userNameInput = By.xpath("//input[@id=\"sign-username\"]");
    By passwordInput = By.xpath("//input[@id=\"sign-password\"]");
    By sinUpBtn = By.xpath("//button[contains(.,'Sign up')]");
    By loginLink = By.id("login2");
    By loginUserName = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginBtn = By.xpath("//button[contains(.,'Log in')]");
    By closeBtn = By.xpath("(//button[@aria-label=\"Close\"])[2]");

    //Methods

    public P01_LoginPage signUp(String userName, String password) throws InterruptedException {
        driver.element().click(signUpLink).
                and().type(userNameInput,userName).
                and().type(passwordInput,password).
                and().click(sinUpBtn);
        Thread.sleep(3000);
        Alert alert = driver.getDriver().switchTo().alert();
        alert.accept();
        driver.element().click(closeBtn);
        return this;
    }

    public P02_HomePage login(String userName, String password){
        driver.element().click(loginLink);
        WebDriverWait wait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        wait.until(d -> driver.element().waitUntilPresenceOfAllElementsLocatedBy(loginUserName));
                driver.element().type(loginUserName,userName).
                and().type(loginPassword,password).
                and().click(loginBtn);

        return new P02_HomePage(driver);
    }






}
