package Authentication;

import Account.UserAccount;
import Database.InstaPayDatabase;

public abstract class Authentication {
    public Authentication() {
    }

    protected abstract boolean verifyInfo(String phoneNumber);

    public abstract UserAccount createAccount(String username, String phoneNumber, String bankingID, String password);

    public abstract String getBankingID(String phoneNumber);

    private boolean isUsernameUnique(String username) {

        return InstaPayDatabase.get(username) == null;
    }

    private boolean isStrongPassword(String password) {
        // The password must be at least 8 characters long and include at least one
        // uppercase letter, one lowercase letter, and one digit.
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password.matches(passwordRegex);
    }

    public boolean Signup(String username, String password, String phoneNumber) {
        if (!verifyInfo(phoneNumber))
            return false;

        OTP otp = new OTP();
        otp.sendCode(phoneNumber);
        if (!otp.verifyOTP())
            return false;

        if (isUsernameUnique(username)) {
            if (isStrongPassword(password)) {
                UserAccount user = createAccount(username, phoneNumber, getBankingID(phoneNumber), password);
                InstaPayDatabase.add(user);
                System.out.println("Registration successful!");
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

    public UserAccount login(String username, String password) {
        UserAccount user = InstaPayDatabase.get(username);

        if (user != null && isCorrectPassword(user, password)) {
            System.out.println("Login successful!");
            return user;
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    private boolean isCorrectPassword(UserAccount user, String enteredPassword) {
        return user != null && user.getPassword().equals(enteredPassword);
    }

};
