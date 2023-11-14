package Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.BillManager;
import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.Providor;

public abstract class UserAccount {
    protected String userName;
    protected String phoneNumber;
    protected String bankingID;
    protected BillManager billManager;

    public UserAccount(String userName, String phoneNumber, String bankingID) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.bankingID = bankingID;
        this.billManager = new BillManager(phoneNumber);
    }

    public abstract double inquireBalance();

    public abstract Boolean withdraw(double amount);

    public abstract Boolean deposite(double amount);

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBankingID() {
        return bankingID;
    }

    public Boolean payBill(Bill bill) {
        if (inquireBalance() >= bill.getPrice()) {
            return withdraw(bill.getPrice()) && billManager.payBill(bill);
        }
        return false;
    }

    public List<Bill> getBills() {
        return billManager.getBills();
    }
}
