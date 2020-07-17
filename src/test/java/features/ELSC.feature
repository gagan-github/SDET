Feature: This feature is to verify the application functionalities

@ELSC_014
Scenario: To verify whether application allows admin to add a course to user
Given User launches the application "http://elearningm1.upskills.in/index.php" and logs in as an admin 

When Users clicks on Administration tab
And Clicks on Add users to course link
And Selects user from the user list
And Selects course from the course list
And Clicks on Add to the course button
Then The selected users are subscribed to the selected course message should get displayed

@ELSC_015
Scenario: To verify whether application allows admin to add new course category
Given User launches the application "http://elearningm1.upskills.in/index.php" and logs in as an admin 

When Users clicks on Administration tab
And Clicks on Courses Categories link
And Clicks on Add Category icon
And Enters valid credentials in Category Code textbox
And Enters valid credentials in Category name textbox
And Clicks on Yes radio button in Allow adding courses in this category? Section
And Clicks on Add Category button
Then Added Category should get displayed in Courses categories









	
	