package Authentication;

import API.WalletAPI;
import Account.UserAccount;
import Account.WalletAccountUser;
import Database.InstaPayDatabase;

public class WalletAuthentication extends Authentication {
    public WalletAuthentication() {
    }

    @Override
    public boolean verifyInfo(String phoneNumber) {
        return WalletAPI.getUser("phoneNumber", phoneNumber) != null;
    }

    @Override
    public UserAccount createAccount(String username, String phoneNumber, String bankingID, String password) {
        return new WalletAccountUser(username, phoneNumber, bankingID, password);
    }

    @Override
    public String getBankingID(String phoneNumber) {
        return (String) WalletAPI.getUser("phoneNumber", phoneNumber).get("id");
    }

}