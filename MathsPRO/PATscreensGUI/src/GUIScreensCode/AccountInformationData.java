package GUIScreensCode;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT Data storage for account information
 */
import java.io.*;

public class AccountInformationData {

     // Variables to store the user's name and email
    private static AccountInformationData instance;
    private String name;
    private String email;

    private AccountInformationData() {
        //private constructor to prevent instantiation
        loadName(); //Load the saved user name on instance creation.
        loadEmail(); //Load the saved email on instance creation.
    }

     // Method to get the single instance of the class
    public static AccountInformationData getInstance() {
        if (instance == null) {
            instance = new AccountInformationData();
        }
        return instance;
    }

     // Getter for the name
    public String getName() {
        return name;
    }

    // Getter for the email
    public String getEmail() {
        return email;
    }

    // Setter for the name with a call to save the name to a file
    public void setName(String name) {
        this.name = name;
        saveName(); //to save the name when it is set

    }

    public void setEmail(String email) {
        this.email = email;
        saveEmail(); //to save the email when it is set.
    }

    // Method to save the name to a file
    private void saveName() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nameData.txt"))) {
            writer.write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save the email to a file
    private void saveEmail() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emailData.txt"))) {
            writer.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the name from a file
    private void loadName() {
        try (BufferedReader reader = new BufferedReader(new FileReader("nameData.txt"))) {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to load the email from a file
    private void loadEmail() {
        try (BufferedReader reader = new BufferedReader(new FileReader("emailData.txt"))) {
            email = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
