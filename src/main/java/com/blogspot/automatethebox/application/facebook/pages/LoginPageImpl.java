package com.blogspot.automatethebox.application.facebook.pages;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginPageImpl extends LoadableComponent<LoginPageImpl> implements LoginPage {

    // Page Elements.
    @FindBy(id = "a-login")
    private WebElement email;

    @FindBy(id = "a-password")
    private WebElement pass;

    @FindBy(css = "button[type=submit]")
    private WebElement loginbutton;

    // Driver instance.
    private WebDriver driver;

    public LoginPageImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(APP_URL);
    }

    @Override
    protected void isLoaded()
            throws Error {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, APP_TITLE, "Not on the Facebook login page.");
    }

    public HomePage loginAs(String emailOrPhone, String password) {
//        Preconditions.checkNotNull(emailOrPhone, "Email or phone number parameter is null");
//        Preconditions.checkNotNull(password, "Password parameter is null");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-login")));
        email.click();
        email.sendKeys(emailOrPhone);
        pass.click();
        pass.sendKeys(password);
        loginbutton.click();
        return new HomePageImpl(driver);
    }
}
