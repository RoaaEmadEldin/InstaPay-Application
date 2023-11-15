package Account.Transferring;
import API.BankAPI;
import Account.UserAccount;
import Account.WalletAccountUser;
import java.util.Map;
public class BankTransfer {
    WalletAccountUser recipient;
    UserAccount sender;

    public BankTransfer(UserAccount sender) {
        this.sender = sender;
    }

    public Boolean transfer(double transferredMoney, String CardNo) {
        if (!validateAmount(transferredMoney))
        {
            System.out.println("You CAN'T transfer such amount of money because your balance is LESS THAN it, your balance is: " + sender.inquireBalance());
            return false;
        }

        if (!validateCardRecipient(CardNo))
        {
            System.out.println("Recipient's Card number does not exist.");
            return false;
        }

        // Retrieve recipient's account information
        Map<String, Object> recipientInfo = BankAPI.getUser("cardNumber", CardNo);

        if (recipientInfo != null) {
            // Perform the transfer operation
            sender.withdraw(transferredMoney);
            BankAPI.setUserBalance(CardNo, (double) recipientInfo.get("balance") + transferredMoney);

            System.out.println("Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
            return true;
        } else {
            System.out.println("Error: Unable to retrieve recipient's account information.");
            return false;
        }
    }

    private Boolean validateAmount(double transferredMoney)
    {
        return sender.inquireBalance() >= transferredMoney;
    }

    private Boolean validateCardRecipient(String CardNo) {
        if (!BankAPI.Cardexists(CardNo))
        {
            return false;
        }
        return true;
    }
}
