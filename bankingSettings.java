// bankingSettings.java
// Adam Weibler
// Contain the settings that users can toggle in the system
// Created 4/20/22

import java.io.*;
import java.util.*;

public class bankingSettings {
    public static boolean settingsRepeat = true;
    public boolean checkDOB;
    public boolean balanceAlerts;
    private String userProfileUsername;

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

public void openSettings(String profileUsername) {
    userProfileUsername = profileUsername + " ProfileSettings.properties";

    dS.createFile(userProfileUsername);

        try (InputStream fileInput = new FileInputStream(userProfileUsername)) {
            prop.load(fileInput);
        } catch (IOException io) {
            io.printStackTrace();
        }

        dS.parseBoolean(prop.getProperty("db.checkDOB"));
        checkDOB = dS.parsedBoolean;
        dS.parseBoolean(prop.getProperty("db.balanceAlerts"));
        balanceAlerts = dS.parsedBoolean;
        org.ClearScreen();
        HS.settingsHP(profileUsername, checkDOB, balanceAlerts);
        UInp.getMenuInput(5,1);
        switch(UInp.userInput) {   
            case 1:
            //System.out.println("* User chose to see settings information *");
            dS.readFullFile("settingsInformation.txt");
            System.out.print("* Type 'next' to move on *\nInput: ");
            UInp.getUserInputString("next", true);
            break;

            case 2:
            //System.out.println("* User chose to toggle checkDOB *");
            dS.toggleSettings(checkDOB, checkDOB, balanceAlerts, true, userProfileUsername);
            break;

            case 3:
            //System.out.println("* User chose to toggle balanceAlerts *");
            dS.toggleSettings(balanceAlerts, checkDOB, balanceAlerts, false, userProfileUsername);
            break;

            case 4: 
            //System.out.println("* User chose to delete profile *");
            System.out.print("* Are you sure you want to delete your profile? ** THIS CANNOT BE UNDONE ** (y/n)\nInput: ");
            UInp.getUserInputChar('y', 'n');
            if (UInp.userInputChar == 'y') {
                dS.deleteFile(userProfileUsername);
                settingsRepeat = false;
            } 
            break;

            case 5:
            System.out.println("* User chose to exit settings *");
            dS.writeProfileSettings(checkDOB, balanceAlerts, userProfileUsername);
            settingsRepeat = false;
            break;
        }
    }
}
