package Account;

public abstract class UserAccount {
    protected String userName;
    protected String phoneNumber;
    protected String bankingID;

    public UserAccount(String userName, String phoneNumber, String bankingID) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.bankingID = bankingID;
    }

    public abstract double inquireBalance();

    public abstract Boolean withdraw(double amount);

    public abstract Boolean deposite(double amount);

}
