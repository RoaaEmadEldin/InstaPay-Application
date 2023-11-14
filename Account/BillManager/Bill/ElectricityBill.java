package Account.BillManager.Bill;

import java.util.Date;

public class ElectricityBill extends Bill {

    public ElectricityBill(String id, double price, Date dueDate) {
        super(id, price, dueDate);
        providor = Providor.Electricity;
    }

}
