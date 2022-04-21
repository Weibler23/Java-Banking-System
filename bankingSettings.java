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
        UInp.getMenuInput(4,1);
        switch(UInp.userInput) {
            case 1:
            System.out.println("* User chose to see settings information *");
            break;

            case 2:
            System.out.println("* User chose to toggle checkDOB *");
            break;

            case 3:
            System.out.println("* User chose to toggle binaryFiles *");
            break;

            case 4:
            Sytem.out.println("* User chose to exit settings *");
            break;
        }
    }
}
