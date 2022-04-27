// profileSettings.java
// Adam Weibler
// Contain the settings that users can toggle in the system
// Created 4/20/22

import java.io.*;
import java.util.*;

public class profileSettings {
    public static boolean settingsRepeat = true;
    public static boolean deletedProfile = false;

    // Create properties object
    Properties prop = new Properties();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement organization class
    organization org = new organization();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void openSettings(String profileUsername, String userProfileUsername, boolean checkDOB, boolean balanceAlerts, boolean lockNewAccounts) {
        settingsRepeat = true;

        org.ClearScreen();
        //System.out.println(" DEBUG:: profileUsername: |" + profileUsername + "|\n" +
        //                   " DEBUG:: userProfileUsername: |" + userProfileUsername + "|\n" +
        //                   " DEBUG:: checkDOB: |" + checkDOB + "|\n" +
        //                   " DEBUG:: balanceAlerts: |" + balanceAlerts + "|\n" +
        //                   " DEBUG:: lockNewAccounts: |" + lockNewAccounts + "|\n");

        HS.settingsHP(profileUsername, checkDOB, balanceAlerts, lockNewAccounts);
        UInp.getMenuInput(6,1);
        switch(UInp.userInput) {   
            case 1:
            //System.out.println("* User chose to see settings information *");
            dS.readFullFile("settingsInformation.txt");
            System.out.print("* Type 'next' to move on *\nInput: ");
            UInp.getUserInputString("next", true);
            break;

            case 2:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(checkDOB, checkDOB, balanceAlerts, lockNewAccounts, true, false, userProfileUsername);
            break;

            case 3:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(balanceAlerts, checkDOB, balanceAlerts, lockNewAccounts, false, false, userProfileUsername);
            break;

            case 4:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(lockNewAccounts, checkDOB, balanceAlerts, lockNewAccounts, false, true, userProfileUsername);
            break;

            case 5: 
            //System.out.println("* User chose to delete profile *");
            System.out.print("* Are you sure you want to delete your profile? ** THIS CANNOT BE UNDONE ** (y/n)\nInput: ");
            UInp.getUserInputChar('y', 'n');
            if (UInp.userInputChar == 'y') {
                dS.deleteFile(userProfileUsername);
                settingsRepeat = false;
                deletedProfile = true;
            } 
            break;

            case 6:
            System.out.println("* User chose to exit settings *");
            dS.writeProfileSettings(checkDOB, balanceAlerts, lockNewAccounts, userProfileUsername);
            settingsRepeat = false;
            break;
        }
    }
}
