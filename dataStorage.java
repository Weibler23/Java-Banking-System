// dataStorage.java
// Adam Weibler
// manage usernames, passwords, ID#s, etc.
// Created 4/17/22

import java.io.*;
import java.util.*;

public class dataStorage {
    public boolean fileIsEmpty;
    public boolean found = false;
    public boolean parsedBoolean;
    private Scanner x;

    Properties prop = new Properties();

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

    public boolean profileSettings() {
        prop.setProperty("db.checkDOB", "checkDOB");
        prop.setProperty("db.binaryFiles", "binaryFiles");

        prop.keySet();

        prop.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

        return true;
    }

    public void writeProfileSettings(boolean checkDOB, boolean binaryFiles) {
        try (OutputStream output = new FileOutputStream("profileSettings.properties")) {
            String str1 = Boolean.toString(checkDOB);
            String str2 = Boolean.toString(binaryFiles);
            prop.setProperty("db.checkDOB", str1);
            prop.setProperty("db.binaryFiles", str2);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void parseBoolean(String Str1) {
        System.out.println(" DEBUG:: Str1 = |" + Str1 + "|");
        parsedBoolean = true;
        parsedBoolean = Boolean.parseBoolean(Str1);
        System.out.println(" DEBUG:: parsedBoolean = " + parsedBoolean);
        //return parsedBoolean;
    }
}
