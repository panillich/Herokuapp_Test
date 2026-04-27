package com.herokuapp.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestBase {
    protected WebDriver driver;
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeEach
    public void setUp() {
        log.info("--- Starting Test ---");
        String browser = ConfigProvider.getProperty("browser", "chrome");
        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            log.info("Closing WebDriver");
            driver.quit();
        }
        log.info("--- Test Finished ---\n");
    }
}