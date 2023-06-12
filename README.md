# CURA Healthcare Service Automation Script -Sample Project      
The Cura Healthcare Service Automation Script is a Java Selenium-based framework that automates the process of making appointments with the Cura Healthcare Service. It utilizes various tools and technologies, including Maven, Excel for test data management, Extend Report for detailed test reporting, and video recording for capturing the test execution process.It leverages several key technologies and tools to enhance the automation process and provide detailed reporting capabilities.
## Technologies and Tools Used
Java: The programming language I used for developing the automation script. Java offers a robust and object-oriented approach to building reliable and scalable automation frameworks.

Selenium: A widely-used open-source automation framework for web applications. Selenium provides a set of libraries and tools for interacting with web browsers, allowing automated testing and interaction with web elements.

Maven: A popular build automation tool used for managing dependencies, building, and running projects. Maven simplifies the build process and provides a consistent project structure, making it easier to manage and execute the automation script.

Excel: The automation script utilizes Excel sheets to manage test data. Test scenarios, input values, and expected results can be stored in Excel, enabling data-driven testing and easy management of test data.

TestNG: A testing framework that integrates seamlessly with Selenium and provides advanced features such as test parameterization, parallel execution, and test configuration. TestNG helps organize and execute test cases efficiently, making it a valuable component of the automation script.

Extent Report: Extent Report is a versatile reporting framework that generates detailed and interactive reports. It provides comprehensive information about test execution, including test status, logs, and screenshots. These reports help in analyzing test results and identifying issues quickly.

Video Recordings: The automation script incorporates video recording capabilities to capture the test execution process. Video recordings can be useful for debugging, analyzing test flow, and identifying potential issues that may not be evident in logs or reports.

## Page Object Model (POM) Design Pattern

To improve the structure and maintainability of the automation script, I have implemented the Page Object Model (POM) design pattern. The POM design pattern allows for the creation of reusable and modular code by representing each web page or component of the application as a separate class. This class, commonly referred to as a "Page Object," encapsulates the related web elements and actions associated with that page or component.

In my automation script, I have created a dedicated package called "Page" where I store all the Page Object classes. These classes contain methods to interact with the web elements on their respective pages, such as entering text, clicking buttons, and retrieving information. By encapsulating the web elements and actions within the Page Object classes, it becomes easier to maintain and update the automation script as changes to the application occur.

By leveraging the POM design pattern, I ensure that my automation script follows a modular and reusable structure. This allows for easier test case creation, maintenance, and scalability as the application evolves over time. It promotes code reusability, reduces code duplication, and enhances the overall readability and maintainability of the automation script.

With the POM design pattern in place, I can easily update my automation script whenever there are changes to the application's user interface or functionality. I only need to modify the corresponding Page Object class, keeping the changes localized and minimizing the impact on other parts of the script.

###### By combining soft assertions with if conditions, I can perform multiple validations within a test case and collect all the failures without terminating the test execution. This approach provides comprehensive validation coverage and helps in identifying and fixing multiple issues in a single test run.


# Test Cases
### Positive Test Cases

1) Successful Login: Validate that users can log in to the Cura Healthcare Service portal using valid credentials.
2) Appointment Creation: Verify that users can successfully create appointments with correct and complete information.
3) Appointment Confirmation: Ensure that users receive a confirmation message after successfully booking an appointment.
### Negative Test Cases
1) Invalid Login: Validate the system's response when users attempt to log in with invalid or incorrect credentials.
2) Invalid Date Booking: Verify that the system handles and displays appropriate error messages when users attempt to book appointments with invalid dates.
3) Missing Required Fields: Ensure that the system properly handles scenarios where users submit appointment forms with missing or incomplete required fields.


