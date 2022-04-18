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
    private String DOB; 
    private String dateFormat = "MM-dd-yyyy";
    public String username;
    public String password; 
    public String profID; 
    public String userInputString = "Wrong";
    public int userInput = 0;
    public double userInputBalance = 0;
    public Date userDOB = null;
    public boolean invalidProfLogin = true;

    // Create scanner object
    Scanner input = new Scanner(System.in);

    // Implement dataStorage class
    dataStorage dS = new dataStorage();

    public String getDOB() {
        boolean failCheck = false;
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        do {
            try{
                DOB = input.nextLine();
                userDOB = sdf.parse(DOB);
                failCheck = false;
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid date: *\nInput: ");
                failCheck = true;
            }
        } while (failCheck);
        return DOB;
    }

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

    public String getUserInputSecurity(String securityFilePath) {
        boolean failCheck = false;
        do {
            //input.next();
            System.out.print("\n|Enter your username |\n" +
                             "Input: ");
            username = input.nextLine();

            System.out.print("\n|Enter your password |\n" +
                             "Input: ");
            password = input.nextLine();

            System.out.print("\n|Enter your profile ID# |\n" +
                             "Input: ");
            profID = input.nextLine();
        
            dS.verifyLogin(username, password, profID, securityFilePath);
            if (dS.found == false) {
                System.out.println("* ERROR: Your username or password was wrong. Please try again *\n\n");
                System.out.println(" DEBUG:: username = |" + username + "|\n" +
                                   " DEBUG:: password = |" + password + "|\n" +
                                   " DEBUG:: profID = |" + profID + "|\n");
                failCheck = true;
            } else {
                failCheck = false;
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
