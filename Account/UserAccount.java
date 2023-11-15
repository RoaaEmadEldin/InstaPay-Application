package Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.BillManager;
import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.Providor;
import Account.Transferring.Transferring;

public abstract class UserAccount {
    protected String userName;
    protected String password;
    protected String phoneNumber;
    protected BillManager billManager;
    protected Transferring transferring;

    public UserAccount(String userName, String phoneNumber, String password) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.billManager = new BillManager(phoneNumber);
        this.transferring = new Transferring(this);
    }

    public abstract double inquireBalance();

    public abstract Boolean withdraw(double amount);

    public abstract Boolean deposite(double amount);

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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

    public Boolean transfer(double amount, UserAccount recipient) {
        return transferring.Transfer(amount, recipient);
    }
}
