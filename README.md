# PMobile-automation-framework

Automated Test framework for all PMobile app using Appium & Cucumber with TestNG

Background:

This project serves as the automated functional test framework for Maine Platform application. Below modules that serve as a foundation for this BDD test framework:
1. Appium - (http://appium.io/) This helps to execute automated BDD tests exactly as an end user would: via the mobile interface.
2. Cucumber - (https://cucumber.io/docs) BDD test framework providing the interface by which we are able to write plain and clear, business-facing test cases and execute our automated Appium tests using those same files.
3. TestNG - (https://testng.org/doc/) This helps to run our automated test 


Dependencies:

Below is the list of Maven dependencies used in this project,

1. cucumber-core
2. Cucumber-java
3. cucumber-jvm-deps
4. cucumber-testng
5. testng
6. java-client
7. cucumber-picocontainer

Setup Project Locally:

1. Download and Install Appium Server (http://appium.io/downloads.html) to execute scripts locally
2. Set Environment variable with ANDROID_HOME as Variable name and provide the path of the SDK folder next to Variable value.
