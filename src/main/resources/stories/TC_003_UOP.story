Scenario: TC_001_UOP UOP login

Given [Navigation] I navigate to 'http://172.16.30.82:8888/login.aspx'
When [Input] I login as 'alaa.abdelbagi' with password 'Aa1'
And [Input] I click on 'User Name Header Button'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'alaa.abdelbagi' value
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
