// bankingProfile.java
// Adam Weibler
// Allow the user to create and open profiles
// Created: 4/12/22

import java.util.Scanner;

public class bankingProfile {
    private String username;
    private String password;
    private String phoneNumber;
    private String birthday;
    private double balance;

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement homeScreen class
    homeScreen HS = new homeScreen();
    
    // Implement organization class
    organization org = new organization();

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
    }

    public void createProfile() {
        
    }

    public void profile(String username, String password) {
        System.out.println("\n* Username: " + username + " *\n" + 
                           "* Password: " + password + " *\n");
    }
}
