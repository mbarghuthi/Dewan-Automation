Scenario: TC_001_UOP UOP Admin Precondition

Given [Navigation] I navigate to 'p:dewanAdminUOP'
!-- And [Input] I login admin as 'p:UOPuser.admin' with password 'p:password'
!-- And [Input] I click on 'Process Module Button'
!-- And [Input] I click on 'Process Submodule Button'
!-- And [Input] I click on 'Internal Correspondence Options'
!-- And [Assertion] Verify Radio  'Save Draft On Radio Button' is clicked on
!-- And [Progress] I wait for '3' sec
!-- When [Input] Set 'Save Draft Arabic Caption' value to 'p:SaveDraftArabicCaption'
!-- And [Input] Set 'SaveDraftEnglishCaption' value to 'p:SaveDraftEnglishCaption'
!-- And [Input] I click on 'UpdateButton'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'BackButton'
!-- And [Input] I click on 'FormDesignModuleButton'
!-- And [Input] I click on 'ContentOfFormSubmoduleButton'
!-- !-- And [Input] Select 'FormDropDownList' value from '1406'
!-- And [Input] I click on 'OutgoingMailForm'
!-- And [Progress] I wait for '3' sec
!-- And [Input] Set 'ControlSearchEnglishField' value to 'p:ControlSearchEnglishField'
!-- And [Progress] I wait for '5' sec
!-- And [Input] I click on 'ControlSearchButton'
!-- And [Progress] I wait for '19' sec
!-- And [Input] I click on 'EditOutgoingMailAttachment'
!-- !-- Then [Navigation] I navigate to 'http://172.16.30.82:8889/Form/FormControlsDetails.aspx?FormCtrlID=2472'
!-- And [Progress] I wait for '5' sec
!-- And [Assertion] Verify Checkbox  'MandatoryCheckbox' is clicked on
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'UpdateButton'
!-- And [Progress] I wait for '3' sec
!-- And [Input] I click on 'BackButton'
!-- And [Progress] I wait for '10' sec
