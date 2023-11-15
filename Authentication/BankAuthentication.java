package Authentication;

import API.BankAPI;
import Account.BankAccountUser;
import Account.UserAccount;

import java.util.Scanner;

public class BankAuthentication extends Authentication{
    private String bankID;

    BankAuthentication(String phone, String bankID){
        this.phoneNumber = phone;
        this.bankID = bankID;
    }

    @Override
    public Boolean verifyInfo() {
        return BankAPI.exists(bankID, phoneNumber);
    }

    // The username and password are taken in the main before the otp is sent
    @Override
    public Boolean Signup(String username, String password) {
        if (isUsernameUnique(username)) {
            if (isStrongPassword(password)) {
                UserAccount user = new BankAccountUser(username, phoneNumber, bankID, password);
                database.add(user);
                System.out.println("Registration Successful!");
                return true;
            } else {
                System.out.println("Password is not strong. Please choose a stronger password.");
                return false;
            }
        } else {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }
    }

}
