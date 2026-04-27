package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.AlertsPage;
import com.herokuapp.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {

    @Test
    public void testJsAlert() {
        HomePage homePage = new HomePage(driver);
        AlertsPage alertsPage = homePage.open().clickAlertsLink();

        alertsPage.clickJsAlertButton().acceptAlert();

        assertThat(alertsPage.getResultText())
                .as("Result text for JS Alert")
                .isEqualTo("You successfully clicked an alert");
    }

    @Test
    public void testJsConfirmDismiss() {
        HomePage homePage = new HomePage(driver);
        AlertsPage alertsPage = homePage.open().clickAlertsLink();

        alertsPage.clickJsConfirmButton().dismissAlert();

        assertThat(alertsPage.getResultText())
                .as("Result text for cancelled JS Confirm")
                .isEqualTo("You clicked: Cancel");
    }

    @Test
    public void testJsPromptInput() {
        HomePage homePage = new HomePage(driver);
        AlertsPage alertsPage = homePage.open().clickAlertsLink();

        String inputText = "Selenium Automation Test";

        alertsPage.clickJsPromptButton()
                .sendKeysToAlert(inputText)
                .acceptAlert();

        assertThat(alertsPage.getResultText())
                .as("Result text for JS Prompt")
                .isEqualTo("You entered: " + inputText);
    }
}