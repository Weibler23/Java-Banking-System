// bankingMain.java
// Adam Weibler
// 
// Java final banking system
// Created: 4/12/22

public class bankingMain {
    public static void main(String[] args) {
        // Implement homeScreen class
	    homeScreen HS = new homeScreen();

        // Implement bankingProfile class
        bankingProfile bankProf = new bankingProfile();

        // Implement organization class
        organization org = new organization();

        // Implement userInputs class
        userInputs UInp = new userInputs();

        boolean homeScreenRepeat = true;

        do {
            org.ClearScreen();
            HS.startScreen();
            UInp.getMenuInput(3,1);
            switch (UInp.userInput) {
                case 1: 
                ///System.out.println("* User chose to open an existing profile *\n");
                bankProf.openProfile();
                break;
                case 2:
                //System.out.println("* User chose to create a new profile *\n");
                bankProf.createProfile();
                break;
                case 3:
                System.out.println("* User chose to exit the program *\n");
                homeScreenRepeat = false;
                break;
           }
        } while (homeScreenRepeat == true);        
    }
}
