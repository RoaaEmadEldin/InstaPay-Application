package Database;

import Account.UserAccount;

public interface ORM {
    void add(UserAccount user);

    UserAccount get(String username);
}