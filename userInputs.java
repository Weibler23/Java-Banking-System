// userInputs.java
// Adam Weibler
// Class to handle input checks for user inputs
// Created 4/12/22

import java.util.*;
import java.io.*;
import java.text.*;

public class userInputs {
    private String userDate;
    private String userSecurity = "Wrong";
    public String userInputString = "Wrong";
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

    public String getUserInputSecurity(String securityType, String security) {
        boolean failCheck = false;
        do {
            try {
                userSecurity = input.nextLine();
                if (Objects.equals(security, userSecurity) == false) throw new IOException ("Incorrect Input");
                failCheck = false;
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid " + securityType + "*\nInput: ");
                failCheck = true;
            }
        } while (failCheck);
        return userSecurity;
    }

    public String getUserInputString(String reqInput, boolean clearLine) {
		boolean failCheck = false;
        if (clearLine) input.nextLine();
		do {
			try {
				userInputString = input.nextLine();
				if (Objects.equals(userInputString, reqInput) == false) throw new IOException ("Incorrect Input");				
				failCheck = false;
			} catch (Exception e) {
				System.out.print("* ERROR: Please enter a valid input *\nInput: ");
				failCheck = true;
			}
		} while (failCheck);
		return userInputString;
	}
}
