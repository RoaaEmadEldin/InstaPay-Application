package Account.Transferring;

import Account.UserAccount;

public class AccountTransfer extends Transferring {
    UserAccount recipientAccount;

    public AccountTransfer(UserAccount sender, UserAccount recipientAccount) {
        super(sender);
        this.recipientAccount = recipientAccount;
    }

    @Override
    public Boolean transfer(double transferredMoney) {
        {
            if (!validateAmount(transferredMoney))
                return false;

            if (recipientAccount != null) {
                sender.withdraw(transferredMoney);
                recipientAccount.deposite(transferredMoney);
                System.out.println(
                        "Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
                return true;
            } else {
                System.out.println("Recipient with username " + recipientAccount.getUserName() + " does not exist.");
                return false;
            }
        }
    }

}
