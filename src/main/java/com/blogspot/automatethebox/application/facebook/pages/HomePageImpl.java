package com.blogspot.automatethebox.application.facebook.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class HomePageImpl extends LoadableComponent<HomePageImpl> implements HomePage {

    // Page Elements.
    @FindBy(css = ".md-toolbar-section-end .md-menu:first-child button[md-menu-trigger]")
    private WebElement accountButton;

    @FindBy(css = ".md-toolbar-section-start .md-title")
    private WebElement titile;


    @FindBy(css = ".md-menu-content-container button")
    private WebElement logoutBtn;

    @FindBy(css = "a[href='#/admin']")
    private WebElement administrationButton;


    // WebDriver instance.
    private WebDriver driver;

    public HomePageImpl(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded()
            throws Error {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, APP_TITLE, "Not on the Facebook Home page.");
    }

    public void closeModal() throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public LoginPage logout() {
        accountButton.click();
        logoutBtn.click();
        return new LoginPageImpl(driver);
    }

    public AdministrationPage navigeteToAdministrationPage(){
        accountButton.click();
        administrationButton.click();
        return new AdministrationPage(driver);
    }

    public String getUserName(){

        return accountButton.getText();
    }

    public String getTitle(){
        return titile.getText();
    }

}
