package Account.Transferring;

import java.util.*;
import Account.UserAccount;
import Database.InstaPayDatabase;

public class Transferring {
    UserAccount sender;

    public Transferring(UserAccount sender)
    {
        this.sender = sender;
    }

    public Boolean Transfer(double transferredMoney, String recipientUsername) {
        if (!validateAmount(transferredMoney))
            return false;

        UserAccount recipient = InstaPayDatabase.get(recipientUsername);

        if (recipient != null) {
            sender.withdraw(transferredMoney);
            recipient.deposite(transferredMoney);
            System.out.println("Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
            return true;
        } else {
            System.out.println("Recipient with username " + recipientUsername + " does not exist.");
            return false;
        }
    }

    private Boolean validateAmount(double transferredMoney) {
        return sender.inquireBalance() >= transferredMoney;
    }
}
