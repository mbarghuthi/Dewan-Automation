Scenario: TC_005_JPPMC_001 JPPMC Create Outgoing

Given [Navigation] I navigate to 'p:dewanJPPMC'
And [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Outgoing Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:CommissionersExportingUser' from the 'Commissioners Exporting Outgoing JPPMC' combo box
And [Input] Select 'p:AddresseeNameValue' value from 'Addressee Name Outgoing JPPMC' dropdown list
And [Navigation] I scroll to end of page
And [Input] I click on 'Save Draft Button'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Outgoing Get Serial Number' and save it as 'OutgoingSerialNumberValue'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to end of page
And [Input] I click on 'Save Button'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to end of page
And [Input] I click on 'Direction Tab'
!-- And [Input] I click on 'Add Button'
!-- And [Progress] I wait for '4' sec
!-- And [Input] I click on 'Close Notification Button'
!-- And [Assertion] Verify 'Outgoing User Name Directed To1 JPPMC' equals 'p:manarDojan.username' text
And [Navigation] I scroll to end of page
And [Progress] I wait for '5' sec
And [Input] I click on 'Direction Button'
And [Progress] I wait for '10' sec
And [Input] I hover on  'All Task Header Button'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
And [Input] I hover on  'User Name Header Button'
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
And [Input] I login as 'p:JPPMCuser.MalakAlshishani' with password 'p:JPPMC.password'
And [Input] I hover on  'All Task Header Button'
And [Input] I click on 'Tasks To View'
And [Assertion] Verify text of 'Tasks To View First Subject Text JPPMC' equals saved value 'SubjectText'
And [Input] I click on 'Generalizations View Process Button'
And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
And [Assertion] Verify value of 'Outgoing Get Serial Number' equals saved value 'OutgoingSerialNumberValue'
And [Navigation] I scroll to end of page
And [Navigation] I scroll to end of page
And [Input] I click on 'Direction Tab'
And [Input] I click on 'View Button'
And [Progress] I wait for '5' sec
And [Input] I hover on  'All Task Header Button'
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I hover on  'User Name Header Button'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
