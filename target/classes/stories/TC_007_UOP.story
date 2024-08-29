Scenario: TC_001_UOP UOP  Create Internal Correspondence

Given [Navigation] I navigate to 'p:dewanUOP'
And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Internal Correspondence Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Internal Correspondence Commissioner Destination' combo box
And [Input] I click on 'Save Button'
And [Progress] I wait for '3' sec
And [Action] I get value from 'Internal Correspondence Commissioner Destination' and save it as 'ComboBoxValue'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Internal Correspondence Get Serial Number' and save it as 'InternalCorrespondenceSerialNumberValue'
And [Input] I click on 'Direction Tab'
And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Division Input' combo box
And [Progress] I wait for '3' sec
And [Input] I click on 'Add Button'
And [Progress] I wait for '3' sec
And [Input] I click on 'Close Notification Button'
And [Progress] I wait for '3' sec
And [Assertion] Verify text of 'Department Liaison Officer Name' contains saved value 'ComboBoxValue'
And [Input] I click on 'Direction Button'
And [Progress] I wait for '4' sec
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessUnCompletedStatus' text
And [Input] I click on 'View Process Button'
And [Input] I click on 'Incoming Users Directed To'
And [Assertion] Verify 'Incoming User Name Directed To1' equals 'p:UOPuser.audit1' text
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
And [Input] I login as 'p:UOPuser.audit1' with password 'p:password'
And [Input] I click on 'Task List Header Button'
And [Assertion] Verify text of 'Task List First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'View Process Button'
And [Input] I click on 'Direction Tab'
And [Progress] I wait for '5' sec
And [Input] I click on 'Close Button'
And [Javascript] I accept alert
And [Progress] I wait for '3' sec
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
Then [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present



Scenario: TC_002_UOP UOP  Create Internal Correspondence To view

Given [Navigation] I navigate to 'p:dewanUOP'
And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Internal Correspondence Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Internal Correspondence Commissioner Destination' combo box
!-- And [Input] I click on 'Save Draft Button'
And [Input] I click on 'Save Button'
And [Progress] I wait for '3' sec
And [Action] I get value from 'Internal Correspondence Commissioner Destination' and save it as 'ComboBoxValue'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Internal Correspondence Get Serial Number' and save it as 'InternalCorrespondenceSerialNumberValue'
And [Input] I click on 'Direction Tab'
And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Division Input' combo box
And [Progress] I wait for '3' sec
And [Input] I select the 'To View Radio Button'
And [Progress] I wait for '3' sec
And [Input] I click on 'Add Button'
And [Progress] I wait for '3' sec
And [Input] I click on 'Close Notification Button'
And [Assertion] Verify text of 'Department Liaison Officer Name' contains saved value 'ComboBoxValue'
And [Input] I click on 'Direction Button'
And [Progress] I wait for '4' sec
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
And [Input] I click on 'View Process Button'
And [Input] I click on 'Incoming Users Directed To'
And [Assertion] Verify 'Incoming User Name Directed To1' equals 'p:UOPuser.audit1' text
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
Then [Input] I login as 'p:UOPuser.audit1' with password 'p:password'
And [Input] I click on 'Tasks To View'
And [Assertion] Verify text of 'Tasks To View First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'View Process Button'
And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
And [Assertion] Verify value of 'Internal Correspondence Get Serial Number' equals saved value 'InternalCorrespondenceSerialNumberValue'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present