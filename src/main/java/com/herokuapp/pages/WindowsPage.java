package com.herokuapp.pages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowsPage extends BasePage {

    private final By clickHereLink = By.linkText("Click Here");
    private final By newWindowHeadingText = By.tagName("h3");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WindowsPage clickHereLink() {
        log.info("Clicking 'Click Here' link to open a new window");
        driver.findElement(clickHereLink).click();
        return this;
    }

    public WindowsPage switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                log.info("Switching to new window handle: {}", windowHandle);
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    public String getNewWindowHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newWindowHeadingText)).getText();
    }
}