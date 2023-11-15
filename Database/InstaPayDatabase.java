package Database;

import Account.BankAccountUser;
import Account.UserAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.String;

public class InstaPayDatabase {
    private static List<UserAccount> accounts = new ArrayList<>(
            Collections.singleton(new BankAccountUser("RoaaEmad", "01014425536", "1234 5678 9101 1121", "Roaa123#")));

    public static void add(UserAccount user) {
        accounts.add(user);
    }

    public static int getnum() {
        return accounts.size();
    }

    public static UserAccount get(String username) {
        for (UserAccount account : accounts) {
            if (account.getUserName().equals(username)) {
                return account;
            }
        }
        return null;
    }
}
