Scenario: TC_001_UOP UOP Create Incoming


Given [Navigation] I navigate to 'p:dewanUOP'
And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Incoming Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] Set 'Num Book From The Source' value to 'nanotime'
And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Commissioner Destination' combo box
!-- Get the department liaison officer name and save it in variable
And [Input] I select 'p:TheMinistryOfEducation' from the 'Source Book By Name' combo box
And [Input] Select 'p:HeadOfArtisticCulturalAn' value from 'Receiver Name'
And [Input] I select '1578' from the 'Delivery' combo box
And [Input] I click on 'Save Draft Button'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Incoming Get Serial Number' and save it as 'IncomingSerialNumberValue'
And [Input] I click on 'Direction Button'
!-- Assertion the department liaison officer name
And [Input] I click on 'Approve Button'
And [Progress] I wait for '4' sec
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessUnCompletedStatus' text
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
And [Input] I login as 'p:UOPuser.audit1' with password 'p:password'
And [Input] I click on 'Task List Header Button'
And [Assertion] Verify text of 'Task List First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'View Process Button'
And [Input] I click on 'Direction Button'
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