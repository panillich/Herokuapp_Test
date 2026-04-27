package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    private final By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private final By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private final By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private final By resultText = By.id("result");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickJsAlertButton() {
        log.info("Clicking JS Alert button");
        driver.findElement(jsAlertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertsPage clickJsConfirmButton() {
        log.info("Clicking JS Confirm button");
        driver.findElement(jsConfirmButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertsPage clickJsPromptButton() {
        log.info("Clicking JS Prompt button");
        driver.findElement(jsPromptButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    public AlertsPage acceptAlert() {
        log.info("Accepting alert");
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage dismissAlert() {
        log.info("Dismissing alert");
        driver.switchTo().alert().dismiss();
        return this;
    }

    public AlertsPage sendKeysToAlert(String text) {
        log.info("Sending text to alert: {}", text);
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public String getResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }
}