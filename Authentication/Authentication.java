package Authentication;

import Account.UserAccount;
import Database.InstaPayDatabase;

public abstract class Authentication {
    protected String phoneNumber;
    private UserAccount user;
    private  InstaPayDatabase database;
    protected OTP otp;
    public Authentication(String phoneNumber,OTP otp) {
        this.phoneNumber = phoneNumber;
        this.otp = otp;
    }
    public abstract boolean verifyInfo() ;

    public abstract boolean Signup(String username, String password);

    public boolean login(String username, String password) {
        UserAccount user = database.get(username);

        if (user != null && isCorrectPassword( password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    private boolean isCorrectPassword( String enteredPassword) {
        return user != null && user.getPassword().equals(enteredPassword);
    }


};
