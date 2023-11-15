package Account.Transferring;

import API.BankAPI;
import Account.UserAccount;
import Account.WalletAccountUser;
import java.util.Map;

public class BankTransfer extends Transferring {
    WalletAccountUser recipient;
    String cardNumber;

    public BankTransfer(UserAccount sender, String cardNumber) {
        super(sender);
        this.cardNumber = cardNumber;
    }

    private Boolean validateCardRecipient(String CardNo) {
        if (!BankAPI.Cardexists(cardNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean transfer(double transferredMoney) {
        if (!validateAmount(transferredMoney)) {
            System.out.println(
                    "You CAN'T transfer such amount of money because your balance is LESS THAN it, your balance is: "
                            + sender.inquireBalance());
            return false;
        }

        if (!validateCardRecipient(cardNumber)) {
            System.out.println("Recipient's Card number does not exist.");
            return false;
        }

        // Retrieve recipient's account information
        Map<String, Object> recipientInfo = BankAPI.getUser("cardNumber", cardNumber);

        if (recipientInfo != null) {
            // Perform the transfer operation
            sender.withdraw(transferredMoney);
            BankAPI.setUserBalance(cardNumber, (double) recipientInfo.get("balance") + transferredMoney);

            System.out.println(
                    "Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
            return true;
        } else {
            System.out.println("Error: Unable to retrieve recipient's account information.");
            return false;
        }
    }
}
