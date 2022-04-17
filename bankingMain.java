// bankingMain.java
// Adam Weibler
// Immanuel Weidman
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

        // Implement dataStorage class
        dataStorage dS = new dataStorage();

        boolean homeScreenRepeat = true;

        // Create/Check file for profile login

        
        do {
            org.ClearScreen();
            HS.startScreen();
            UInp.getMenuInput(3,1);
            switch (UInp.userInput) {
                case 1: 
                dS.createFile("ProfileLogin.txt");
                ///System.out.println("* User chose to open an existing profile *\n");
                if (dS.fileIsEmpty == true) {
                    org.ClearScreen();
                    System.out.println ("* No profiles exist. Please create a new profile *");
                    bankProf.createProfile();
                } else bankProf.openProfile();
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
        } while (homeScreenRepeat);      
    }
}
