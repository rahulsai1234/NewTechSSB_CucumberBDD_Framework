Feature: Login fuctionality

Background:
Given user should be on login page


Scenario: TC01_verifyAppUrl
Then verify application title


Scenario Outline: TC04_VerifyInValidLogin
When user enters userid as "<userid>" and password as "<password>" click on login button
Then user can see the error message on login page
Examples:
|userid | password |
|admin1 | pwd1 |
|admin2 | pwd2 |

Scenario: TC03_VerifyValidLogin
When user enters valid credentials and click on login button
Then user should be navigated to home page
And user can see logout link on home page


@Lead_creation
Scenario: TC05_Lead_E2E_validate

When user enters valid credentials and click on login button
Then user should be navigated to home page
Then user click on New Lead link
Then verify the FirstName Salutation count is 5
And User can select single Salutation
Then verify that FirstName field is Enabled
Then Verify that FirstName field maximum number of characters supported
And verify that Last_Name field is Enabled
Then Verify that Last_Name field maximum number of characters supported
And Verify that Last_Name field accept duplicate character,special symbols,Special sign_..etc
Then Verify that Company_Name is Enabled
And Verify that Company_Name is Displayed
And Verify that designation is Enabled
Then Check whether leadsource dropdown is selected or not
Then Verify that leadsource dropdown count
Then Verify that leadsource dropdown values are in sorted order or not
Then Verify that leadsource dropdown single value can be selected
Then Check whether industry dropdown is displayed or not
Then Verify that industry dropdown count
Then Verify that industry dropdown values are in sorted order or not
Then Verify that industry dropdown single value can be selected
And Verify that user can enter Annual Revenue
And verify that No Of Employees field is Enabled
And verify that Yahoo Id field is Enabled
And Verify that Address information Street field is Enabled
And verify that Address information City field is Enabled
And verify that Address information State field is Enabled
And verify that Address information Postal Code field is Enabled
And verify that Address information Country: field is Enabled
And verify that Description Information Description: field is Enabled
And verify that Lead Information Phone: field is Enabled
And verify that Lead Information Mobile: field is Enabled
And Verify that Lead Information Fax: is Enabled
And verify that Lead Information Email: field is Enabled
And verify that Lead Information Website field is Enabled
Then Verify that Lead Status dropdown count
Then Verify that Lead Status dropdown is sorted form or not
Then click on userRedioButton
Then click on TeamRedioButton
Then Verify that lead is created
Then close browser

@Potential
Scenario: TC06_Potential_E2E_validate

When user enters valid credentials and click on login button
Then user should be navigated to home page
Then user click on New_Potential link
And verify that potentialname is enabled
Then verify that account name should not be enabled
And Verify that Account name search field is clickable 
Then verify that Account Search inside Account Name is enabled by entering name 
And verify thar Account search inside Cityfield is enabled by entring city name
Then verify that search button is able to search 
And verify that Potential Information type option count_Three
  Then Verify that Potential Information type option is not sorted form
And verify that Potential Information type Lead Source count
#Then verify that pick perticular date from calender
And verify the save button should be clickable
  Then verify that Potential_xxx_Click is displayed




