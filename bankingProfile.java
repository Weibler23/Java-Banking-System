// bankingProfile.java
// Adam Weibler
// Allow the user to create and open profiles
// Created: 4/12/22

import java.util.Scanner;
import java.util.Random;

public class bankingProfile {
    private String username;
    private String password;
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

    public void generateID() {
        Random rand = new Random();
        int UpperBound = 10000;
        ID = rand.nextInt(UpperBound);
    }

    public void openProfile() {
        System.out.print("\n|Enter your username |\n" +
                           "Input: ");
        username = input.nextLine();

        System.out.print("\n|Enter your password |\n" +
                           "Input: ");
        password = input.nextLine();

        org.ClearScreen();
        HS.profileHP(username);
        HS.getMenuInput(4, 1);
        switch (HS.userInput) {
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

            // DEBUG
            System.exit(0);

            break;
            case 4:
            System.out.println("* User chose to return to home page *\n");
            break;
        }
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
        phoneNumber = input.nextLine();

        System.out.print("\n|Enter your birthday (DD/MM/YY) |\n" +
                           "Input: ");
        birthday = input.nextLine();

        System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
        balance = input.nextDouble();
        input.nextLine();
        
        generateID();
        System.out.println("\n* Your profile ID is: " + ID + " *\n");

        System.out.println("* Enter any key to move on *");
        String str = input.nextLine();
    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }
}
