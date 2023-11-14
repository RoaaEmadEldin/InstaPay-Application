package Account.Transferring;
import API.BankAPI;
public class BankTransfer extends Transferring
{
    private String source, dest;
    public BankTransfer(String source, String dest, double transferredMoney)
    {
        super(source, dest, transferredMoney);
        this.source = source;
        this.dest = dest;
    }
    public void MoneyValidation(double transferredMoney)
    {
        if (transferredMoney > (double) BankAPI.getUser("id", source).get("balance"))
        {
            throw new UnsupportedOperationException("You CAN'T transfer this amount of money; it is MORE THAN your account balance");
        }
    }
    public void Transfer(double transferredMoney)
    {
        double srcCurrentBalance = (double) BankAPI.getUser("id", source).get("balance");
        srcCurrentBalance -= transferredMoney;
        double destCurrentBalance = (double) BankAPI.getUser("id", dest).get("balance");
        destCurrentBalance += transferredMoney;
        BankAPI.setUserBalance(source, srcCurrentBalance);
        BankAPI.setUserBalance(dest, destCurrentBalance);
        System.out.println("Transferring is done Successfully, and your current Balance is: " + srcCurrentBalance);
    }
}
