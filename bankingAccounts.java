// bankingAccounts.java
// Immanuel Weidman 
// Store the different banking accounts
// Created: 4/14/22

import java.util.*;
import java.io.*;

public class bankingAccounts {
    public String accName;
    private String account = "Test1";
    private String accountPath;
    private String SBalance;
    private boolean accHS;
    private double balance = 1;
    private double newBalance;
    private boolean DOBCheckValid;
    private boolean ableToCreateAccount;

    // Create properties object
    Properties prop = new Properties();

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement organization class
    organization org = new organization();

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

    public void openAccount(String username) {
        System.out.print("\n|Enter the account name you want to open |\n" +
                         "Input: ");
        accName = input.nextLine();

        accountPath = ("Profiles/" + username + "/Accounts/" + accName + "/" + accName + ".properties");

        do {
            UInp.getUserInputAccount(username, accName);
            System.out.println(" DEBUG:: dS.fileExists = |" + UInp.fileExists + "|");
            if (UInp.fileExists == true) {
                parseAccInfo(accountPath);
            
                accHS = true;
                org.ClearScreen();
                HS.accountHP(accName, balance);
                UInp.getMenuInput(4, 1);
                switch (UInp.userInput) {
                    case 1:
                    HS.transferHP();
                    UInp.getMenuInput(3,1);
                    switch (UInp.userInput) {
                        case 1:
                        System.out.print("\n|Enter the amount you want to add |\n" +
                                         "Input: ");
                        UInp.getUserInputBalance(0);
                        newBalance = balance + UInp.userInputBalance;
                        dS.writeAccountInfo(accName, newBalance, accountPath);
                        dS.writeAccountTransfers(true, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
                        System.out.println(" DEBUG:: newBalance: " + newBalance);
                        break;

                        case 2:
                        System.out.print("\n|Enter the amount you want to remove |\n" +
                                         "Input: ");
                        UInp.getUserInputBalance(0);
                        newBalance = balance - UInp.userInputBalance;
                        dS.writeAccountInfo(accName, newBalance, accountPath);
                        dS.writeAccountTransfers(false, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
                        System.out.println(" DEBUG:: newBalance: " + newBalance);
                        break;

                        case 3:
                        break;
                    }
                    break;
                
                    case 2:
                    System.out.println();
                    dS.readFullFile("Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
                    System.out.println();
                    System.out.print("* Type 'next' to move on *\nInput: ");
                    UInp.getUserInputString("next", true);
                    break;

                    case 3:
                    System.out.print("* Are you sure you want to delete this account? ** THIS CANNOT BE UNDONE ** (y/n)\nInput: ");
                    UInp.getUserInputChar('y', 'n');
                    if (UInp.userInputChar == 'y') {
                        dS.deleteFolder("Profiles/" + username + "/Accounts/" + accName);
                        accHS = false;
                    } 
                    break;

                    case 4:
                    System.out.println("* User chose to return to profile home page *\n");
                    accHS = false;
                    break;
                }
            } else {
                System.out.println ("* That account does not exist. Please try again *");
                try {Thread.sleep(3000);} catch (InterruptedException ex) {}
            }
        } while (accHS == true);
    }

    private void createAccount(String username) {
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

            dS.createFolder("Profiles/" + username + "/Accounts/" + accName);

            accountPath = ("Profiles/" + username + "/Accounts/" + accName + "/" + accName + ".properties");
            dS.createFile(accountPath);
            dS.createFile("Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
            dS.writeAccountInfo(accName, UInp.userInputBalance, accountPath);
            break;

            case 2:
            break;
        }
    }

    private void parseAccInfo(String accountPath) {
        try (InputStream fileInput = new FileInputStream(accountPath)) {
            prop.load(fileInput);
        } catch (IOException io) {
            io.printStackTrace();
        }

        SBalance = prop.getProperty("db.accountBalance");
        balance = Double.parseDouble(SBalance);
    }
}
