// homeScreen.java
// Adam Weibler
// Store all home screens throughout the program
// Created: 4/12/22

import java.util.*;
import java.io.*;

public class homeScreen {
	// Implement bankingSettings class
	//bankingSettings bankSettings = new bankingSettings();

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";

    private static void Frame (int num, boolean newLine) {
		for (int i = 1; i <= num; i ++){
		    System.out.print ('-');
		} if (newLine) System.out.print("\n");
    }
    
    public void startScreen () {
		Frame(40, true);
		System.out.print("|                MW Bank               |\n");
		Frame(40, true);
		System.out.print("|Enter (1) to open an existing profile |\n" +
						 "|Enter (2) to create a new profile     |\n" +
						 "|Enter (3) to exit                     |\n");
		Frame(40, true);
		System.out.print("Input: ");
    }

	public void settingsHP (String profName, boolean checkDOB, boolean binaryFiles) {
		Frame(43, true);
		System.out.format("|%-41s|%n", profName);
		Frame(43, true);
		System.out.print("|Enter (1) to see settings information    |\n");
		if (checkDOB == true) {System.out.format("|Enter (2) to toggle checkDOB:: " + ANSI_GREEN + "%-14s|%n", checkDOB + ANSI_RESET);
		} else {
			System.out.format("|Enter (2) to toggle checkDOB:: " + ANSI_RED + "%-14s|%n", checkDOB + ANSI_RESET);
		}
		if (binaryFiles == true) {System.out.format("|Enter (3) to toggle binaryFiles:: " + ANSI_GREEN + "%-11s|%n", binaryFiles + ANSI_RESET);	
		} else {
			System.out.format("|Enter (3) to toggle binaryFiles:: " + ANSI_RED + "%-11s|%n", binaryFiles + ANSI_RESET);
		}
		System.out.print("|Enter (4) to delete profile              |\n");
		System.out.print("|Enter (5) to return to profile home page |\n");
		Frame(43, true);
		System.out.print("Input: ");
	}

    public void profileHP (String profName, String profID) {
		Frame(40, true); 
		System.out.format("|%-38s|%n", profName);
		System.out.format("|Profile ID: %-26s|%n", profID);
		Frame(40, true);
		System.out.print("|Enter (1) to see existing accounts    |\n" +
						 "|Enter (2) to open an existing account |\n" +
						 "|Enter (3) to create a new account     |\n" +
						 "|Enter (4) to enter profile settings   |\n" +
						 "|Enter (5) to return to home page      |\n");
		Frame(40, true);
		System.out.print("Input: ");
    }

    public void accountHP (String accName, double balance) {
		Frame(44, true);
		System.out.format("|%-42s|%n", accName);
		System.out.format("|$ %-40.2f|%n", balance);
		Frame(44, true);
		System.out.print("|Enter (1) to transfer money               |\n" +
						 "|Enter (2) to take out loan (If available) |\n" +
						 "|Enter (3) to view all transfers           |\n" +
						 "|Enter (4) to close account                |\n" +
						 "|Enter (5) to return to profile home page  |\n");
		Frame(44, true);
		System.out.print("Input: ");
    }

	public void newAccountHP () {
		Frame(42, true);
		System.out.print("|Enter (1) to create a Test no BOD check account  |\n" +
						 "|Enter (2) to create a Test BOD check.    account |\n" +
						 "|Enter (3) to exit                                |\n");
		Frame(42, true);
		System.out.print("Input: ");
	}
}
