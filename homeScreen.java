// homeScreen.java
// Adam Weibler
// Store all home screens throughout the program
// Created: 4/12/22

import java.util.*;
import java.io.*;

public class homeScreen {
public int userInput = 0;

    private static void Frame (int num, boolean newLine) {
	for (int i = 1; i <= num; i ++){
	    System.out.print ('-');
	} if (newLine) System.out.print("\n");
    }

	public int getMenuInput(int topBound, int lowBound) {
		// Create scanner object
		Scanner input = new Scanner(System.in);
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

    public void profileHP (String profName) {
	Frame(40, true); 
	System.out.format("|%-38s|%n", profName);
	Frame(40, true);
	System.out.print("|Enter (1) to see existing accounts    |\n" +
					 "|Enter (2) to open an existing account |\n" +
					 "|Enter (3) to create a new account     |\n" +
					 "|Enter (4) to return to home page      |\n");
	Frame(40, true);
	System.out.print("Input: ");
    }

    public void accountHP (String accName, double balance) {
	Frame(44, true);
	System.out.format("|%-42s|%n", accName);
	System.out.format("|$%-41.2f|%n", balance);
	Frame(44, true);
	System.out.print("|Enter (1) to transfer money               |\n" +
					 "|Enter (2) to take out loan (If available) |\n" +
					 "|Enter (3) to view all transfers           |\n" +
					 "|Enter (4) to close account                |\n" +
					 "|Enter (5) to return to profile home page  |\n");
	Frame(44, true);
	System.out.print("Input: ");
    }
}
