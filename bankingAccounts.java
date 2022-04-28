// bankingAccounts.java
// Immanuel Weidman 
// Store the different banking accounts
// Created: 4/14/22

public class bankingAccounts {
    private String account = "Test1";
    private double balance = 1;

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void newAccount(boolean lockNewAccounts, boolean checkDOB) {
        if (lockNewAccounts) {
            System.out.println("* You are not able to create new accounts at this time *");
        } else if (checkDOB) {
            
            HS.newAccountHP();
            UInp.getMenuInput(3,1);
        }
    }

    public void openAccount() {
        HS.accountHP(account, balance);
        UInp.getMenuInput(5, 1);
    }

    private void createAccount(boolean checkDOB, boolean balanceAlerts, String accountType, String profileUsername) {

    }
}

        /* Move to Account
        System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
        UInp.getUserInputBalance(0);
        */

                //System.out.println("* Your balance is: $" + UInp.userInputBalance + " *");