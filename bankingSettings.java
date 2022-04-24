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

    Properties prop = new Properties();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

public void openSettings(String profileUsername) {
        try (InputStream fileInput = new FileInputStream("profileSettings.properties")) {
            prop.load(fileInput);
        } catch (IOException io) {
            io.printStackTrace();
        }

        dS.createFile("profileSettings.properties");
        dS.parseBoolean(prop.getProperty("db.checkDOB"));
        checkDOB = dS.parsedBoolean;
        dS.parseBoolean(prop.getProperty("db.binaryFiles"));
        binaryFiles = dS.parsedBoolean;
        HS.settingsHP(profileUsername, checkDOB, binaryFiles);
        UInp.getMenuInput(5,1);
        switch(UInp.userInput) {   
            case 1:
            System.out.println("* User chose to see settings information *");
            break;

            case 2:
            System.out.println("* User chose to toggle checkDOB *");
            dS.toggleSettings(checkDOB, checkDOB, binaryFiles, true);
            break;

            case 3:
            System.out.println("* User chose to toggle binaryFiles *");
            dS.toggleSettings(binaryFiles, checkDOB, binaryFiles, false);
            break;

            case 4: 
            System.out.println("* User chose to delete profile *");
            break;

            case 5:
            System.out.println("* User chose to exit settings *");
            dS.writeProfileSettings(checkDOB, binaryFiles);
            settingsRepeat = false;
            break;
        }
    }
}
