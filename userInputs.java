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
<<<<<<< Updated upstream
=======
    public String username;
    private String password; 
    private String profID; 
>>>>>>> Stashed changes
    public String userInputString = "Wrong";
    public int userInput = 0;
    public double userInputBalance = 0;
    public Date userDOB = null;

    // Create scanner object
    Scanner input = new Scanner(System.in);

<<<<<<< Updated upstream
=======
    // Implement dataStorage class
    dataStorage dS = new dataStorage();

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
    public String getUserInputSecurity(String securityFilePath) {
            System.out.print("\n|Enter your username |\n" +
                             "Input: ");
            username = input.nextLine();

            System.out.print("\n|Enter your password |\n" +
                             "Input: ");
            username = input.nextLine();

            System.out.print("\n|Enter your profile ID# |\n" +
                             "Input: ");
            profID = input.nextLine();
        
            dS.verifyLogin(username, password, profID, securityFilePath);
            if (dS.found == false) {
                System.out.println("* ERROR: Your username or password was wrong. Please try again *\n\n");
            }
>>>>>>> Stashed changes
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
