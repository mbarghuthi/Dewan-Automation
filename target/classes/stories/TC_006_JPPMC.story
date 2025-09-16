Scenario: TC_006_JPPMC_001 JPPMC Create Incoming

Given [Navigation] I navigate to 'p:dewanJPPMC'
And [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Incoming Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:CommissionersExportingUser' from the 'Commissioners Exporting Incoming JPPMC' combo box
And [Progress] I wait for '3' sec
And [Input] Select 'p:RecipientsValue' value from 'Recipients Incoming JPPMC' dropdown list
And [Navigation] I scroll to end of page
And [Input] I click on 'Save Draft Button'
And [Progress] I wait for '5' sec
And [Navigation] I scroll to end of page
And [Input] I click on 'Save Button'
And [Progress] I wait for '3' sec
And [Action] I get value from 'Commissioners Exporting Incoming JPPMC' and save it as 'GeneralManagerOfficeComboBoxValue'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Incoming Get Serial Number' and save it as 'IncomingSerialNumberValue'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Navigation] I scroll to end of page
And [Input] I click on 'Direction Tab'
And [Progress] I wait for '3' sec
And [Navigation] I scroll to end of page
And [Navigation] I scroll to end of page
And [Progress] I wait for '3' sec
And [Input] I click on 'Direction Button'
And [Progress] I wait for '6' sec
And [Input] I hover on 'All Task Header Button'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessUnCompletedStatus' text
And [Input] I click on 'My Processes List View Process Button'
!-- And [Progress] I wait for '6' sec
And [Navigation] I scroll to end of page
And [Navigation] I scroll to end of page
And [Navigation] I scroll to end of page
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
And [Progress] I wait for '6' sec
And [Navigation] I scroll to end of page
And [Input] I click on 'Close Button'
And [Progress] I wait for '3' sec
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




Scenario: TC_006_JPPMC_002 JPPMC Create Incoming To view

Given [Navigation] I navigate to 'p:dewanJPPMC'
!-- And [Input] I login as 'p:JPPMCuser.HikmatZomat' with password 'p:JPPMC.password'
!-- And [Input] I click on 'Add Process Button'
!-- And [Input] I click on 'Incoming Button'
!-- When [Input] Set 'Subject Field' value to 'random'
!-- !-- And [Input] Set 'Num Book From The Source' value to 'nanotime'
!-- And [Input] I select 'p:GeneralManagerOffice' from the 'General Manager Office Incoming JPPMC' combo box
!-- And [Progress] I wait for '3' sec
!-- And [Input] Select 'p:RecipientsValue' value from 'Recipients Incoming JPPMC' dropdown list
!-- And [Input] I click on 'Save Draft Button'
!-- And [Input] I click on 'Save Button'
!-- And [Progress] I wait for '3' sec
!-- And [Action] I get value from 'General Manager Office Incoming JPPMC' and save it as 'GeneralManagerOfficeComboBoxValue'
!-- And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
!-- And [Action] I get value from 'Incoming Get Serial Number' and save it as 'IncomingSerialNumberValue'
!-- And [Navigation] I scroll to end of page
!-- And [Navigation] I scroll to end of page
!-- And [Input] I click on 'Direction Tab'
!-- And [Input] I click on 'Click On All Check Box'
!-- And [Input] I click on 'Delete Button'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'Close Notification Button'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I select the 'To View Radio Button'
!-- And [Progress] I wait for '5' sec
!-- And [Navigation] I scroll to end of page
!-- And [Input] I click on 'Add Button'
!-- And [Progress] I wait for '4' sec
!-- And [Input] I click on 'Close Notification Button'
!-- And [Input] I click on 'Direction Button'
!-- And [Progress] I wait for '4' sec
!-- And [Input] I hover on 'All Task Header Button'
!-- And [Input] I click on 'My Processes List Header Button'
!-- And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
!-- And [Input] I click on 'My Processes List View Process Button'
!-- And [Input] I click on 'Incoming Users Directed To'
!-- And [Assertion] Verify 'Incoming User Name Directed To1' equals 'p:manarDojan.username' text
!-- And [Input] I hover on 'All Task Header Button'
!-- And [Input] I click on 'Completed Tasks'
!-- And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
!-- And [Input] I click on 'logout Button'
!-- Then [Input] I login as 'p:JPPMCuser.manarDojan' with password 'p:JPPMC.password'
!-- And [Input] I click on 'Tasks To View'
!-- And [Assertion] Verify text of 'Tasks To View First Subject Text SCC' equals saved value 'SubjectText'
!-- And [Input] I click on 'Generalizations View Process Button'
!-- And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
!-- And [Assertion] Verify value of 'Incoming Get Serial Number' equals saved value 'IncomingSerialNumberValue'
!-- And [Input] I click on 'logout Button'
!-- And [Assertion] Verify 'login Button' is present