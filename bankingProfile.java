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
    private String phoneNumber;
    private String birthday;
    private int ID = 0;

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement homeScreen class
    homeScreen HS = new homeScreen();

    // Implement organization class
    organization org = new organization();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    // Implement account class
    bankingAccounts Acc = new bankingAccounts();

    private void generateID() {
        Random rand = new Random();
        int UpperBound = 10000;
        ID = rand.nextInt(UpperBound);
        sID = Integer.toString(ID);
    }

    public void openProfile() {
        boolean profileHS = true;

        System.out.print("\n|Enter your username |\n" +
                           "Input: ");
        UInp.getUserInputSecurity("username", username);

        System.out.print("\n|Enter your password |\n" +
                           "Input: ");
        UInp.getUserInputSecurity("password", password);

        do {
            org.ClearScreen();
<<<<<<< Updated upstream
            HS.profileHP(username, ID);
=======
            HS.profileHP(dS.username, dS.sID);
>>>>>>> Stashed changes
            UInp.getMenuInput(4, 1);
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

        System.out.print("\n|Enter your phone number |\n" +
                           "Input: ");
        UInp.getUserInputString("1234", false);
        phoneNumber = UInp.userInputString;

        System.out.print("\n|Enter your birthday (MM-dd-yyyy) |\n" +
                           "Input: ");
        UInp.getDOB();
        
        org.ClearScreen();
        generateID();
        System.out.println("\n* Your profile was created *\n" +
                             "* Profile ID: " + ID + " *\n" +
                             "* Username: " + username + " *\n" +
                             "* Password: " + password + " *\n\n" +
                             "**---------------------------------WARNING---------------------------------**\n" +
                             "* There is no way to recover a forgotten username, password, or profile ID. *\n" +
                             "*                   Please make sure to write these down!                   *\n"+
                             "**-------------------------------------------------------------------------**\n");
        System.out.print("* Type 'next' to move on *\nInput: ");
        UInp.getUserInputString("next", false);
<<<<<<< Updated upstream
=======

        dS.writeProfileLogin(username, password, sID);
>>>>>>> Stashed changes
    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }
}
