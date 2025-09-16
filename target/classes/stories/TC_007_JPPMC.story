Scenario: TC_007_JPPMC_001 JPPMC  Create Internal Correspondence

Given [Navigation] I navigate to 'p:dewanJPPMC'
And [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Internal Correspondence Button JPPMC'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:CommissionersExportingUser' from the 'Commissioner Internal Correspondence JPPMC' combo box
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Input] I select 'p:MainClassificationValue' from the 'Main Classification Internal Correspondence JPPMC' combo box
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Input] I click on 'Save Button'
And [Progress] I wait for '3' sec
And [Action] I get value from 'Commissioner Internal Correspondence JPPMC' and save it as 'CommissionersExportingUser'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Internal Correspondence Get Serial Number JPPMC' and save it as 'InternalCorrespondenceSerialNumberValue'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
!-- And [Navigation] I scroll to end of page
!-- And [Navigation] I scroll to end of page
And [Input] I click on 'Direction Tab'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Input] I select 'p:CommissionersExportingUser' from the 'Division Input' combo box
And [Input] I click on 'AddButton'
And [Progress] I wait for '4' sec
!-- And [Input] I click on 'Close Notification Button'
!-- And [Progress] I wait for '3' sec
And [Assertion] Verify text of 'Department Liaison Officer Name' contains saved value 'CommissionersExportingUser'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Input] I click on 'Direction Button'
And [Progress] I wait for '4' sec
And [Input] I hover on 'All Task Header Button'
And [Input] I click on 'My Processes List Header Button'
And [Progress] I wait for '3' sec
And [Assertion] Verify 'Process Status' equals 'p:ProcessUnCompletedStatus' text
And [Input] I click on 'My Processes List View Process Button'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Input] I click on 'Incoming Users Directed To'
And [Assertion] Verify 'Incoming User Name Directed To1' equals 'p:MalakAlshishani.username' text
And [Input] I hover on 'All Task Header Button'
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I hover on  'User Name Header Button'
And [Input] I click on 'logout Button'
And [Input] I login as 'p:JPPMCuser.MalakAlshishani' with password 'p:JPPMC.password'
And [Input] I hover on  'All Task Header Button'
And [Input] I click on 'Task List Header Button'
And [Assertion] Verify text of 'Task List First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'Task List View Process Button'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
!-- And [Input] I click on 'Direction Tab'
!-- And [Progress] I wait for '5' sec
And [Input] I click on 'Close Button'
And [Javascript] I accept alert
And [Progress] I wait for '3' sec
And [Input] I hover on 'All Task Header Button'
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I hover on  'User Name Header Button'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
Then [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
And [Input] I hover on 'All Task Header Button'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
And [Input] I hover on  'User Name Header Button'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present



