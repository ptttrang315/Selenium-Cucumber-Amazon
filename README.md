<!-- TOC -->
* [Introduction](#introduction)
  * [Motivation](#motivation)
  * [Objective](#objective)
    * [Readable](#readable)
    * [Maintainable](#maintainable)
    * [Extensible](#extensible)
* [System Requirements](#system-requirements)
* [Project Structure](#project-structure)
* [Build source and trigger test](#build-source-and-trigger-test)
  * [Build source](#build-source)
  * [Trigger test](#trigger-test)
  * [Reports](#reports)
  * [Cross browsers testing](#cross-browsers-testing)
<!-- TOC -->

# Introduction

## Motivation
Based on the preferred requirements, I would like to choose the tech stack to highlight my experience on the following tech stack and tools: Cucumber, Selenium, Java, Maven.

## Objective

The testing framework should be readable, maintainable and extensible.

### Readable
- With Cucumber feature files, the test scenarios are written in plain English, which is easy to understand and can be reviewed by non-technical stakeholders as well.

### Maintainable
- With the Page Object Model, the test code is separated from the page code, which makes the test code more maintainable.
- With Object Repository, the test code is separated from the element locators. Web element locators are stored in a separate files, which makes it easy to update the locators without changing the test code. As key-value using YAML format, the value can be access via pretty YAML path like `pageName.section.elementName` in the test code.
- Common test libraries are separated from the test script repository, which can be imported to use by multiple test automation project (if any).

### Extensible
- Common test libraries can be extended to support more test scenarios by adding new implementation, libs, etc.
- All dependencies in test library are managed by Maven, which makes it easy to add new dependencies, compile the source, run tests, and distribute the package.

Test results should be well presented.

# System Requirements
- JDK 17+ (Tested on java 17.0.11 2024-04-16 LTS)
- Maven 3.8.x+ (Tested on Apache Maven 3.9.8)
- Internet connection for downloading all dependencies

# Project Structure

[test-parent-pom](test-parent-pom) - Parent POM for all other modules. It contains all common dependencies and plugins for all test projects. When having new version of dependencies, it should be updated here, and all other projects will inherit the new version.

[test-automation-libs](test-automation-libs) - Common test libraries that can be used by multiple test projects. It contains common test libraries, such as common steps, common utilities, etc. Design pattern and best practices should be applied here to structure the test libraries in good shape.

[test-cucumber-framework](test-cucumber-framework) - Test repository to add automated test cased. Cumcumber is used as the BDD framework to write test scenarios in plain English and structure the test script, test data, and other configs in a good shape.

# Build source and trigger test

## Build source

From the root directory, run the following command to build the source code (without triggering tests):

```bash
mvn clean install -DskipTests
```

## Trigger test

Once all dependencies are downloaded and the source code is compiled successfully, run the following command to trigger the test:

```bash
mvn test -Dincludes=CheckoutCart
```

- `-Dincludes`: Specify the test tag to run. In this case, it will run the test scenarios with the tag `@CheckoutCart`.

**Noted**: Application can ask to input the captcha, currently this step needs to be done manually. Test will wait for 90 seconds for the captcha to be solved.

## Reports

After the test is completed, the test report and screenshots will be generated in the [test-cucumber-framework/target/reports](test-cucumber-framework/target/reports) directory. Each execution will generate a subdirectory with timestamp.

When test is failing, there is screenshot attached in the report to show the failure.

## Cross browsers testing

`-Dselenium.browser.type`: Specify the browser to run the test. It can be `chrome`, `firefox` or `edge`. By default, it will run on Chrome.

More config keys can be changed, refer to [test-cucumber-framework/src/test/resources/configuration/seleniumConfiguration.yaml](test-cucumber-framework/src/test/resources/configuration/seleniumConfiguration.yaml)

Test is able to run on different browsers by specifying the browser type. For example, run the following command:

Firefox

```bash
mvn test -Dincludes=CheckoutCart -Dselenium.browser.type=firefox
```

MS Edge

```bash
mvn test -Dincludes=CheckoutCart -Dselenium.browser.type=edge
```