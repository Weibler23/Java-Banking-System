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

        boolean homeScreenRepeat = true;

        do {
            org.ClearScreen();
            HS.startScreen();
            HS.getMenuInput(3,1);
            switch (HS.userInput) {
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
