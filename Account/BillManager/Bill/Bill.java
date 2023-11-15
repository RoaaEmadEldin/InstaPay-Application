package Account.BillManager.Bill;

import java.util.ArrayList;
import java.util.Date;

import API.BillProvidor.ProvidorAPI;

public abstract class Bill {
    protected double price;
    protected Date dueDate;
    protected ProvidorAPI providor;
    protected String id;

    public Bill(String id, double price, Date dueDate, ProvidorAPI providor) {
        this.id = id;
        this.price = price;
        this.dueDate = dueDate;
        this.providor = providor;
    }

    public double getPrice() {
        return price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public ProvidorAPI getProvidor() {
        return providor;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return providor.toString() + ": " + price + " -> " + dueDate;
    }
}
