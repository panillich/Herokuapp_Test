package com.herokuapp.tests;

import com.herokuapp.core.ConfigProvider;
import com.herokuapp.core.TestBase;
import com.herokuapp.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends TestBase {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open()
                .enterUsername(ConfigProvider.getProperty("credentials.username"))
                .enterPassword(ConfigProvider.getProperty("credentials.password"))
                .clickLogin();

        assertThat(loginPage.getFlashMessage())
                .as("Login success message")
                .contains("You logged into a secure area!");
    }
}