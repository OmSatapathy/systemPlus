Feature: Login feature test

@login @smoke
Scenario Outline: Login with valid credetianls
Given navigate tologin page
When user enter username "<username>" and password "<password>"
Then user land on home page

Examples:
|username  | password  |
| user1    | pass123   |
| user2    | pass456   |
| user3    | pass789   |
