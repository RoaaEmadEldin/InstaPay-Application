package Account;

import API.BankAPI;
import API.WalletAPI;
import Account.BillManager.Bill.Bill;

public class WalletAccountUser extends UserAccount {

    public WalletAccountUser(String userName, String phoneNumber, int bankingID,String password) {
        super(userName,phoneNumber ,bankingID,password );
    }

    @Override
    public double inquireBalance() {
        return (double) WalletAPI.getUser("id", bankingID).get("balance");
    }

    @Override
    public Boolean withdraw(double amount) {
        if (inquireBalance() >= amount)
            return WalletAPI.setUserBalance(bankingID, amount);
        return false;
    }

    @Override
    public Boolean deposite(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposite'");
    }
}
