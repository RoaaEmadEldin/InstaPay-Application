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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withdraw'");
    }

    @Override
    public Boolean deposite(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deposite'");
    }

}
