package com.blogspot.automatethebox.application.facebook.test_scripts;

import com.blogspot.automatethebox.application.facebook.abstract_scripts.AbstractAuthenticationTest;
import com.blogspot.automatethebox.application.facebook.pages.HomePage;
import com.blogspot.automatethebox.application.facebook.pages.HomePageImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public class LoginTest extends AbstractAuthenticationTest {

    @Override
    public void testSetup() {
    }

    @Test(description = "Log into application")
    public void logIntoAppTest() throws InterruptedException {
        homePage.closeModal();
        String username = homePage.getUserName();
        String title = homePage.getTitle();
        assertEquals(username,"ADMIN_123","Wrong username");
        assertEquals(title, "Geo citizen", "Wring title");
        homePage.logout();

    }
}