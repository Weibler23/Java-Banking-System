// dataStorage.java
// Adam Weibler
// manage usernames, passwords, ID#s, etc.
// Created 4/17/22

import java.io.*;

public class dataStorage {
    public boolean fileIsEmpty;

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
}
