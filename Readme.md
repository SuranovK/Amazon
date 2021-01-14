## Testing and automation tools

1. Selenium Webdriver - for invoking browsers
2. Bonigarcia Webdriver Manager - to setup web drivers
3. Testng - for validations/verification
4. Extentreports - for reporting
5. Maven surefire plugin - to run test suits 
6. Java SE - 1.8
7. Maven - building tool

## Structure of the framework

###POM
 - All elements of every page of the application are stored in 'pages' packages
 - TestBase class - includes methods for setting up the conditions pre execution and after execution
 - All main test classes are in the subpackage of the 'tests' packages
 - Utilities package includes common utility classes:'
 
	 * BrowserUtils - differen types of wait methods and to take screenshot
	 * ConfigurationReader - to read configuration.properties file
	 * Driver - web browser driver method
	 * DynamicData - converting test data 
 - configuration.properties file includes test preference data such as:
 		
	 * url - url of the application to be tested
	 * browser - type of browser
	 * searchItem - data to be searched  
 - All maven dependencies centrlized in pom.xml file
 - Readme.md file for detail information
 
 
### To run 
Go to com.amazon.tests.checkout and open AmazonCheckout.java file
And click on Run menu top of priceVerification() method.
 
### Test reporting
Framework generates new test reports after every execution.
In case of failing, test report includes screenshot.
#### To see test reports
Go to project folder and open report.html file in test-output folder  

## For future refernce
1. Can be used for multi browser and platform testing by adding testng.xml file
2. Can be priortized tests using priority parameter of Testng
3. Can be added new utility classes per need  
   