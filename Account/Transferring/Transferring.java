package Account.Transferring;

import Account.UserAccount;

public abstract class Transferring {
    UserAccount sender;

    public Transferring(UserAccount sender) {
        this.sender = sender;
    }

    public abstract Boolean transfer(double transferredMoney);

    protected Boolean validateAmount(double transferredMoney) {
        return sender.inquireBalance() >= transferredMoney;
    }
}
