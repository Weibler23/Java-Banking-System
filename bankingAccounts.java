// bankingAccounts.java
// Adam Weibler
// Store the different banking accounts
// Created: 4/14/22

public class bankingAccounts {
    private String account = "Test1";
    private double balance = 1;

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void newAccount() {
        HS.newAccountHP();
        UInp.getMenuInput(3,1);
    }

    public void openAccount() {
        HS.accountHP(account, balance);
        UInp.getMenuInput(5, 1);
    }
}

        /* Move to Account
        System.out.print("\n|Enter your balance |\n" +
                           "Input: ");
        UInp.getUserInputBalance(0);
        */

                //System.out.println("* Your balance is: $" + UInp.userInputBalance + " *");