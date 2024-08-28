Scenario: TC_001_UOP UOP login

Given [Navigation] I navigate to 'p:dewanSCC'
When [Input] I login as 'p:SCCuser.supdew1' with password 'p:SCC.password'
And [Input] I click on 'User Name Header Button'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'p:SCCuser.supdew1' value
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
