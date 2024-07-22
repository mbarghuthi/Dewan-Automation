Scenario: TC_001_UOP UOP Create Outgoing

Given [Navigation] I navigate to 'p:dewanUOP'
And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Outgoing Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:Presidency' from the 'Commissioners Exporting' combo box
And [Input] I select 'p:TheMinistryOfEducation' from the 'Salutation Hand' combo box
And [Input] I click on 'Save Button'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Outgoing Get Serial Number' and save it as 'OutgoingSerialNumberValue'
And [Progress] I wait for '3' sec
And [Input] I click on 'OutgoingUsers Directed To'
And [Assertion] Verify 'Outgoing User Name Directed To1' equals 'p:UOPuser.pressec01' text
And [Assertion] Verify 'Outgoing User Name Directed To2' equals 'p:UOPuser.pressec02' text
And [Input] I click on 'Direction Button'
And [Input] I click on 'Approve Button'
And [Progress] I wait for '4' sec
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
And [Input] I login as 'p:UOPuser.pressec01' with password 'p:password'
And [Input] I click on 'Tasks To View'
And [Assertion] Verify text of 'Task List First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'View Process Button'
And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
And [Assertion] Verify value of 'Outgoing Get Serial Number' equals saved value 'OutgoingSerialNumberValue'
And [Input] I click on 'Direction Button'
And [Input] I click on 'View Button'
And [Progress] I wait for '3' sec
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
