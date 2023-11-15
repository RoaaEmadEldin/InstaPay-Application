package Authentication;

import API.BankAPI;
import API.WalletAPI;
import Account.UserAccount;
import Account.WalletAccountUser;

public class WalletAuthentication extends Authentication {
    public WalletAuthentication(String phoneNumber) {
        super(phoneNumber);
    }

    public boolean verifyInfo() {
        if (!WalletAPI.exists(phoneNumber)) {
            System.out.println("Please Check PhoneNumber");
            return false;
        }
        if (!verifyPhoneNumber()) {
            System.out.println("Please Enter Correct OTP");
            return false;
        }
        return true;
    }

    @Override
    public UserAccount createAccount(String username, String password) {
        return new WalletAccountUser(username, phoneNumber, password);
    }
}