Scenario: TC_003_JPPMC_001 JPPMC login

Given [Navigation] I navigate to 'p:dewanJPPMC'
When [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
And [Input] I hover on 'User Name Header Button'
And [Input] I click on 'Profile Header Button'
And [Assertion] Verify 'User Name Value' have attribute 'value' with 'p:JPPMCuser.HikmatZomat' value
And [Input] I hover on 'User Name Header Button'
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
