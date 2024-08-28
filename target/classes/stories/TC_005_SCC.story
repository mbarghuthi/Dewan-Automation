Scenario: TC_001_SCC SCC Create Outgoing

Given [Navigation] I navigate to 'p:dewanSCC'
And [Input] I login as 'p:SCCuser.supdew1' with password 'p:SCC.password'
And [Input] I click on 'Add Process Button'
And [Input] I click on 'Outgoing Button'
When [Input] Set 'Subject Field' value to 'random'
And [Input] I select 'p:GeneralManagerOffice' from the 'General Manager Office SCC' combo box
And [Input] I select 'p:FileName' from the 'File Name SCC' combo box
And [Input] Set 'File Subject SCC' value to 'random'
And [Input] Select 'p:Other' value from 'Receiver Name SCC'
And [Input] I select 'p:Other1' from the 'Sub Receiver Name SCC' combo box
!-- And [Input] I click on 'Save Draft Button'
And [Input] I click on 'Save Button'
And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
And [Action] I get value from 'Outgoing Get Serial Number' and save it as 'OutgoingSerialNumberValue'
And [Progress] I wait for '3' sec
And [Input] I click on 'Direction Tab'
And [Input] I click on 'Direction Button'
And [Input] I click on 'My Processes List Header Button'
And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
Then [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
And [Input] I login as 'p:SCCuser.supply1' with password 'p:SCC.password'
And [Input] I click on 'Tasks To View'
And [Assertion] Verify text of 'Tasks To View First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'View Process Button'
And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
And [Assertion] Verify value of 'Outgoing Get Serial Number' equals saved value 'OutgoingSerialNumberValue'
And [Input] I click on 'Direction Tab'
And [Input] I click on 'View Button'
And [Progress] I wait for '3' sec
And [Input] I click on 'Completed Tasks'
And [Assertion] Verify text of 'Completed Tasks First Subject Text' equals saved value 'SubjectText'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present
