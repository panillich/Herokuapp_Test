package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.core.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By alertsLink = By.linkText("JavaScript Alerts");
    private final By windowsLink = By.linkText("Multiple Windows");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        String url = ConfigProvider.getProperty("base.url") + "/";
        log.info("Opening Home Page: {}", url);
        driver.get(url);
        return this;
    }

    public AlertsPage clickAlertsLink() {
        log.info("Clicking on 'JavaScript Alerts' link");
        driver.findElement(alertsLink).click();
        return new AlertsPage(driver);
    }

    public WindowsPage clickWindowsLink() {
        log.info("Clicking on 'Multiple Windows' link");
        driver.findElement(windowsLink).click();
        return new WindowsPage(driver);
    }
}