// homeScreenMain.java
// Adam Weibler
// TEST Program to run the home screens
// Created: 4/12/22

public class TESThomeScreen {
    public static void main(String args[]) {
	// Implement menu class
	homeScreen HS = new homeScreen();

	// Start Screen
	HS.startScreen();

	System.out.println();
	
	// Profile Home Page
	String profTempName = "Test Profile Name";
	HS.profileHP(profTempName);

	System.out.println();

	// Account Home Page
	String accTempName = "Test Account Name";
	Double accTempBalance = 4444.44;
	HS.accountHP(accTempName, accTempBalance);
    }
}
