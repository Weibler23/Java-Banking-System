// bankingProfile.java
// Adam Weibler
// Allow the user to create and open profiles
// Created: 4/12/22

import java.util.Scanner;
import java.util.Random;

public class bankingProfile {
    public String username = "";
    public String password;
    private String phoneNumber;
    private String birthday;
    private double balance;
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
            HS.profileHP(username);
            UInp.getMenuInput(4, 1);
            switch (UInp.userInput) {
                case 1:
                System.out.println("* User chose to see all existing accounts *\n");

                // DEBUG
                System.exit(0);
                break;

                case 2:
                System.out.println("* User chose to open an account *\n");

                // DEBUG
                System.exit(0);
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

        System.out.print("\n|Enter your birthday (DD/MM/YY) |\n" +
                           "Input: ");
        birthday = input.nextLine();

        System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
        UInp.getUserInputBalance(0);
        
        generateID();
        System.out.println("\n* Your profile ID is: " + ID + " *");
        System.out.println("* Your balance is: $" + UInp.userInputBalance + " *");
        System.out.print("* Type 'next' to move on *\nInput: ");
        UInp.getUserInputString("next", true);
    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }
}
