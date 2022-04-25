// bankingSettings.java
// Adam Weibler
// Contain the settings that users can toggle in the system
// Created 4/20/22

import java.io.*;
import java.util.*;

public class bankingSettings {
    public static boolean settingsRepeat = true;
    public boolean checkDOB;
    public boolean binaryFiles;
    private String userProfileUsername;

    Properties prop = new Properties();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

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
        dS.parseBoolean(prop.getProperty("db.binaryFiles"));
        binaryFiles = dS.parsedBoolean;
        HS.settingsHP(profileUsername, checkDOB, binaryFiles);
        UInp.getMenuInput(5,1);
        switch(UInp.userInput) {   
            case 1:
            System.out.println("* User chose to see settings information *");
            dS.readFullFile("settingsInformation.txt");
            break;

            case 2:
            System.out.println("* User chose to toggle checkDOB *");
            dS.toggleSettings(checkDOB, checkDOB, binaryFiles, true, userProfileUsername);
            break;

            case 3:
            System.out.println("* User chose to toggle binaryFiles *");
            dS.toggleSettings(binaryFiles, checkDOB, binaryFiles, false, userProfileUsername);
            break;

            case 4: 
            System.out.println("* User chose to delete profile *");
            System.out.print("* Are you sure you want to delete your profile? ** THIS CANNOT BE UNDONE ** (y/n)\nInput: ");
            UInp.getUserInputChar('y', 'n');
            if (UInp.userInputChar == 'y') {
                dS.deleteFile(userProfileUsername);
            } 
            break;

            case 5:
            System.out.println("* User chose to exit settings *");
            dS.writeProfileSettings(checkDOB, binaryFiles, userProfileUsername);
            settingsRepeat = false;
            break;
        }
    }
}
