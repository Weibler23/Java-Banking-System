// bankingMain.java
// Adam Weibler
// Immanuel Weidman
// Java final banking system
// Created: 4/12/22

public class bankingMain {
    public static void main(String[] args) {
        boolean homeScreenRepeat = true;
        
        // Implement bankingProfile class
        bankingProfile bankProf = new bankingProfile();

        // Implement dataStorage class
        dataStorage dS = new dataStorage();

        // Implement homeScreen class
	    homeScreen HS = new homeScreen();

        // Implement organization class
        organization org = new organization();

        // Implement userInputs class
        userInputs UInp = new userInputs();

        dS.createFolder("Test");
        
        do {
            org.ClearScreen();
            HS.startScreen();
            UInp.getMenuInput(3,1);
            switch (UInp.userInput) {
                case 1: 
                // Create/Check file for profile login
                dS.createFile("ProfileLogin.txt");
                dS.checkFileisEmpty("ProfileLogin.txt");

                if (dS.fileIsEmpty == true) {
                    org.ClearScreen();
                    System.out.println ("* No profiles exist. Please create a new profile *");
                    bankProf.createProfile();
                } else bankProf.openProfile();
                break;

                case 2:
                bankProf.createProfile();
                break;

                case 3:
                System.out.println("* User chose to exit the program *\n");
                homeScreenRepeat = false;
                break;
           }
        } while (homeScreenRepeat);      
    }
}
