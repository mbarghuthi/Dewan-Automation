Scenario: TC_001 login

Given [Navigation] I navigate to 'p:dewan'
When [Input] I login as 'p:userName.admin' with password 'p:password'
And [Assertion] Verify 'Generalizations Header Button' equals 'p:dewanHeader' text
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present


Scenario: TC_002 Create Generalization Process

Given [Navigation] I navigate to 'p:dewan'
And [Input] I login as 'p:userName.admin' with password 'p:password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Generalization Button'
When [Input] Set 'Generalization Subject Field' value to 'random'
And [Input] Set 'Generalization Date Field' value to 'date'
And [Input] I click on 'Generalization Save Button'
And [Action] I get value from 'Generalization Get Serial Number' and save it as 'GeneralizationSerialNumberValue'
And [Action] I get text from 'Generalization Subject Field' and save it as 'GeneralizationSubjectText'
And [Input] I click on 'Generalization Direction Button'
And [Input] I click on 'Generalize Button'
Then [Input] I click on 'Generalizations Header Button'
And [Assertion] Verify text of 'Generalization First Subject Text' equals saved value 'GeneralizationSubjectText'
And [Assertion] Verify text of 'Generalization First Serial Number' equals saved value 'GeneralizationSerialNumberValue'
Then [Input] I click on 'logout Button'
