package Database;

import Account.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class InstaPayDatabase {
    private static List<UserAccount> accounts = new ArrayList<>();

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