Scenario: TC_001 login

Given [Navigation] I navigate to 'p:dewanPetra'
When [Input] I login as 'p:userName.admin' with password 'p:password'
And [Input] I click on 'User Name Header Button'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'p:userName.admin' value
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
