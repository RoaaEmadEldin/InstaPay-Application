import API.BankAPI;
import API.WalletAPI;
import Account.BankAccountUser;
import Account.UserAccount;
import Account.WalletAccountUser;

public class App {
    public static void main(String[] args) {
        System.out.println(BankAPI.getUser("id", "1"));
        System.out.println(WalletAPI.getUser("id", "5"));

        UserAccount bankAccount = new BankAccountUser("usf_insta", "01010101", "1");
        UserAccount walletAccount = new WalletAccountUser("usf_insta", "01010101", "5");

        System.out.println(bankAccount.inquireBalance());
        System.out.println(walletAccount.inquireBalance());
    }
}