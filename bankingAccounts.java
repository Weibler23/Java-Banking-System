// bankingAccounts.java
// Immanuel Weidman 
// Store the different banking accounts
// Created: 4/14/22

public class bankingAccounts {
    private String account = "Test1";
    private double balance = 1;
    private boolean DOBCheckValid;

    // Implement homeScreen class
    homeScreen HS = new homeScreen(); 

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void newAccount(boolean lockNewAccounts, boolean checkDOB, int age) {
        if (lockNewAccounts == false) {
            if (checkDOB) {
                if (age < 16) {
                    System.out.println("* User is too young to create an account *");
                    try {Thread.sleep(7000);} catch (InterruptedException ex) {}
                } else {
                    System.out.println(" DEBUG:: User is able to create an account");
                    try {Thread.sleep(7000);} catch (InterruptedException ex) {}
                }
            }
            if (checkDOB == false) {
                System.out.println(" DEBUG:: User is able to create an account");
                try {Thread.sleep(7000);} catch (InterruptedException ex) {}
            }
        } else {
            System.out.println("* You are not allowed to create accounts *");
            try {Thread.sleep(7000);} catch (InterruptedException ex) {}
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