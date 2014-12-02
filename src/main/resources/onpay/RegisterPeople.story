Register People

Narrative:

In order to use OnPay
As a Person
I want to register for OnPay

Scenario: Person Registers for OnPay 
 
Given a browser is on the OnPay registration page
When filling out the registration form with <name> in the name field, <email> in the email address field, <amount> in the initial funding field and clicking on the submit button  
Then OnPay creates an account for <name> and displays their account page

Examples:
|name|email|amount| 
|Sean|xiaopeng.cai@qunar.com|$100|
|Cindy|cindy.yang@qunar.com|$450|
