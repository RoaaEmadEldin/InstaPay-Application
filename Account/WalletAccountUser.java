package Account;

import API.WalletAPI;

public class WalletAccountUser extends UserAccount {

    public WalletAccountUser(String userName, String phoneNumber, String bankingID) {
        super(userName, phoneNumber, bankingID);
    }

    @Override
    public double inquireBalance() {
        return (double) WalletAPI.getUser("id", bankingID).get("balance");
    }

    @Override
    public Boolean withdraw(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    @Override
    public Boolean deposite(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposite'");
    }

}
