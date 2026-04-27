package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import com.herokuapp.core.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By successFlashMsg = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        String url = ConfigProvider.getProperty("base.url") + "/login";
        log.info("Opening Login Page: {}", url);
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        log.info("Entering username: {}", username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Entering password");
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public void clickLogin() {
        log.info("Clicking login button");
        driver.findElement(loginButton).click();
    }

    public String getFlashMessage() {
        log.info("Getting flash message text");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successFlashMsg)).getText();
    }
}