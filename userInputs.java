// userInputs.java
// Adam Weibler
// Class to handle input checks for user inputs
// Created 4/12/22

import java.util.*;
import java.io.*;

public class userInputs {
    private String userSecurity;
    public int userInput = 0;
    public double userInputBalance = 0;

    // Create scanner object
    Scanner input = new Scanner(System.in);

    public int getMenuInput(int topBound, int lowBound) {
		boolean failCheck = false;
		do {
			try {
				userInput = input.nextInt();
				if ((userInput > topBound) || (userInput < lowBound)) throw new IOException("Exceeds Bounds");				
				failCheck = false;
			} catch (Exception e) {
				System.out.print("* ERROR: Please enter a valid input *\nInput: ");
				input.nextLine();
				failCheck = true;
			}
		} while (failCheck);
		return 0;
	}

    public double getUserInputBalance(double lowbound) {
        boolean failCheck = false;
        do {
            try {
                userInputBalance = input.nextDouble();
                if (userInputBalance < lowbound) throw new IOException("Exceeds Bounds");
                failCheck = false;
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid input *\nInput: ");
                input.nextLine();
                failCheck = true;
            }
        } while (failCheck);
        return 0;
    }

    public String getUserInputSecurity(String security) {
        boolean failCheck = false;
        System.out.println("DEBUG:: String security = " + security);
        do {
            try {
                input.next();
                userSecurity = input.nextLine();
                if (userSecurity != security) throw new IOException ("Incorrect Input");
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid username *\nInput: ");
                input.nextLine();
                failCheck = true;
            }
        } while (failCheck);
        return "0";
    }
}
