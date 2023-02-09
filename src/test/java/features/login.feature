Feature: Login into TutorialsNinja application

Scenario: Login into the application with valid credentials
Given I navigate to the login page of the application
When I enter username as "anu.aimit.2010@gmail.com" and password as "1234"
And I clicked on Login button
Then I should be able login successfully


