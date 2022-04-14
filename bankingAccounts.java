// bankingAccounts.java
// Adam Weibler
// Store the different banking accounts
// Created: 4/14/22

public class bankingAccounts {
    // Implement homeScreen class
    homeScreen HS = new homeScreen();

    // Implement userInputs class
    userInputs UInp = new userInputs();

    public void newAccount() {
        HS.newAccountHP();
        UInp.getMenuInput(4,1);
    }
}
