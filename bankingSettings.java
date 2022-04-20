// bankingSettings.java
// Adam Weibler
// Contain the settings that users can toggle in the system
// Created 4/20/22

public class bankingSettings {
    public boolean checkDOB;
    public boolean binaryFiles;

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void openSettings() {
        HS.settingsHP(UInp.username);
        UInp.getMenuInput(5,1);
    }
}
