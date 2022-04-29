// profileSettings.java
// Adam Weibler
// Contain the settings that users can toggle in the system
// Created 4/20/22

import java.io.*;
import java.util.*;

public class profileSettings {
    public static boolean deletedProfile = false;
    public static boolean settingsRepeat = true;
    private String username;
    private String password;
    private String profID;

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

    public void openSettings(String profileUsername, String userProfileUsername, String userProfilePath, boolean checkDOB, boolean balanceAlerts, boolean lockNewAccounts, boolean allowForeignCurrency) throws Exception {
        settingsRepeat = true;

        org.ClearScreen();
        //System.out.println(" DEBUG:: profileUsername: |" + profileUsername + "|\n" +
        //                   " DEBUG:: userProfileUsername: |" + userProfileUsername + "|\n" +
        //                   " DEBUG:: checkDOB: |" + checkDOB + "|\n" +
        //                   " DEBUG:: balanceAlerts: |" + balanceAlerts + "|\n" +
        //                   " DEBUG:: lockNewAccounts: |" + lockNewAccounts + "|\n");

        HS.settingsHP(profileUsername, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency);
        UInp.getMenuInput(7,1);
        switch(UInp.userInput) {   
            case 1:
            //System.out.println("* User chose to see settings information *");
            dS.readFullFile("settingsInformation.txt");
            System.out.print("* Type 'next' to move on *\nInput: ");
            UInp.getUserInputString("next", true);
            break;

            case 2:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(checkDOB, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency, true, false, false, userProfileUsername);
            break;

            case 3:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(balanceAlerts, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency, false, false, false, userProfileUsername);
            break;

            case 4:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(lockNewAccounts, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency, false, true, false, userProfileUsername);
            break;

            case 5: 
            dS.toggleSettings(allowForeignCurrency, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency, false, false, true, userProfileUsername);
            break;

            case 6: 
            //System.out.println("* User chose to delete profile *");
            System.out.print("* Are you sure you want to delete your profile? ** THIS CANNOT BE UNDONE ** (y/n)\nInput: ");
            UInp.getUserInputChar('y', 'n');
            if (UInp.userInputChar == 'y') {
                getInfoProperties(userProfilePath + profileUsername + "Info.properties");
                dS.removeLogin(username, password, profID);
                dS.deleteFolder(userProfilePath);
                settingsRepeat = false;
                deletedProfile = true;
            } 
            break;

            case 7:
            System.out.println("* User chose to exit settings *");
            dS.writeProfileSettings(checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency, userProfileUsername);
            settingsRepeat = false;
            break;
        }
    }
    
    private void getInfoProperties(String userProfileUsername) {
        try (InputStream fileInput = new FileInputStream(userProfileUsername)) {
            prop.load(fileInput);
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");
            profID = prop.getProperty("db.profID");
        } catch (IOException io) {
            io.printStackTrace();
        } 
    }
}
