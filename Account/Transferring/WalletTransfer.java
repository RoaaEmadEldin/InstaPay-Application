package Account.Transferring;

import API.WalletAPI;
import Account.UserAccount;
import Account.WalletAccountUser;
import java.util.Map;
public class WalletTransfer {
    WalletAccountUser recipient;
    UserAccount sender;

    public WalletTransfer(UserAccount sender) {
        this.sender = sender;
    }

    public Boolean transfer(double transferredMoney, String phoneRecipient) {
        if (!validateAmount(transferredMoney))
        {
            System.out.println("You CAN'T transfer such amount of money because your balance is LESS THAN it, your balance is: " + sender.inquireBalance());
            return false;
        }

        if ( !validatePhoneRecipient(phoneRecipient))
        {
            System.out.println("Recipient's phone number does not exist in the system OR doesn't have a Wallet on this number.");
            return false;
        }

        // Retrieve recipient's account information
        Map<String, Object> recipientInfo = WalletAPI.getUser("phoneNumber", phoneRecipient);

        if (recipientInfo != null) {
            // Perform the transfer operation
            sender.withdraw(transferredMoney);
            WalletAPI.setUserBalance(phoneRecipient, (double) recipientInfo.get("balance") + transferredMoney);

            System.out.println("Transferring is done Successfully, and your current Balance is: " + sender.inquireBalance());
            return true;
        } else {
            System.out.println("Error: Unable to retrieve recipient's account information.");
            return false;
        }
    }

    private Boolean validateAmount(double transferredMoney) {
        return sender.inquireBalance() >= transferredMoney;
    }

    private Boolean validatePhoneRecipient(String phoneRecipient) {
        if (!WalletAPI.exists(phoneRecipient)) {
            return false;
        }
        return true;
    }
}

