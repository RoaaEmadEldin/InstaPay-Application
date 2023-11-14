import java.util.ArrayList;
import java.util.List;

import API.BankAPI;
import API.WalletAPI;
import Account.BankAccountUser;
import Account.UserAccount;
import Account.WalletAccountUser;
import Account.BillManager.Bill.Bill;

public class App {
    public static void main(String[] args) {
        System.out.println(BankAPI.getUser("id", "1"));
        System.out.println(WalletAPI.getUser("id", "5"));

        UserAccount bankAccount = new BankAccountUser("usf_insta", "12345678901", "1");
        UserAccount walletAccount = new WalletAccountUser("usf_insta", "12345678905", "5");

        System.out.println(bankAccount.inquireBalance());
        System.out.println(walletAccount.inquireBalance());

        for (Bill bill : bankAccount.getBills()) {
            System.out.println(bill);
        }
        System.out.println();
        System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        System.out.println(bankAccount.inquireBalance());
        System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        System.out.println(bankAccount.inquireBalance());
        System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        System.out.println(bankAccount.inquireBalance());
        System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        System.out.println(bankAccount.inquireBalance());

        for (Bill bill : bankAccount.getBills()) {
            System.out.println(bill);
        }

        System.out.println();
        for (Bill bill : walletAccount.getBills()) {
            System.out.println(bill);
        }

    }
}