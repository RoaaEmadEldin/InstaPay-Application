package Authentication;

import API.BankAPI;
import Account.BankAccountUser;
import Account.UserAccount;

public class BankAuthentication extends Authentication {
    String cardNumber;

    public BankAuthentication(String phoneNumber, String cardNumber) {
        super(phoneNumber);
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean verifyInfo() {
        if (!BankAPI.exists(cardNumber, phoneNumber)) {
            System.out.println("Please Check Card Number or PhoneNumber");
            return false;
        }
        if (!verifyPhoneNumber()) {
            System.out.println("Please Enter Correct OTP");
            return false;
        }
        return true;
    }

    @Override
    public UserAccount createAccount(String username, String password) {
        return new BankAccountUser(username, phoneNumber, cardNumber, password);
    }

}
