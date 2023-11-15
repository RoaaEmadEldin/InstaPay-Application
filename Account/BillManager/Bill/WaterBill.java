package Account.BillManager.Bill;

import java.util.Date;

import API.BillProvidor.ProvidorAPI;

public class WaterBill extends Bill {

    public WaterBill(String id, double price, Date dueDate, ProvidorAPI providor) {
        super(id, price, dueDate, providor);
    }

}
