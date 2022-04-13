// bankingMain.java
// Adam Weibler
// 
// Java final banking system
// Created: 4/12/22

public class bankingMain {
    public static void main(String[] args) {
        // Implement menu class
	    homeScreen HS = new homeScreen();

        HS.startScreen();
        HS.getMenuInput(3,0);
        switch (HS.userInput) {
            case 1: 
            System.out.println("* User chose to open an existing profile *\n");
            break;
            case 2:
            System.out.println("* User chose to create a new profile *\n");
            break;
            case 3:
            System.out.println("* User chose to exit the program *\n");
            break;
        }
    }
}
