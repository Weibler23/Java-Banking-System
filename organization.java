// organization.java
// Adam Weibler
// Create a program that contains the menu and new screen objects in a seperate class and use them in the main class
// Created 1/24/22
// Modified 1/24/22

public class organization
{
    //Frame
    public static void Frame (int num, boolean newLine)
    {
	for (int i = 1; i <= num; i ++)
	    {
		System.out.print ('-');
	    } if (newLine) System.out.print("\n");
    }

    //ClearScreen
    public static void ClearScreen ()
    {
	for (int i = 1; i <= 100; i++)
	    {
		System.out.print('\n');
	    }
    }
}
