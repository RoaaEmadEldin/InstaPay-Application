package Database;

import Account.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class InstaPayDatabase implements ORM {
    private List<UserAccount> accounts = new ArrayList<>();

    @Override
    public void add(UserAccount user) {
        accounts.add(user);
    }
public int getnum(){
        return accounts.size();
}
    @Override
    public UserAccount get(String username) {
        for (UserAccount account : accounts) {
            if (account.getUserName().equals(username)) {
                return account;
            }
        }
        return null;
    }
}