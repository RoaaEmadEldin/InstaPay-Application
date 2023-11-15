package Account.BillManager.Bill;

import java.util.Date;

import API.BillProvidor.ProvidorAPI;

public class ElectricityBill extends Bill {

    public ElectricityBill(String id, double price, Date dueDate, ProvidorAPI providor) {
        super(id, price, dueDate, providor);
    }

}
