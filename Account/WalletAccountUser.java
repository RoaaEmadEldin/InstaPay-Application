package Account;

import API.WalletAPI;

public class WalletAccountUser extends UserAccount {
    public WalletAccountUser(String userName, String phoneNumber, String password) {
        super(userName, phoneNumber, password);
    }

    @Override
    public double inquireBalance() {
        return (double) WalletAPI.getUser("phoneNumber", phoneNumber).get("balance");
    }

    @Override
    public Boolean withdraw(double amount) {
        if (inquireBalance() >= amount)
            return WalletAPI.setUserBalance(phoneNumber, inquireBalance() - amount);
        return false;
    }

    @Override
    public Boolean deposite(double amount) {
        amount = Math.abs(amount);
        return WalletAPI.setUserBalance(phoneNumber, inquireBalance() + amount);
    }
}
