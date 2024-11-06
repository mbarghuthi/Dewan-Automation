Scenario: TC_008_UOP_001 UOP  Home Page counters assertion

Given [Navigation] I navigate to 'p:dewanUOP'
And [Input] I login as 'p:UOPuser.alaa' with password 'p:password'
!-- My tasks list counter assertion
And [Action] I get text from 'My Tasks Count' and save it as 'NumberOfTasks'
When [Input] I click on 'My Tasks Count'
And [Assertion] Verify text of 'My Tasks Grid Count' equals saved value or zero 'NumberOfTasks'
!-- Tasks list counter assertion
And [Input] I click on 'Home Page'
And [Action] I get text from 'Tasks List Count' and save it as 'NumberOfUnCompletedTask'
And [Input] I click on 'Tasks List Count'
And [Input] Set 'Tasks List Grid Size' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Assertion] Verify value of 'Tasks List GridSize' equals saved value or zero 'NumberOfUnCompletedTask'
!-- Tasks list to view counter assertion
And [Input] I click on 'Home Page'
And [Action] I get text from 'Task List To View Count' and save it as 'TasksforCopyCount'
And [Input] I click on 'Task List To View Count'
And [Input] Set 'Task List To View Grid Size' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Assertion] Verify value of 'Task List To View Grid Size' equals saved value or zero 'TasksforCopyCount'
!-- Generalization counter assertion
And [Input] I click on 'Home Page'
And [Action] I get text from 'Generalization Count' and save it as 'NumberOfGeneralizationTask'
And [Input] I click on 'Generalization Count'
And [Input] Set 'Task List To View Grid Size' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches 'NumberOfGeneralizationTask'
!-- Generalization counter assertion from main bar
And [Action] I get text from 'Generalization Count Main Bar' and save it as 'NumberOfGeneralizationTask'
And [Input] I click on 'Generalization Count Main Bar'
And [Input] Set 'Task List To View Grid Size' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Assertion] Verify number of unwatched generalizations in column 'الاجرائات' to approaches 'NumberOfGeneralizationTask'
!-- Notifications counter assertion
And [Input] I click on 'Home Page'
And [Action] I get text from 'Notifications Count' and save it as 'NumberOfNotifications'
And [Input] I click on 'Notifications Count'
And [Assertion] Verify text of 'Notifications Grid Count' equals saved value or zero 'NumberOfNotifications'
!-- Notifications counter assertion from main bar
And [Action] I get text from 'Notifications Count Main Bar' and save it as 'NumberOfNotifications'
And [Input] I click on 'Notifications Count Main Bar'
And [Assertion] Verify text of 'Notifications Grid Count' equals saved value or zero 'NumberOfNotifications'
!-- Manager Follow-up counter assertion
And [Input] I click on 'Home Page'
And [Action] I get text from 'Manager Follow Count' and save it as 'NumberOfProcessesFollowUp'
And [Input] I click on 'Manager Follow Count'
And [Input] Set 'Manager Follow Grid Size' value to 'p:GeneralizationSizePage'
And [Input] I click on 'Change Grid Size Button'
And [Assertion] Verify value of 'Manager Follow Grid Size' equals saved value or zero 'NumberOfProcessesFollowUp'
!-- Completed tasks counter assertion
!-------------------------------------------------
!-- Failed case of completed tasks
!-------------------------------------------------
!-- And [Input] I click on 'Home Page'
!-- And [Action] I get text from 'Completed Tasks Count' and save it as 'NumberOfTasks'
!-- When [Input] I click on 'Completed Tasks Count'
!-- And [Assertion] Verify text of 'Completed Tasks Grid Count' equals saved value or zero 'NumberOfTasks'
Then [Navigation] I hover over 'User Profile DDL'
And [Input] I click on 'logout Button'
And [Assertion] Verify 'login Button' is present