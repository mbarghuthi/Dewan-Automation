Scenario: TC_003_UOP_001 UOP login

Given [Navigation] I navigate to 'p:dewanUOP'
When [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Navigation] I hover over 'User Profile DDL'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'p:UOPuser.alaa' value
Then [Navigation] I hover over 'User Profile DDL'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
