# FMS V14 Uyeno Web Application Automation Framework
This is POM framework for FMS V14 Project in Selenium using Java as scripting language. Maven is used for dependency management and continuous development. TestNG is used to maintain test cases

<br>

#####Required Software#####
```
Java JDK 11+
Maven installed and in your classpath
Eclipse IDE
```
<br>

#####Dependencies and Libraries Used####
```
Java V11
Maven
Selenium V4
TestNG Framework
Page Object Model (POM) Design Pattern with Page Factory.
Log4j2 - For generating logs.
Extent Reports - For generating videoStatus.
Sikulix - Sikuli is a visual approach to search and automate graphical user interface using screenshots.
SnakeYaml - For handling .yaml files.
HTML Unit Driver - To run browser in headless mode.
Apache POI - For handling screenshots and datadriven.
Lombok - For Accesing getters and setters methods.
Zap ClientApi - For Performing security testing.
MSSQL JDBC - For interacting with MS SQL Database.

```

<br>

### Steps to import the project in Eclipse and execute test suite

**Github repository:** 
[https://github.com/Nikkil123/Uyeno](https://github.com/Nikkil123/Uyeno)

```
Download repo from [https://github.com/Nikkil123/Uyeno] [Uyeno.zip] and unzip it
Go to Eclipse > File > Import > Existing Projects into Workspace
Click on Next 
Click on Browse
Select the Folder Uyeno
Click on Open
Click Finish
```

### Steps to clone and execute test suite
```
git clone https://github.com/Nikkil123/Uyeno.git
cd Uyeno
mvn clean test
```

**Note:**
- Once you Imported the project in eclipse Make sure the project directory is there.
- Once you have same folder structure imported wait for a while until maven download all the dependencies. 
- Test Classes are present in src/test/java folder
- Each Test Class has one or multiple test cases created . Also I have added comments in each class.
<br>
**Now you all set to run the project.**

<br>

## About the Project Structure

### src/main/java

#### Base
Base class is the main class which takes care of Browser setup, loading configuration files.

#### Config
It has the property file used to provide various inputs.

#### FailureScreenshot
Screenshots of failed test cases are saved here with .png format.

#### SkippedScreenshot
Screenshots of skipped test cases are saved here with .png format.

#### SuccessScreenshot
Screenshots of passed test cases are saved here with .png format.

#### Listeners
The Listener class encapsulates the ability to listen for Message s, on behalf of registered Agent s, at specified queues
Retry Failed tests for the specified number of times.

#### Pages
It has a class file for each web page of an application with Page objects and methods.

#### TestData
This includes class that  enables us to run a test method multiple times by passing different data-sets.

#### Utils
This includes classes for global variables and other reusable methods like screenshot, that perform generic actions across the automation execution.

### src/Main/resources
It has a Log4j2 property file.

### src/test/java
A TestNG class is a Java class that contains at least one TestNG annotation. This class contains test cases to be tested.

<br>

###1. Steps to Run the Test Suite using Maven
```
Right click on pom.xml file in the project directory level
Select Run As > Maven Test
```

**Note:** Now test suite is running and It will log all the success or errors on the eclipse console

**Steps to see the results using report.html**

- Go to the Report Directory
- Right click ExtentReports > Open With WebBrowser
- This will open the report in WebBrowser and it will show the entire test suite report

<br>

###2. Steps to Run the Test suite using TestNG
```
Right click on testng.xml file in the project directory level
Select Run As >  TestNG Suite
```

**Note:** Now test suite is running and It will log all the success or errors on the eclipse console

**Steps to see the results using report.html**

- Go to test-output Directory
- Right click index.html > Open With WebBrowser
- This will open the index.html in WebBrowser and it will show the entire test suite report

<br>

**Regards,**
<br>
Nikkil K