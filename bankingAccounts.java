// bankingAccounts.java
// Immanuel Weidman 
// Store the different banking accounts
// Created: 4/14/22

import java.util.*;

public class bankingAccounts {
    public String accName;
    private String account = "Test1";
    private double balance = 1;
    private boolean DOBCheckValid;
    private boolean ableToCreateAccount;

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void newAccount(boolean lockNewAccounts, boolean checkDOB, int age, String username) {
        ableToCreateAccount = false;
        if (lockNewAccounts == false) {
            if (checkDOB) {
                if (age < 16) {
                    System.out.println("* User is too young to create an account *");
                    try {Thread.sleep(3000);} catch (InterruptedException ex) {}
                    ableToCreateAccount = false;
                } else {
                    System.out.println(" DEBUG:: User is able to create an account");
                    try {Thread.sleep(3000);} catch (InterruptedException ex) {}
                    ableToCreateAccount = true;
                }
            }
            if (checkDOB == false) {
                System.out.println(" DEBUG:: User is able to create an account");
                try {Thread.sleep(3000);} catch (InterruptedException ex) {}
                ableToCreateAccount = true;
            }
        } else {
            System.out.println("* You are not allowed to create accounts *");
            try {Thread.sleep(3000);} catch (InterruptedException ex) {}
            ableToCreateAccount = false;
        }

        if (ableToCreateAccount) {
            createAccount(username);
        }
    }

    public void openAccount() {
        HS.accountHP(account, balance);
        UInp.getMenuInput(5, 1);
    }

    private void createAccount (String username) {
        HS.newAccountHP();
        UInp.getMenuInput(2,1);
        switch (UInp.userInput) {
            case 1:
            System.out.print("\n|Create your account name |\n" +
                           "Input: ");
            accName = input.nextLine();

            System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
            UInp.getUserInputBalance(0);

            dS.createFile("Profiles/" + username + "/Accounts/" + accName + ".properties");
            break;

            case 2:
            break;
        }
    }
}

        /* Move to Account
        System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
        UInp.getUserInputBalance(0);
        */

                //System.out.println("* Your balance is: $" + UInp.userInputBalance + " *");