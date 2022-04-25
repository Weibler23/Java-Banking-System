// bankingProfile.java
// Adam Weibler
// Allow the user to create and open profiles
// Created: 4/12/22

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class bankingProfile {
    public String username = "";
    public String password;
    public String sID;
    private String birthday;
    private int ID = 0;
    public boolean profileHS = true;

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement account class
    bankingAccounts Acc = new bankingAccounts();

    // Implement bankingSettings class
    profileSettings profileSettings = new profileSettings();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen();

    // Implement organization class
    organization org = new organization();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    private void generateID() {
        Random rand = new Random();
        int UpperBound = 10000;
        ID = rand.nextInt(UpperBound);
        sID = Integer.toString(ID);
    }

    public void openProfile() {
        UInp.getUserInputSecurity("ProfileLogin.txt");

        do {
            org.ClearScreen();
            HS.profileHP(UInp.username, UInp.profID);
            UInp.getMenuInput(5, 1);
            dS.createFile(UInp.username + " ProfileSettings.properties");

            switch (UInp.userInput) {
                case 1:
                System.out.println("* User chose to see all existing accounts *\n");

                // DEBUG
                System.exit(0);
                break;

                case 2:
                System.out.println("* User chose to open an account *\n");
                Acc.openAccount();
                break;

                case 3:
                System.out.println("* User chose to open a new account *\n");
                Acc.newAccount();
                break;

                case 4:
                System.out.println("* User chose to enter profile settings *\n");
                do {
                    profileSettings.openSettings(UInp.username);
                } while (profileSettings.settingsRepeat == true);
                break;

                case 5:
                System.out.println("* User chose to return to home page *\n");
                profileHS = false;
                break;
            }
        } while (profileHS);
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
    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }
}
