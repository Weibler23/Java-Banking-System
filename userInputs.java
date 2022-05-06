// userInputs.java
// Adam Weibler
// Class to handle input checks for user inputs
// Created 4/12/22

import java.util.*;
import java.io.*;
import java.text.*;
import java.time.*;

public class userInputs {
    public boolean invalidProfLogin = true;
    public String username;
    public String password; 
    public String profID; 
    public String userInputString = "Wrong";
    public double userInputBalance = 0;
    public Date userDOB = null;
    public int userInput = 0;
    public int userAge;
    public char userInputChar;
    private String userSecurity = "Wrong";
    private String accountName;
    private String accountPath;
    private String DOB; 
    private String dateFormat = "MM-dd-yyyy";
    public boolean fileExists;

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
                Date d = userDOB;
                Calendar c = Calendar.getInstance();
                c.setTime(d);
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH) + 1;
                int date = c.get(Calendar.DATE);
                LocalDate l1 = LocalDate.of(year, month, date);
                LocalDate now1 = LocalDate.now();
                Period diff1 = Period.between(l1, now1);
                userAge = diff1.getYears();
                //System.out.println(" DEBUG:: userAge = " + userAge);
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
				failCheck = true;
			}
            input.nextLine();
		} while (failCheck);
		return 0;
	}

    public double getUserInputBalance(double lowbound, double highbound) {
        boolean failCheck = false;
        do {
            try {
                userInputBalance = input.nextDouble();
                if ((userInputBalance < lowbound) || (userInputBalance > highbound)) throw new IOException("Exceeds Bounds");
                failCheck = false;
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid input *\nInput: ");
                failCheck = true;
            }
            input.nextLine();
        } while (failCheck);
        return 0;
    }

    public String getUserInputSecurity(String securityFilePath) {
        invalidProfLogin = true;
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
            System.out.println("\n* ERROR: Your username, password, or profile ID# was wrong. Please try again *");
            try {Thread.sleep(1500);} catch (InterruptedException ex) {}
                //System.out.println(" DEBUG:: username = |" + username + "|\n" +
                //                   " DEBUG:: password = |" + password + "|\n" +
                //                   " DEBUG:: profID = |" + profID + "|\n");
            invalidProfLogin = true;
        } else {
            invalidProfLogin = false;
        }
        return userSecurity;
    }

    public String getUserInputAccount(String username, String accName) {
        fileExists = false;
        accountPath = ("Profiles/" + username + "/Accounts/" + accName + "/" + accName + ".properties");
        //System.out.println(" DEBUG:: accountPath: |" + accountPath + "|");

        dS.checkifFileExists("Profiles/" + username + "/Accounts/" + accName + "/" + accName + ".properties");
        fileExists = dS.fileExists; 
        //System.out.println(" DEBUG:: fileExists = |" + fileExists + "|");
        return accountPath;
    }

    public char getUserInputChar(char char1, char char2) {
        boolean failCheck = false;
        do {
            try {
                userInputChar = input.next().charAt(0);
                //System.out.println(" DEBUG:: userInputChar = |" + userInputChar + "|");
                if (((Objects.equals(userInputChar, char1)) || (Objects.equals(userInputChar, char2))) == false) throw new IOException("Exceeds Bounds");
                failCheck = false;
            } catch (Exception e) {
                System.out.print("* ERROR: Please enter a valid input *\nInput: ");
                failCheck = true;
            }
        input.nextLine();
        } while (failCheck);
        return char1;
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
