// bankingTransfers.java
// Immanuel Weidman
// Manage transfers between and in banking accounts
// Created: 4/17/22

import java.util.*;
import java.io.*;

public class bankingTransfers {
    private double newBalance;
    private double newBalanceTransfer;
    private double transferBalance;
    private String SBalance;
    private String accountPath;
    private String accNameTransfer;
    private String accountPathTransfer;
    private boolean validBalance;

    // Create scanner object
	Scanner input = new Scanner(System.in);

    // Create properties object
    Properties prop = new Properties();

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement organization class
    organization org = new organization();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void transferMoney(String username, String accName, double balance) {
        accountPath = ("Profiles/" + username + "/Accounts/" + accName + "/" + accName + ".properties");

        HS.transferHP();
        UInp.getMenuInput(4,1);
        switch (UInp.userInput) {
            case 1:
            System.out.print("\n|Enter the amount you want to add |\n" +
                             "Input: ");
            UInp.getUserInputBalance(0, 1000000000);
            newBalance = balance + UInp.userInputBalance;
            dS.writeAccountInfo(accName, newBalance, accountPath);
            dS.writeAccountTransfers(true, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
            //System.out.println(" DEBUG:: newBalance: " + newBalance);                        
            break;
    
            case 2:
            validBalance = true;
            System.out.print("\n|Enter the amount you want to remove |\n" +
                             "Input: ");
            UInp.getUserInputBalance(0, 100000000);
            newBalance = balance - UInp.userInputBalance;
            if (newBalance < 0) {
                System.out.println("* You do not have enough funds to remove that amount *");
                try {Thread.sleep(3000);} catch (InterruptedException ex) {}
            validBalance = false;
            } else {
                dS.writeAccountInfo(accName, newBalance, accountPath);
                dS.writeAccountTransfers(false, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
                //System.out.println(" DEBUG:: newBalance: " + newBalance);
            }
            break;
    
            case 3:
            System.out.print("\n|Enter the name of the account you want to interact with |\n" +
                             "Input: ");
            accNameTransfer = input.nextLine();
    
            accountPathTransfer = ("Profiles/" + username + "/Accounts/" + accNameTransfer + "/" + accNameTransfer + ".properties");
                                     
            UInp.getUserInputAccount(username, accNameTransfer);
            //System.out.println(" DEBUG:: dS.fileExists = |" + UInp.fileExists + "|");
            if (UInp.fileExists == true) {
                parseAccInfoTranfer(accountPathTransfer);
                HS.transferBetweenAccHP(accNameTransfer);
                UInp.getMenuInput(4,1);
                switch(UInp.userInput) {
                    case 1:
                    System.out.print("\n|Enter the amount you want to add |\n" +
                                     "Input: ");
                    UInp.getUserInputBalance(0, 1000000000);
                    
                    newBalance = balance - UInp.userInputBalance;
                    dS.writeAccountInfo(accName, newBalance, accountPath);
                    dS.writeAccountTransfers(false, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");

                    newBalanceTransfer = transferBalance + UInp.userInputBalance;
                    dS.writeAccountInfo(accNameTransfer, newBalanceTransfer, accountPathTransfer);
                    dS.writeAccountTransfers(true, transferBalance, UInp.userInputBalance, newBalanceTransfer, "Profiles/" + username + "/Accounts/" + accNameTransfer + "/" + accNameTransfer + " Transfers.txt");
                    //System.out.println(" DEBUG:: newBalance: " + newBalance);
                    break;
    
                    case 2:
                    validBalance = true;
                    System.out.print("\n|Enter the amount you want to remove |\n" +
                                     "Input: ");
                    UInp.getUserInputBalance(0, 100000000);
                    newBalance = balance + UInp.userInputBalance;
                    newBalanceTransfer = transferBalance - UInp.userInputBalance;
                    if ((newBalance < 0) || (newBalanceTransfer < 0)) {
                        System.out.println("* You do not have enough funds to remove that amount *");
                        try {Thread.sleep(3000);} catch (InterruptedException ex) {}
                    validBalance = false;
                    } else {
                        dS.writeAccountInfo(accName, newBalance, accountPath);
                        dS.writeAccountTransfers(true, balance, UInp.userInputBalance, newBalance, "Profiles/" + username + "/Accounts/" + accName + "/" + accName + " Transfers.txt");
                        //System.out.println(" DEBUG:: newBalance: " + newBalance);

                        dS.writeAccountInfo(accNameTransfer, newBalanceTransfer, accountPathTransfer);
                        dS.writeAccountTransfers(false, transferBalance, UInp.userInputBalance, newBalanceTransfer, "Profiles/" + username + "/Accounts/" + accNameTransfer + "/" + accNameTransfer + " Transfers.txt");
                    }
                    break;
    
                    case 3:
                    break;
                }
                } else {
                    System.out.println ("* That account does not exist. Please try again 2*");
                    try {Thread.sleep(3000);} catch (InterruptedException ex) {}
                    UInp.fileExists = true;
                }
            break;
    
            case 4:
            break;
        }
    }

    private void parseAccInfoTranfer(String accountPath) {
        try (InputStream fileInput = new FileInputStream(accountPath)) {
            prop.load(fileInput);
        } catch (IOException io) {
            io.printStackTrace();
        }

        SBalance = prop.getProperty("db.accountBalance");
        transferBalance = Double.parseDouble(SBalance);
    }
}
