// dataStorage.java
// Adam Weibler
// manage usernames, passwords, ID#s, etc.
// Created 4/17/22

import java.io.*;
import java.util.*;
//import org.apache.commons.io.FileUtils;

public class dataStorage {
    public boolean fileIsEmpty;
    public boolean found = false;
    public boolean parsedBoolean;
    public boolean toggledSet;
    private Scanner x;

    // Create properties object
    Properties prop = new Properties();

    // File Manipulation
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
            //System.out.println(" DEBUG:: FILE: " + testFile.getName() + " is empty ");
            fileIsEmpty = true;
        } else {
            //System.out.println(" DEBUG:: FILE: " + testFile.getName() + " is not empty ");
            fileIsEmpty = false; 
        }
    }

    public void readFullFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) System.out.println(sc.nextLine());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
        } else {
            System.out.println(" DEBUG:: File: " + file.getName() + " could not be deleted ");
        }
    }

    private static void copyFile(File fileNameSource, File fileNameReplace) throws Exception {
        FileInputStream in = new FileInputStream(fileNameSource);
        FileOutputStream out = new FileOutputStream(fileNameReplace);
        try {
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (IOException e) {
        } finally {
            if (in != null) {
                in.close();
            } if (out != null) {
                out.close();
            }
        }
    }

    // Folder Manipulation
    public void createFolder (String folderName) {
        File createFolder = new File(folderName);
        boolean bool = createFolder.mkdirs();
        if(bool == false) System.out.println(" DEBUG:: ERROR CREATING FOLDER: " + createFolder.getName());
    }
    
    public void deleteFolder(String folderPath) {
        File file = new File (folderPath);
        deleteDirectory(file);
        file.delete();
    }

    private void deleteDirectory(File file) {
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            subfile.delete();
        }
    }

    // Security Files
    public void verifyLogin(String username, String password, String profID, String filepath) {
        found = false;
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

    public void removeLogin (String username, String password, String ID) throws Exception{
        createFile("delete.txt");
        try {
            FileWriter myWriter = new FileWriter("delete.txt");
            myWriter.write(username + "," + password + "," + ID + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(" DEBUG:: ERROR WRITING TO FILE ");
            e.printStackTrace();
        }

        try {
            PrintWriter pw = new PrintWriter("output.txt");
            BufferedReader br2 = new BufferedReader(new FileReader("delete.txt"));

            String line2 = br2.readLine();

            HashSet<String> hs = new HashSet<String>();

            while(line2 != null)
            {
                hs.add(line2);
                line2 = br2.readLine();
            }

            BufferedReader br1 = new BufferedReader(new FileReader("ProfileLogin.txt"));

            String line1 = br1.readLine();

            while(line1 != null)
            {
                if(!hs.contains(line1)) pw.println(line1);
                line1 = br1.readLine();
            }
            pw.flush();

            br1.close();
            br2.close();
            pw.close();

            File src = new File("output.txt");
            File rep = new File("ProfileLogin.txt");

            copyFile(src, rep);
            deleteFile("output.txt");
            deleteFile("delete.txt");

        } catch (IOException e) {
        }
    }

    // Property Files
    private boolean profileInfo() {
        prop.setProperty("db.username", "username");
        prop.setProperty("db.password", "password");
        prop.setProperty("db.profID", "profID");
        prop.setProperty("db.age", "age");

        prop.keySet();

        prop.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

        return true;
    }

    private boolean profileSettings() {
        prop.setProperty("db.checkDOB", "checkDOB");
        prop.setProperty("db.balanceAlerts", "balanceAlerts");
        prop.setProperty("db.lockNewAccounts", "lockNewAccounts");
        prop.setProperty("db.allowForeignCurrency", "allowForeignCurrency");
        //prop.setProperty("db.userAge", "0");

        prop.keySet();

        prop.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));

        return true;
    }

    public void writeProfileInfo(String username, String password, String profID, int age, String fileName) {
        try (OutputStream output = new FileOutputStream(fileName)) {
            String str1 = Integer.toString(age);
            prop.setProperty("db.username", username);
            prop.setProperty("db.password", password);
            prop.setProperty("db.profID", profID);
            prop.setProperty("db.age", str1);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void writeProfileSettings(boolean checkDOB, boolean balanceAlerts, boolean lockNewAccounts, boolean allowForeignCurrency, String fileName) {
        try (OutputStream output = new FileOutputStream(fileName)) {
            String str1 = Boolean.toString(checkDOB);
            String str2 = Boolean.toString(balanceAlerts);
            String str3 = Boolean.toString(lockNewAccounts);
            String str4 = Boolean.toString(allowForeignCurrency);
            prop.setProperty("db.checkDOB", str1);
            prop.setProperty("db.balanceAlerts", str2);
            prop.setProperty("db.lockNewAccounts", str3);
            prop.setProperty("db.allowForeignCurrency", str4);
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public boolean toggleSettings(boolean toggleSet, boolean checkDOB, boolean balanceAlerts, boolean lockNewAccounts, boolean allowForeignCurrency, boolean DOB, boolean LNA, boolean AFC, String fileName) {
        toggleSet = ! toggleSet; 
        //System.out.println(" DEBUG:: toggledSet = |" + toggleSet + "|");
        if (DOB == true) {
            //System.out.println(" DEBUG:: DOB is set to true");
            writeProfileSettings(toggleSet, balanceAlerts, lockNewAccounts, allowForeignCurrency, fileName);
        } else {
            //System.out.println(" DEBUG:: DOB is set to false");
            writeProfileSettings(checkDOB, toggleSet, lockNewAccounts, allowForeignCurrency, fileName);
        }
        if (LNA == true) {
            writeProfileSettings(checkDOB, balanceAlerts, toggleSet, allowForeignCurrency, fileName);
        } 
        if (AFC == true) {
            writeProfileSettings(checkDOB, balanceAlerts, lockNewAccounts, toggleSet, fileName);
        }

        return true;
    }

    // Parse Data
    public void parseBoolean(String Str1) {
        //System.out.println(" DEBUG:: Str1 = |" + Str1 + "|");
        parsedBoolean = true;
        parsedBoolean = Boolean.parseBoolean(Str1);
        //System.out.println(" DEBUG:: parsedBoolean = " + parsedBoolean);
    }
}
