// dataStorage.java
// Adam Weibler
// manage usernames, passwords, ID#s, etc.
// Created 4/17/22

import java.io.*;
import java.util.*;

public class dataStorage {
    private static Scanner x;
    public boolean fileIsEmpty;
    public boolean found = false;

    public void createFile (String fileName) {
        try {
            File createFile = new File(fileName);
            if (createFile.createNewFile()) {
                System.out.println(" DEBUG:: File Created: " + createFile.getName());
            } else {
                System.out.println(" DEBUG:: File " + createFile.getName() + " already exists ");
                if (createFile.length() == 0) {
                    fileIsEmpty = true;
                } else {
                    fileIsEmpty = false;
                }
            }
        } catch (IOException e) {
            System.out.println(" DEBUG:: ERROR CREATING FILE ");
            e.printStackTrace();
        }
    }

    public void writeProfileLogin (String username, String password, int ID) {
        try {
            FileWriter myWriter = new FileWriter("ProfileLogin.txt");
            myWriter.write(username + "," + password + "," + ID);
            myWriter.close();
        } catch (IOException e) {
            System.out.println(" DEBUG:: ERROR WRITING TO FILE ");
            e.printStackTrace();
        }
    }

    public void verifyLogin(String username, String password, String filepath) {
        String tempUsername = "";
        String tempPassword = "";

        try {
            x = new Scanner (new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
        } catch (Exception e) {

        }
    }
}
