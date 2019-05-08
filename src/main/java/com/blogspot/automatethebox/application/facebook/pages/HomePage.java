package com.blogspot.automatethebox.application.facebook.pages;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface HomePage {
    String APP_TITLE = "Geo Citizen";

    /**
     * Logout from the Facebook application successfully.
     */
    public LoginPage logout();

    /**
     * Facebook pages navigation.
     */

    public String getUserName();

    public String getTitle();

    public void closeModal() throws InterruptedException;

    public AdministrationPage navigeteToAdministrationPage();
}
