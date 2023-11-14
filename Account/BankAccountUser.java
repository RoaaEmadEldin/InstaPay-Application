package Account;

import API.BankAPI;

public class BankAccountUser extends UserAccount {

    public BankAccountUser(String userName, String phoneNumber, String bankingID) {
        super(userName, phoneNumber, bankingID);
    }

    @Override
    public double inquireBalance() {
        return (double) BankAPI.getUser("id", bankingID).get("balance");
    }

    @Override
    public Boolean withdraw(double amount) {
        amount = Math.abs(amount);
        if (inquireBalance() >= amount)
            return BankAPI.setUserBalance(bankingID, inquireBalance() - amount);
        return false;
    }

    @Override
    public Boolean deposite(double amount) {
        amount = Math.abs(amount);
        return BankAPI.setUserBalance(bankingID, inquireBalance() + amount);
    }
}
