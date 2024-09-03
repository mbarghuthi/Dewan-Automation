Scenario: TC_002_UOP_001 UOP Navigate to link

Given [Navigation] I navigate to 'p:dewanUOP'
!-- And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
!-- !-- TEST
!-- And [Input] I click on 'Add Process Button'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'Outgoing Button'
!-- When [Input] Set 'Subject Field' value to 'random'
!-- And [Input] I select 'p:InternalControlAndAuditUnit' from the 'Division Exporter UOP' combo box
!-- And [Input] I select 'p:TheMinistryOfEducation' from the 'Salutation Hand UOP' combo box
!-- And [Input] I click on 'Save Draft Button'
!-- And [Input] I click on 'Save Button'
!-- And [Action] I get text from 'Subject Field' and save it as 'SubjectText'
!-- And [Action] I get value from 'Outgoing Get Serial Number' and save it as 'OutgoingSerialNumberValue'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'Direction Tab'
!-- And [Assertion] Verify 'Outgoing User Name Directed To1 UOP' equals 'p:UOPuser.audit1' text
!-- And [Input] I click on 'Direction Button'
!-- And [Progress] I wait for '6' sec
!-- And [Input] I click on 'My Processes List Header Button'
!-- And [Assertion] Verify 'Process Status' equals 'p:ProcessCompletedStatus' text
!-- !-- TEST
!-- And [Input] I click on 'SearchHeader'
!-- And [Input] I click on 'SearchButton'
!-- And [Input] I click on 'FirstView'
!-- And [Javascript] I switch to the new tab
!-- And [Assertion] Verify text of 'Subject Field' equals saved value 'SubjectText'
!-- And [Javascript] I closed the new tab
!-- And [Assertion] Verify 'SearchButton' is present