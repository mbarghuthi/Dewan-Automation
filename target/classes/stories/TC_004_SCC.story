Scenario: TC_004_SCC_001 SCC Create Generalization

Given [Navigation] I navigate to 'p:dewanSCC'
And [Input] I login as 'p:SCCuser.supdew1' with password 'p:SCC.password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Generalization Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] Set 'Generalization Date Field' value to 'date'
And [Action] I get value from 'Generalization Get Year' and save it as 'GeneralizationYearValue'
And [Assertion] Verify 'GeneralizationYearValue' equals current year
And [Navigation] I scroll to end of page
And [Input] I click on 'Save Button'
And [Action] I get value from 'Generalization Get Serial Number' and save it as 'GeneralizationSerialNumberValue'
And [Action] I get text from 'Subject Field' and save it as 'GeneralizationSubjectText'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessUnCompletedStatus' text
And [Progress] I wait for '3' sec
And [Input] I click on 'Task List Header Button'
And [Assertion] Verify text of 'Task List First Subject Text' equals saved value 'GeneralizationSubjectText'
And [Input] I click on 'View Process Button'
And [Input] I click on 'Direction Tab'
And [Input] I click on 'Generalize Button'
And [Progress] I wait for '15' sec
And [Input] I click on 'Generalizations Header Button'
And [Assertion] Verify text of 'Generalization First Subject Text' equals saved value 'GeneralizationSubjectText'
!-- And [Assertion] Verify text of 'Generalization First Serial Number' equals saved value 'GeneralizationSerialNumberValue'
And [Input] I click on 'View Process Button'
And [Input] I click on 'Direction Tab'
And [Assertion] Verify 'Generalize Button' not present
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
And [Input] I login as 'p:SCCuser.supply1' with password 'p:SCC.password'
And [Input] I click on 'Generalizations Header Button'
And [Assertion] Verify text of 'Generalization First Subject Text' equals saved value 'GeneralizationSubjectText'
!-- And [Assertion] Verify text of 'Generalization First Serial Number' equals saved value 'GeneralizationSerialNumberValue'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present


Scenario: TC_004_SCC_002 SCC Check uniqueness serial number for Generalization

Given [Navigation] I navigate to 'p:dewanSCC'
And [Input] I login as 'p:SCCuser.supdew1' with password 'p:SCC.password'
And [Input] I click on 'Generalizations Header Button'
When [Input] Set 'Generalization Size Page Input' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Progress] I wait for '3' sec
And [Action] I get value from 'Generalization Size Page Input' and save it as 'GeneralizationSizePageValue'
Then [Assertion] Verify uniqueness of values in column 'رقم التعميم' to approaches 'GeneralizationSizePageValue'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
