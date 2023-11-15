package Authentication;

import API.BankAPI;
import Account.BankAccountUser;
import Account.UserAccount;

public class BankAuthentication extends Authentication {

    public BankAuthentication() {
    }

    @Override
    public boolean verifyInfo(String phoneNumber) {
        return BankAPI.getUser("phoneNumber", phoneNumber) != null;
    }

    @Override
    public UserAccount createAccount(String username, String phoneNumber, String bankingID, String password) {
        return new BankAccountUser(username, phoneNumber, bankingID, password);
    }

    @Override
    public String getBankingID(String phoneNumber) {
        return (String) BankAPI.getUser("phoneNumber", phoneNumber).get("id");
    }

}
