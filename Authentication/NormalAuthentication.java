package Authentication;
import API.WalletAPI;
import Account.WalletAccountUser;
import Database.InstaPayDatabase;

public class NormalAuthentication extends Authentication {
    private WalletAPI wallet;
    private WalletAccountUser user;
    private  InstaPayDatabase database;

    public NormalAuthentication(String phoneNumber,OTP otp,WalletAPI wallet) {
        super(phoneNumber,otp);
        this.wallet=wallet;
    }
    @Override
    public boolean verifyInfo() {
        return wallet.getUser("phoneNumber", phoneNumber) != null;
    }

    @Override
    public boolean Signup(String username, String password) {
        int id=database.getnum();
        if (isUsernameUnique(username, database)) {
            if (isStrongPassword(password)) {
//userName,phoneNumber ,bankingID,password
                user =   new WalletAccountUser(username,phoneNumber,id++,password);
                database.add(user);
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


    private boolean isUsernameUnique(String username, InstaPayDatabase database) {

        return database.get(username) == null;
    }

    private boolean isStrongPassword(String password) {
        // The password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one digit.
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password.matches(passwordRegex);
    }


}