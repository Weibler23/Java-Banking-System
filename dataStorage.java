// dataStorage.java
// Adam Weibler
// manage usernames, passwords, ID#s, etc.
// Created 4/17/22

import java.io.*;
import java.util.*;

public class dataStorage {
    public boolean fileIsEmpty;
    public boolean found = false;
    private Scanner x;

    public void createFile (String fileName) {
        try {
            File createFile = new File(fileName);
            if (createFile.createNewFile()) {
                System.out.println(" DEBUG:: File Created: " + createFile.getName());
            } else {
                System.out.println(" DEBUG:: File " + createFile.getName() + " already exists ");
            }
        } catch (IOException e) {
            System.out.println(" DEBUG:: ERROR CREATING FILE ");
            e.printStackTrace();
        }
    }

    public void checkFileisEmpty (String fileName) {
        File testFile = new File(fileName);
        if (testFile.length() == 0) {
            System.out.println(" DEBUG:: FILE: " + testFile.getName() + " is empty ");
            fileIsEmpty = true;
        } else {
            System.out.println(" DEBUG:: FILE: " + testFile.getName() + " is not empty ");
            fileIsEmpty = false; 
        }
    }

    public void writeProfileLogin (String username, String password, String ID) {
        try {
            FileWriter myWriter = new FileWriter("ProfileLogin.txt", true);
            myWriter.write(username + "," + password + "," + ID + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(" DEBUG:: ERROR WRITING TO FILE ");
            e.printStackTrace();
        }
    }

    public void verifyLogin(String username, String password, String profID, String filepath) {
        String tempUsername = "";
        String tempPassword = "";
        String tempProfID = "";
        try {
            x = new Scanner (new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                tempUsername = x.next();
                tempPassword = x.next();
                tempProfID = x.next();

                if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()) && tempProfID.trim().equals(profID.trim())) {
                    found = true;
                }
            }
        } catch (Exception e) {
        }
    }
}
