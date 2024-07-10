Scenario: TC_001 login

Given [Navigation] I navigate to 'p:dewanPetra'
When [Input] I login as 'p:userName.admin' with password 'p:password'
And [Assertion] Verify 'Generalizations Header Button' equals 'p:dewanHeader' text
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
