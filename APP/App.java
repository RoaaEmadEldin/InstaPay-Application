import Account.BankAccountUser;
import Account.UserAccount;
import Account.WalletAccountUser;

public class App {
    public static void main(String[] args) {
        // System.out.println(BankAPI.getUser("id", "1"));
        // System.out.println(WalletAPI.getUser("id", "5"));

        UserAccount bankAccount = new BankAccountUser("usf_bank", "12345678901", "1111 1111 1111 1111", "Hhreoi123@");
        UserAccount walletAccount = new WalletAccountUser("usf_wallet", "12345678905", "Hhreoi123@");

        // System.out.println(bankAccount.inquireBalance());
        // System.out.println(walletAccount.inquireBalance());

        // for (Bill bill : bankAccount.getBills()) {
        // System.out.println(bill);
        // }
        // System.out.println();
        // System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        // System.out.println(bankAccount.inquireBalance());
        // System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        // System.out.println(bankAccount.inquireBalance());
        // System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        // System.out.println(bankAccount.inquireBalance());
        // System.out.println(bankAccount.payBill(bankAccount.getBills().get(0)));
        // System.out.println(bankAccount.inquireBalance());

        // for (Bill bill : bankAccount.getBills()) {
        // System.out.println(bill);
        // }

        // System.out.println();
        // for (Bill bill : walletAccount.getBills()) {
        // System.out.println(bill);
        // }

        // Authentication auth = new WalletAuthentication();
        // auth.Signup("usf_3md", "Hh1@3i14ufjaoqewifj", "12345678905");

        // UserAccount account = auth.login("usf_3md", "Hh1@3i14ufjaoqewifj");
        // if (account != null) {
        // System.out.println(account.inquireBalance());
        // }

        bankAccount.transfer(500, walletAccount);

        System.out.println(bankAccount.inquireBalance());
        System.out.println(walletAccount.inquireBalance());
    }
}