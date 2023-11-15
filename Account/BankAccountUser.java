package Account;

import API.BankAPI;

public class BankAccountUser extends UserAccount {

    String cardNumber;

    public BankAccountUser(String userName, String phoneNumber, String cardNumber, String password) {
        super(userName, phoneNumber, password);
        this.cardNumber = cardNumber;
    }

    @Override
    public double inquireBalance() {
        return (double) BankAPI.getUser("cardNumber", cardNumber).get("balance");
    }

    @Override
    public Boolean withdraw(double amount) {
        amount = Math.abs(amount);
        if (inquireBalance() >= amount)
            return BankAPI.setUserBalance(cardNumber, inquireBalance() - amount);
        return false;
    }

    @Override
    public Boolean deposite(double amount) {
        amount = Math.abs(amount);
        return BankAPI.setUserBalance(cardNumber, inquireBalance() + amount);
    }
}
