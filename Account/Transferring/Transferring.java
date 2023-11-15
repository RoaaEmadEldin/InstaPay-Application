package Account.Transferring;

import java.util.*;

import Account.UserAccount;

public class Transferring {
    // String SourceAccountType;
    // String DestAccountType;
    UserAccount sender;

    public Transferring(UserAccount sender) {
        this.sender = sender;
    }

    // public void AccValidation(String source, String dest) {
    // if (dest.equals("bank") && !source.equals("bank")) {
    // throw new UnsupportedOperationException("The account you want to transfer
    // from is NOT a bank account; hence, you CAN'T transfer to a bank account\n");
    // }
    // }

    public Boolean Transfer(double transferredMoney, UserAccount recipient) {
        if (!validateAmount(transferredMoney))
            return false;

        sender.withdraw(transferredMoney);
        recipient.deposite(transferredMoney);

        System.out
                .println("Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
        return true;
    }

    private Boolean validateAmount(double transferredMoney) {
        return sender.inquireBalance() >= transferredMoney;
    }
}
