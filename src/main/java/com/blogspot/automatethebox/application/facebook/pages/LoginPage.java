package com.blogspot.automatethebox.application.facebook.pages;

/**
 * @author Lalit Kumar
 *         https://automatethebox.blogspot.com
 */
public interface LoginPage {
    String APP_URL = "http://geocitizen.herokuapp.com/#/auth";
    String APP_TITLE = "Geo Citizen";

    /**
     * Login to Facebook application successfully.
     *
     * @param emailOrPhone user login email address or phone number
     * @param password     user password
     */
    public HomePage loginAs(String emailOrPhone, String password);
}
