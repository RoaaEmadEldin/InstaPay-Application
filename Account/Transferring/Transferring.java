package Account.Transferring;
import java.util.*;

public abstract class Transferring {
    // String SourceAccountType;
    double TransferredMoney;
    // String DestAccountType;

    public Transferring(String source, String dest, double transferredMoney) {
        this.SourceAccountType = source;
        this.DestAccountType = dest;
        this.TransferredMoney = transferredMoney;
    }

    // public void AccValidation(String source, String dest) {
    //     if (dest.equals("bank") && !source.equals("bank")) {
    //         throw new UnsupportedOperationException("The account you want to transfer from is NOT a bank account; hence, you CAN'T transfer to a bank account\n");
    //     }
    // }

    public void Transfer(double transferredMoney) {
        validateAmount(transferredMoney);

        double srcCurrentBalance = getSourceCurrentBalance();
        srcCurrentBalance -= transferredMoney;

        double destCurrentBalance = getDestCurrentBalance();
        destCurrentBalance += transferredMoney;

        updateSourceBalance(srcCurrentBalance);
        updateDestBalance(destCurrentBalance);

        System.out.println("Transferring is done Successfully, and your current Balance is: " + srcCurrentBalance);
    }

    protected abstract double getSourceCurrentBalance();

    protected abstract double getDestCurrentBalance();

    protected abstract void updateSourceBalance(double newBalance);

    protected abstract void updateDestBalance(double newBalance);

    private void validateAmount(double transferredMoney) {
        if (transferredMoney > getSourceCurrentBalance()) {
            throw new UnsupportedOperationException("You CAN'T transfer this amount of money; it is MORE THAN your account balance");
        }
    }
}
