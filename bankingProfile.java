// bankingProfile.java
// Adam Weibler
// Allow the user to create and open profiles
// Created: 4/12/22

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;
import java.io.*;
import java.util.*;

public class bankingProfile {
    public boolean allowForeignCurrency;
    public boolean balanceAlerts;
    public boolean checkDOB;
    public boolean lockNewAccounts;
    public boolean profileHS = true;
    public String username;
    public String password;
    public String sID;
    private String birthday;
    private String userProfilePath;
    private String userProfileSettings;
    private int ID = 0;

    // Create properties object
    Properties prop = new Properties();

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement account class
    bankingAccounts Acc = new bankingAccounts();

    // Implement profileSettings class
    profileSettings profileSettings = new profileSettings();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen();

    // Implement organization class
    organization org = new organization();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void openProfile() throws Exception {
        UInp.getUserInputSecurity("ProfileLogin.txt");

        userProfilePath = ("Profiles/" + UInp.username + "/");
        userProfileSettings = userProfilePath + UInp.username + "Settings.properties";
        dS.createFile(userProfileSettings);

        parseProperties(userProfileSettings);

        do {
            profileHS = true;
            org.ClearScreen();
            HS.profileHP(UInp.username, UInp.profID);
            UInp.getMenuInput(5, 1);

            switch (UInp.userInput) {
                case 1:
                System.out.println("* User chose to see all existing accounts *\n");

                // DEBUG
                System.exit(0);
                break;

                case 2:
                System.out.println("* User chose to open an account *\n");
                //Acc.openAccount(balanceAlerts);
                break;

                case 3:
                System.out.println("* User chose to open a new account *\n");
                Acc.newAccount(lockNewAccounts, checkDOB);
                break;

                case 4:
                System.out.println("* User chose to enter profile settings *\n");
                do {
                    parseProperties(userProfileSettings);
                    //System.out.println(//" DEBUG:: profileUsername: |" + profileUsername + "|\n" +
                    //       " DEBUG:: userProfileUsername: |" + userProfileUsername + "|\n" +
                    //       " DEBUG:: checkDOB: |" + checkDOB + "|\n" +
                    //       " DEBUG:: balanceAlerts: |" + balanceAlerts + "|\n" +
                    //       " DEBUG:: lockNewAccounts: |" + lockNewAccounts + "|\n");
                    profileSettings.openSettings(UInp.username, userProfileSettings, userProfilePath, checkDOB, balanceAlerts, lockNewAccounts, allowForeignCurrency);
                } while (profileSettings.settingsRepeat == true);
                break;

                case 5:
                System.out.println("* User chose to return to home page *\n");
                profileHS = false;
                break;
            }
        } while ((profileHS) && ((profileSettings.deletedProfile) == false));
    }

    public void createProfile() {
        System.out.print("\n|Create your username |\n" +
                           "Input: ");
        username = input.nextLine();

        System.out.print("\n|Create your password |\n" +
                           "Input: ");
        password = input.nextLine();

        System.out.print("\n|Enter your birthday (MM-dd-yyyy) |\n" +
                           "Input: ");
        UInp.getDOB();
        
        org.ClearScreen();
        generateID();
        System.out.print("**---------------------------------WARNING---------------------------------**\n" +
                           "* There is no way to recover a forgotten username, password, or profile ID. *\n" +
                           "*                   Please make sure to write these down!                   *\n" +
                           "**-------------------------------------------------------------------------**\n");
        System.out.format("* Profile ID: %-62s*%n", ID);
        System.out.format("* Username: %-64s*%n", username);
        System.out.format("* Password: %-64s*%n", password);
        System.out.println("**-------------------------------------------------------------------------**\n");
        System.out.print("* Type 'next' to move on *\nInput: ");
        UInp.getUserInputString("next", false);

        dS.writeProfileLogin(username, password, sID);

        userProfilePath = ("Profiles/" + username + "/");

        // Create user profile directory
        dS.createFolder("Profiles/" + username);

        // Create user profileSettings.properties
        dS.createFile(userProfilePath + username + "Settings.properties");
        dS.writeProfileSettings(false, true, true, false, userProfilePath + username + "Settings.properties");

        // Create user profileInfo.properties
        dS.createFile(userProfilePath + username + "Info.properties");
        dS.writeProfileInfo(username, password, sID, UInp.userAge, userProfilePath + username + "Info.properties");

    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }

    private void generateID() {
        Random rand = new Random();
        int UpperBound = 10000;
        ID = rand.nextInt(UpperBound);
        sID = Integer.toString(ID);
    }

    private void parseProperties(String userProfileUsername) {
        try (InputStream fileInput = new FileInputStream(userProfileUsername)) {
            prop.load(fileInput);
        } catch (IOException io) {
            io.printStackTrace();
        }

        dS.parseBoolean(prop.getProperty("db.checkDOB"));
        checkDOB = dS.parsedBoolean;
        dS.parseBoolean(prop.getProperty("db.balanceAlerts"));
        balanceAlerts = dS.parsedBoolean;
        dS.parseBoolean(prop.getProperty("db.lockNewAccounts"));
        lockNewAccounts = dS.parsedBoolean;
        dS.parseBoolean(prop.getProperty("db.allowForeignCurrency"));
        allowForeignCurrency = dS.parsedBoolean; 
    }
}
