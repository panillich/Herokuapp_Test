# UI Test Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Selenium](https://img.shields.io/badge/Selenium-4.43.0-green.svg)
![JUnit5](https://img.shields.io/badge/JUnit-5-blue.svg)
![AssertJ](https://img.shields.io/badge/AssertJ-3.27.7-lightgrey.svg)
![Maven](https://img.shields.io/badge/Maven-Build-red.svg)

## Project Overview
This repository contains a robust UI test automation framework developed from scratch. It is designed to demonstrate modern QA engineering practices, focusing on maintainability, readability, and execution stability. 

The test target is [The Internet Herokuapp](https://the-internet.herokuapp.com/), a standard environment for verifying web automation capabilities.

## Engineering Practices & Patterns
This project adheres to Clean Code principles and implements the following architectural patterns:

* **Page Object Model (POM):** Strict separation of UI interaction logic from test scenarios.
* **Fluent Interface:** Method chaining is utilized to create readable, self-documenting test cases.
* **Explicit Synchronization:** Exclusive use of Explicit Waits (`WebDriverWait`). Implicit waits are strictly avoided to prevent race conditions and ensure stable execution across different environments.
* **Configuration Management:** Environment-specific parameters (URLs, browser types) are externalized into `application.properties`.
* **Security & Secret Handling:** Sensitive data (e.g., test credentials) are designed to be injected via Environment Variables. **No secrets are committed to the version control system.**
* **Vulnerability Management:** Dependencies are actively monitored and updated to resolve known CVEs (e.g., AssertJ and Logback updates applied).

## Technology Stack
* **Language:** Java 21
* **Web Automation:** Selenium WebDriver 4
* **Testing Framework:** JUnit 5 (Jupiter)
* **Assertions:** AssertJ (Fluent Assertions for better error tracing)
* **Build Tool:** Apache Maven
* **Logging:** SLF4J & Logback

## Project Architecture

    ├── src/main/java/com/herokuapp
    │   ├── core/                  # Core framework capabilities
    │   │   ├── BasePage.java      # Abstract class with explicit waits setup
    │   │   ├── ConfigProvider.java# Property reader
    │   │   └── WebDriverFactory.java # Browser instantiation logic
    │   └── pages/                 # UI components and interaction methods
    ├── src/test/java/com/herokuapp/tests
    │   ├── core/                  # Test Base (Setup/Teardown configurations)
    │   └── tests/                 # Test suites (Login, Alerts, Windows, etc.)
    └── src/main/resources         # Configurations (application.properties, logback.xml)
    ```


## Local Setup and Execution

### Prerequisites
* Java Development Kit (JDK) 21+
* Apache Maven
* Google Chrome (or Firefox)

### Running the Tests
1. Clone the repository:
       git clone https://github.com/[Your-GitHub-Username]/herokuapp-ui-tests.git
       cd herokuapp-ui-tests

2. Run the test suite via Maven:
       mvn clean test

3. (Optional) Run tests in a specific browser:
       mvn clean test -Dbrowser=firefox


## Continuous Integration (CI)
The framework is integrated with GitHub Actions. On every push or pull request to the `main` branch, the test suite is executed automatically in a headless environment. Execution logs can be found in the **Actions** tab.
