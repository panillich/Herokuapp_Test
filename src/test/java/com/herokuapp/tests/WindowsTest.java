package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.WindowsPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsTest extends TestBase {

    @Test
    public void testNewWindowHeader() {
        HomePage homePage = new HomePage(driver);
        WindowsPage windowsPage = homePage.open().clickWindowsLink();

        windowsPage.clickHereLink().switchToNewWindow();

        assertThat(windowsPage.getNewWindowHeading())
                .as("Header text on the new tab")
                .isEqualTo("New Window");
    }
}