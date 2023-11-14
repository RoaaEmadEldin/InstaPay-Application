package Account.BillManager.Bill;

import java.util.Date;

public class WaterBill extends Bill {

    public WaterBill(String id, double price, Date dueDate) {
        super(id, price, dueDate);
        providor = Providor.WATER;
    }

}
