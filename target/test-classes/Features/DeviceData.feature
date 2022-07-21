Feature: User could check his device information

 Scenario Outline: User could check main information of device (Device name , SW version , ... )
    Given  User Navigates to 'About Device' page
    When   User Tabs on Device name Tab
    Then   Device name should be "<Device Name>"
    When   User Tabs on Android Version Tab
    Then   Android Version Should be "<SW Version>"
    When   User Tabs on Model&Hardware Tab
    Then   Model name should be "<Model Name>"
    And    Serial Number should be "<Serial Number>"

   #Scenario 1 & 3  -> Success
   #Scenario 2  -> Fail

   Examples:
   |Device Name       | SW Version  | Model Name          | Serial Number    |
   |Abdulrahman Device| 9           | AOSP on IA Emulator | EMULATOR31X2X10X0|
   |Wagdy Device      | 10          | AOSP on Device      | EMULATOR31X2X10X2|
   |Thirdwayv Device  | 9           | AOSP on IA Emulator | EMULATOR31X2X10X0|