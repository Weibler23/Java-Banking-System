// homeScreenMain.java
// Adam Weibler
// TEST Program to run the home screens
// Created: 4/12/22

public class homeScreenMain {
    public static void main(String args[]) {
	// Implement menu class
	homeScreen HS = new homeScreen();

	// Start Screen
	HS.startScreen();

	System.out.println();
	
	// Profile Home Page
	HS.profileHP("Test Prof Home");

	System.out.println();

	// Account Home Page
	HS.accountHP("Test Acc Home", 69.42);
    }
}
