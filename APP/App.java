import API.BankAPI;
import API.WalletAPI;

public class App {
    public static void main(String[] args) {
        System.out.println(BankAPI.getUser("id", "1"));
        System.out.println(WalletAPI.getUser("id", "5"));
    }
}