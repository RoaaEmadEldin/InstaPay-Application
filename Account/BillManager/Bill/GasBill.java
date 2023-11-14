package Account.BillManager.Bill;

import java.util.Date;

public class GasBill extends Bill {

    public GasBill(String id, double price, Date dueDate) {
        super(id, price, dueDate);
        providor = Providor.GAS;
    }

}
